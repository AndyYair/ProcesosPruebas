package procesostest


import procesostest.*
import groovy.sql.Sql
import grails.converters.JSON
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FlujoController {
    
    def dataSource

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Flujo.list(params), model:[flujoInstanceCount: Flujo.count()]
    }

    def show(Flujo flujoInstance) {
        respond flujoInstance
    }

    def create() {
        respond new Flujo(params)
    }

    @Transactional
    def save(Flujo flujoInstance) {
        
        def nombrepromotora
        def nombrecompania
        def prom = Promotora.executeQuery("SELECT nombre FROM Promotora WHERE id=$params.idpromotora")
        prom.each{
            nombrepromotora = it
        }
        def comp = Compania.executeQuery("SELECT nombcomp FROM Compania WHERE numeprom=$params.idpromotora AND numcomp = $params.idcompania")
        comp.each{
            nombrecompania = it
        }       
        def nomenclatura
        nomenclatura = params.idpromotora+'-'+nombrepromotora+params.idcompania+'-'+nombrecompania
        flujoInstance.nomenclatura = nomenclatura
        println(flujoInstance.nomenclatura)
        
        
        if (flujoInstance == null) {
            notFound()
            return
        }

        /*if (flujoInstance.hasErrors()) {
            respond flujoInstance.errors, view:'create'
            return
        }*/

        flujoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'flujoInstance.label', default: 'Flujo'), flujoInstance.id])
                redirect flujoInstance
            }
            '*' { respond flujoInstance, [status: CREATED] }
        }
    }

    def edit(Flujo flujoInstance) {
        respond flujoInstance
    }

    @Transactional
    def update(Flujo flujoInstance) {
        if (flujoInstance == null) {
            notFound()
            return
        }

        if (flujoInstance.hasErrors()) {
            respond flujoInstance.errors, view:'edit'
            return
        }

        flujoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Flujo.label', default: 'Flujo'), flujoInstance.id])
                redirect flujoInstance
            }
            '*'{ respond flujoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Flujo flujoInstance) {

        if (flujoInstance == null) {
            notFound()
            return
        }

        flujoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Flujo.label', default: 'Flujo'), flujoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'flujoInstance.label', default: 'Flujo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
     def getCompanias() {
        Integer numprom = params.idpromotora.toInteger()
        def companias = Compania.findAllWhere(numeprom: numprom)
        //def     companias = [type:companiasList]
        render(template: "compania", model: [list: companias])
    }
    
    def common(){
        
        def flujo
        def secuencia
        def procesos
        def reglas
        
         println("Entrando al metodo FlujoController:common"+"\n------------------------------------------------")
         
        flujo = Flujo.executeQuery("SELECT id FROM Flujo WHERE idpromotora = $params.idpromotora AND idcompania = $params.idcompania")
        println("Flujo correspondiente: "+flujo)
        render("Flujo correspondiente: "+flujo+"<br>")
            if(flujo==[]){
                render("No hay un flujo definido para $params.idpromotora - $params.idcompania")
                println("No hay un flujo definido para $params.idpromotora - $params.idcompania")
            }
        flujo.each{    //empieza el ciclo de flujos
            Flujo idflujo = Flujo.get(it)
            
            secuencia = SecFlujo.findByFid(idflujo)
            if(!secuencia){
                render("No hay definida una secuencia para el flujo: "+idflujo)
                println("No hay definida una secuencia para el flujo: "+idflujo)
            } else {
                    println("ID de la Secuencia: "+secuencia)
                    render("ID de la Secuencia: "+secuencia+"<br>")
                    List<String> secuenciaflujo = Arrays.asList(secuencia.secuencia.split("\\s*,\\s*")) //Convirtiendo el string en un ArrayList con el metodo "split", separa los elementos por coma, espacios o zeros
                    println("Procesos de la Secuencia: "+secuenciaflujo)

                                    secuenciaflujo.each{    //empieza el ciclo de secuencias de flujo
                                            Proceso pid = Proceso.get(it)
                                            if(!pid){
                                                render("No hay procesos definidos para la secuencia: "+it)
                                                println("No hay procesos definidos para la secuencia: "+it)
                                            }else{
                                                reglas = Regla.findByPid(pid)
                                                if(!reglas){
                                                    render("No hay reglas definidas para el proceso: "+pid)
                                                    println("No hay reglas definidas para el proceso: "+pid)
                                                }else{
                                                    println("\n")
                                                    println("Proceso: "+pid+"\n Regla(s): "+reglas.id+":"+reglas.descripcion)
                                                    render("Proceso: "+pid+"<br> Regla(s): "+reglas.id+":"+reglas.descripcion+"<br>")
                                                           
                                                         reglas.each{   //empieza el ciclo de reglas
                                                           println "Ejecutando sentencia de la regla"+"\n==================================="
                                                           println ""
                                                            
                                                            //String q = ("UPDATE $it.objAfe1 SET $it.attrAfe1 $it.operador1 $it.valorAsignado1 $it.condicion WHERE $it.objCond1.$it.attrCond1 $it.operadorCondicion $it.objCond2$it.attrCond2$it.valorCondicion2 $it.operadorEnlace ") 
                                                            String q = it.sql 
                                                            String q2
                                
                                                            while(it.operadorEnlace != null){
                                                                    println "Entrando al metodo de comprobacion de reglas"
                                                                    Regla rid = Regla.get(it.condicionEnlazada)
                                                                    q2 = ("$rid.objCond1.$rid.attrCond1 $rid.operadorCondicion $rid.objCond2$rid.attrCond2$rid.valorCondicion2 $rid.operadorEnlace ")
                                                                    q+=q2
                                                                    it.operadorEnlace = rid.operadorEnlace
                                                                    it.condicionEnlazada = rid.condicionEnlazada
                                                            } 
                                                             
                                                           String query = q.replaceAll("null", '')
                                                           query += ';'
                                                           println(query)
                                                            
                                                            
                                                            
                                                            
                                                            render(query+"<br>")
                                                            def sql = Sql.newInstance(dataSource) 
                                                            try {
                                                                sql.execute(query)
                                                                render("<strong>Query ejecutado!</strong> <br>")
                                                            } catch (Exception e){
                                                                render(e)
                                                                render("<br>")
                                                            }
                                                            
                                                            println "\n"
                                                        }
                                                  }
                                                
                                            }
                                    }
            }
        }
        
        //redirect(uri:'/')
         
    }
}

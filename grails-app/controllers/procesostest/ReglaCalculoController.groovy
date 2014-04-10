package procesostest


import groovy.sql.Sql
import groovy.util.Eval
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReglaCalculoController {
    def dataSource
    
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ReglaCalculo.list(params), model:[reglaCalculoInstanceCount: ReglaCalculo.count()]
    }

    def show(ReglaCalculo reglaCalculoInstance) {
        respond reglaCalculoInstance
    }

    def create() {
        respond new ReglaCalculo(params)
    }

    def tratarConceptos(){
        def numConceptos = params.cvalue
        int noConceptos = Integer.parseInt(numConceptos)
        println("getConceptos params: " + params)
        
        //if (!params.contador){ int cont = 0 }else{cont = params.contador as Integer}
        int cont = (params?.contador == null) ? 0 : params.contador as Integer
        
        for(;cont<noConceptos;cont++){
            
            println("concepto"+cont)
            render(template:"concept", model:[contador:cont])
            //render("<div id='concept"+cont+"'>
            //concepto"+cont+"<br>
            
            //</div>")
        }
        
    }
    
    @Transactional
    def presave(ReglaCalculo reglaCalculoInstance) {
        
        if (reglaCalculoInstance == null) {
            println(reglaCalculoInstance)
            notFound()
            return
        }
        
        int i=0
        String f, f2
        String checkboxes
        println("presave: "+params)        
        render("NumConceptos"+params.numConceptos+"<br>")
        //Declaramos variable que encuentra todos los checkboxes marcados
        params.checkboxes
        checkboxes = params.findAll{def x=it.key.startsWith("query_")}
        List<String> listCheckboxes = Arrays.asList(checkboxes.split("\\s*,\\s*")) //Convirtiendo el string en un ArrayList con el metodo "split", separa los elementos por coma, espacios o zeros
        def m
        String query
        def sql = Sql.newInstance(dataSource) 
        //recorremos primero los parametros que se marcaron (como query)
        listCheckboxes.eachWithIndex{ item, indez ->
                //render ("${indez} : ${item}")
                def matcher = item =~ "[0-9]+"
                matcher.each { 
                    render(it+"<-it<br>")  
                    m=it.toInteger()
                    //evaluar query para cid en esa posicion
                    render(m+":")
                    //render(this.params.opIni[m]+this.params.opt1[m]+this.params.cid[m]+this.params.opt2[m])            
                    render(this.params.cid[m]+"<br>")
                    query = this.params.cid[m]
                    
                    try {
                        //sql.execute(query)
                        sql.eachRow(query){ row ->
                            render("${row[0]}")
                            this.params.cid[m] = row[0]
                        }
                        render("<strong>Query ejecutado!</strong> <br>")
                    } catch (Exception e){
                        render(e)
                        render("<br>")
                    }                   
                }
        }//termina listCheckboxes
        
        def evalFormula
        render("<br>Concatenando formula:<br>")            
        params.contador.each{            
            render(this.params.opIni[i]+this.params.opt1[i]+this.params.cid[i]+this.params.opt2[i])
            evalFormula += this.params.opIni[i]+this.params.opt1[i]+this.params.cid[i]+this.params.opt2[i]
            i++;
        }   
        
        //  this.params.formulaExplicita
        String eval = evalFormula.replaceAll("null", '') //borramos nulos
        def resultado = Eval.me(eval)
        render("<br>Resultado: "+resultado)
        render("<br>Presave params: <br>"+params+"<br>")
               
    }
    
    def formaExplicita(ReglaCalculo reglaCalculoInstance){
         if (reglaCalculoInstance == null) {
            println(reglaCalculoInstance)
            notFound()
            return
        }
        
        int i=0
        String f, f2
        String checkboxes
        println("presave: "+params)        
        println("NumConceptos"+params.numConceptos+"\n")
        //Declaramos variable que encuentra todos los checkboxes marcados
        params.checkboxes
        checkboxes = params.findAll{def x=it.key.startsWith("query_")}
        List<String> listCheckboxes = Arrays.asList(checkboxes.split("\\s*,\\s*")) //Convirtiendo el string en un ArrayList con el metodo "split", separa los elementos por coma, espacios o zeros
        def m
        String query
        def sql = Sql.newInstance(dataSource) 
        //recorremos primero los parametros que se marcaron (como query)
        listCheckboxes.eachWithIndex{ item, indez ->
                //render ("${indez} : ${item}")
                def matcher = item =~ "[0-9]+"
                matcher.each { 
                    println(it+"<-checked\n")  
                    m=it.toInteger()
                    //evaluar query para cid en esa posicion
                    println(m+":")
                    //render(this.params.opIni[m]+this.params.opt1[m]+this.params.cid[m]+this.params.opt2[m])            
                    println(this.params.cid[m]+"\n")
                    query = this.params.cid[m]
                    //Sin ejecucion de query, hasta que se llame a ejecucion la regla, encerrar entre etiquetas #query los correspondientes
                    //try {
                        //sql.execute(query)
                        //sql.eachRow(query){ row ->
                        //    println("${row[0]}")
                            //this.params.cid[m] = row[0]
                            this.params.cid[m] = "#query"+this.params.cid[m]+"#query#"
                        //}
                        //println("<strong>Query ejecutado!</strong> <br>")
                    //} catch (Exception e){
                    //    println(e)
                    //    println("\n")
                    //}                   
                }
        }//termina listCheckboxes
        
        def evalFormula
        println("\nConcatenando formula:\n")            
        params.contador.each{            
            println(this.params.opIni[i]+this.params.opt1[i]+this.params.cid[i]+this.params.opt2[i])
            evalFormula += this.params.opIni[i]+this.params.opt1[i]+this.params.cid[i]+this.params.opt2[i]
            i++;
        }   
        
        //  this.params.formulaExplicita
        String formaExplicita = evalFormula.replaceAll("null", '') //borramos nulos
        this.params.formulaExplicita = formaExplicita
        //def resultado = Eval.me(formaExplicita)
        //println("\nResultado: "+resultado)
        //render("<br>Presave params: <br>"+params+"<br>")
        render(template: "concepto",  model:[formulaExplicita: formaExplicita]) 
    }
    
    @Transactional
    def save(ReglaCalculo reglaCalculoInstance) {
        if (reglaCalculoInstance == null) {
            notFound()
            return
        }

        if (reglaCalculoInstance.hasErrors()) {
            respond reglaCalculoInstance.errors, view:'create'
            return
        }

        reglaCalculoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reglaCalculoInstance.label', default: 'ReglaCalculo'), reglaCalculoInstance.id])
                redirect reglaCalculoInstance
            }
            '*' { respond reglaCalculoInstance, [status: CREATED] }
        }
    }

    def edit(ReglaCalculo reglaCalculoInstance) {
        respond reglaCalculoInstance
    }

    @Transactional
    def update(ReglaCalculo reglaCalculoInstance) {
        if (reglaCalculoInstance == null) {
            notFound()
            return
        }

        if (reglaCalculoInstance.hasErrors()) {
            respond reglaCalculoInstance.errors, view:'edit'
            return
        }

        reglaCalculoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ReglaCalculo.label', default: 'ReglaCalculo'), reglaCalculoInstance.id])
                redirect reglaCalculoInstance
            }
            '*'{ respond reglaCalculoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ReglaCalculo reglaCalculoInstance) {

        if (reglaCalculoInstance == null) {
            notFound()
            return
        }

        reglaCalculoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ReglaCalculo.label', default: 'ReglaCalculo'), reglaCalculoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reglaCalculoInstance.label', default: 'ReglaCalculo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

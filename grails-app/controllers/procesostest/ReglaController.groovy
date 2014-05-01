package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReglaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Regla.list(params), model:[reglaInstanceCount: Regla.count()]
    }

    def show(Regla reglaInstance) {
        respond reglaInstance
    }

    def create() {
        respond new Regla(params)
    }

    @Transactional
    def save(Regla reglaInstance) {
        if (reglaInstance == null) {
            notFound()
            return
        }

        if (reglaInstance.hasErrors()) {
            respond reglaInstance.errors, view:'create'
            return
        }

        reglaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reglaInstance.label', default: 'Regla'), reglaInstance.id])
                redirect reglaInstance
            }
            '*' { respond reglaInstance, [status: CREATED] }
        }
    }

    def edit(Regla reglaInstance) {
        respond reglaInstance
    }

    @Transactional
    def update(Regla reglaInstance) {
        if (reglaInstance == null) {
            notFound()
            return
        }

        if (reglaInstance.hasErrors()) {
            respond reglaInstance.errors, view:'edit'
            return
        }

        reglaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Regla.label', default: 'Regla'), reglaInstance.id])
                redirect reglaInstance
            }
            '*'{ respond reglaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Regla reglaInstance) {

        if (reglaInstance == null) {
            notFound()
            return
        }

        reglaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Regla.label', default: 'Regla'), reglaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reglaInstance.label', default: 'Regla'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
         def common(){
            println("Entrando al metodo ReglaController:common"+"\n------------------------------------------------")
            //String q = ("UPDATE $params.objAfe1 SET $params.attrAfe1 $params.operador1 $params.valorAsignado1 $params.condicion WHERE $params.objCond1.$params.attrCond1 $params.operadorCondicion $params.objCond2.$params.attrCond2$params.valorCondicion2 $params.operadorEnlace ") 
            String q = ("UPDATE $params.objAfe1 \n\
                        SET $params.attrAfe1 $params.operador1 $params.valorAsignado1 \n\
                        WHERE $params.objCond1.$params.attrCond1 $params.valorCondicion1  \n\
                        $params.objCond2.$params.attrCond2$params.valorCondicion2 $params.operadorEnlace ") 
            
            println("String conformado: "+q)
//            String q2
//            if(params.operadorEnlace){
//                            while(params.operadorEnlace != null){
//                                    //println "Entrando al metodo de comprobacion de reglas"
//                                    Regla rid = Regla.get(params.condicionEnlazada)
//                                    q2 = ("$rid.objCond1.$rid.attrCond1 $rid.operadorCondicion $rid.objCond2$rid.attrCond2$rid.valorCondicion2 $rid.operadorEnlace ")
//                                    q+=q2
//                                    params.operadorEnlace = rid.operadorEnlace
//                                    params.condicionEnlazada = rid.condicionEnlazada
//                            } 
//            }


           String query = q.replaceAll("null", '')
           String regex = '  \\.  '
           query = q.replaceAll(regex, '')
           render(template: "queryresult",  model:[resquery: query])                                                              
          }
}

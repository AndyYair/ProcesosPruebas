package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SecFlujoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SecFlujo.list(params), model:[secFlujoInstanceCount: SecFlujo.count()]
    }

    def show(SecFlujo secFlujoInstance) {
        respond secFlujoInstance
    }

    def create() {
        respond new SecFlujo(params)
    }

    @Transactional
    def save(SecFlujo secFlujoInstance) {
        if (secFlujoInstance == null) {
            notFound()
            return
        }

        if (secFlujoInstance.hasErrors()) {
            respond secFlujoInstance.errors, view:'create'
            return
        }

        secFlujoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'secFlujoInstance.label', default: 'SecFlujo'), secFlujoInstance.id])
                redirect secFlujoInstance
            }
            '*' { respond secFlujoInstance, [status: CREATED] }
        }

    }

    def edit(SecFlujo secFlujoInstance) {
        respond secFlujoInstance
    }

    @Transactional
    def update(SecFlujo secFlujoInstance) {
        if (secFlujoInstance == null) {
            notFound()
            return
        }

        if (secFlujoInstance.hasErrors()) {
            respond secFlujoInstance.errors, view:'edit'
            return
        }

        secFlujoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SecFlujo.label', default: 'SecFlujo'), secFlujoInstance.id])
                redirect secFlujoInstance
            }
            '*'{ respond secFlujoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SecFlujo secFlujoInstance) {

        if (secFlujoInstance == null) {
            notFound()
            return
        }

        secFlujoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SecFlujo.label', default: 'SecFlujo'), secFlujoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'secFlujoInstance.label', default: 'SecFlujo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    def getProcesos() {
        Flujo flujo = Flujo.get(params.fid) 
        def procesos = Proceso.findAllByFid(flujo)
        render(template: "proceso", model: [list: procesos])
    }

}

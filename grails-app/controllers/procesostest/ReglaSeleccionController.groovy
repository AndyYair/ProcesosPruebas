package procesostest



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ReglaSeleccionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ReglaSeleccion.list(params), model:[reglaSeleccionInstanceCount: ReglaSeleccion.count()]
    }

    def show(ReglaSeleccion reglaSeleccionInstance) {
        respond reglaSeleccionInstance
    }

    def create() {
        respond new ReglaSeleccion(params)
    }

    @Transactional
    def save(ReglaSeleccion reglaSeleccionInstance) {
        if (reglaSeleccionInstance == null) {
            notFound()
            return
        }

        if (reglaSeleccionInstance.hasErrors()) {
            respond reglaSeleccionInstance.errors, view:'create'
            return
        }

        reglaSeleccionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reglaSeleccionInstance.label', default: 'ReglaSeleccion'), reglaSeleccionInstance.id])
                redirect reglaSeleccionInstance
            }
            '*' { respond reglaSeleccionInstance, [status: CREATED] }
        }
    }

    def edit(ReglaSeleccion reglaSeleccionInstance) {
        respond reglaSeleccionInstance
    }

    @Transactional
    def update(ReglaSeleccion reglaSeleccionInstance) {
        if (reglaSeleccionInstance == null) {
            notFound()
            return
        }

        if (reglaSeleccionInstance.hasErrors()) {
            respond reglaSeleccionInstance.errors, view:'edit'
            return
        }

        reglaSeleccionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ReglaSeleccion.label', default: 'ReglaSeleccion'), reglaSeleccionInstance.id])
                redirect reglaSeleccionInstance
            }
            '*'{ respond reglaSeleccionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ReglaSeleccion reglaSeleccionInstance) {

        if (reglaSeleccionInstance == null) {
            notFound()
            return
        }

        reglaSeleccionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ReglaSeleccion.label', default: 'ReglaSeleccion'), reglaSeleccionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reglaSeleccionInstance.label', default: 'ReglaSeleccion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

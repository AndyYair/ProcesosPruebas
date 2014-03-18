package procesostest

import org.springframework.dao.DataIntegrityViolationException

class ProcesoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [procesoInstanceList: Proceso.list(params), procesoInstanceTotal: Proceso.count()]
    }

    def create() {
        [procesoInstance: new Proceso(params)]
    }

    def save() {
        def procesoInstance = new Proceso(params)
        if (!procesoInstance.save(flush: true)) {
            render(view: "create", model: [procesoInstance: procesoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'proceso.label', default: 'Proceso'), procesoInstance.id])
        redirect(action: "show", id: procesoInstance.id)
    }

    def show(Long id) {
        def procesoInstance = Proceso.get(id)
        if (!procesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'proceso.label', default: 'Proceso'), id])
            redirect(action: "list")
            return
        }

        [procesoInstance: procesoInstance]
    }

    def edit(Long id) {
        def procesoInstance = Proceso.get(id)
        if (!procesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'proceso.label', default: 'Proceso'), id])
            redirect(action: "list")
            return
        }

        [procesoInstance: procesoInstance]
    }

    def update(Long id, Long version) {
        def procesoInstance = Proceso.get(id)
        if (!procesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'proceso.label', default: 'Proceso'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (procesoInstance.version > version) {
                procesoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'proceso.label', default: 'Proceso')] as Object[],
                          "Another user has updated this Proceso while you were editing")
                render(view: "edit", model: [procesoInstance: procesoInstance])
                return
            }
        }

        procesoInstance.properties = params

        if (!procesoInstance.save(flush: true)) {
            render(view: "edit", model: [procesoInstance: procesoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'proceso.label', default: 'Proceso'), procesoInstance.id])
        redirect(action: "show", id: procesoInstance.id)
    }

    def delete(Long id) {
        def procesoInstance = Proceso.get(id)
        if (!procesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'proceso.label', default: 'Proceso'), id])
            redirect(action: "list")
            return
        }

        try {
            procesoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'proceso.label', default: 'Proceso'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'proceso.label', default: 'Proceso'), id])
            redirect(action: "show", id: id)
        }
    }
}

package procesostest

import org.springframework.dao.DataIntegrityViolationException

class SecFlujoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [secFlujoInstanceList: SecFlujo.list(params), secFlujoInstanceTotal: SecFlujo.count()]
    }

    def create() {
        [secFlujoInstance: new SecFlujo(params)]
    }

    def save() {
        def secFlujoInstance = new SecFlujo(params)
        if (!secFlujoInstance.save(flush: true)) {
            render(view: "create", model: [secFlujoInstance: secFlujoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), secFlujoInstance.id])
        redirect(action: "show", id: secFlujoInstance.id)
    }

    def show(Long id) {
        def secFlujoInstance = SecFlujo.get(id)
        if (!secFlujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), id])
            redirect(action: "list")
            return
        }

        [secFlujoInstance: secFlujoInstance]
    }

    def edit(Long id) {
        def secFlujoInstance = SecFlujo.get(id)
        if (!secFlujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), id])
            redirect(action: "list")
            return
        }

        [secFlujoInstance: secFlujoInstance]
    }

    def update(Long id, Long version) {
        def secFlujoInstance = SecFlujo.get(id)
        if (!secFlujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (secFlujoInstance.version > version) {
                secFlujoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'secFlujo.label', default: 'SecFlujo')] as Object[],
                          "Another user has updated this SecFlujo while you were editing")
                render(view: "edit", model: [secFlujoInstance: secFlujoInstance])
                return
            }
        }

        secFlujoInstance.properties = params

        if (!secFlujoInstance.save(flush: true)) {
            render(view: "edit", model: [secFlujoInstance: secFlujoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), secFlujoInstance.id])
        redirect(action: "show", id: secFlujoInstance.id)
    }

    def delete(Long id) {
        def secFlujoInstance = SecFlujo.get(id)
        if (!secFlujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), id])
            redirect(action: "list")
            return
        }

        try {
            secFlujoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'secFlujo.label', default: 'SecFlujo'), id])
            redirect(action: "show", id: id)
        }
    }
}

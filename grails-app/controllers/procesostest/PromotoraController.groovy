package procesostest

import org.springframework.dao.DataIntegrityViolationException

class PromotoraController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [promotoraInstanceList: Promotora.list(params), promotoraInstanceTotal: Promotora.count()]
    }

    def create() {
        [promotoraInstance: new Promotora(params)]
    }

    def save() {
        def promotoraInstance = new Promotora(params)
        if (!promotoraInstance.save(flush: true)) {
            render(view: "create", model: [promotoraInstance: promotoraInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'promotora.label', default: 'Promotora'), promotoraInstance.id])
        redirect(action: "show", id: promotoraInstance.id)
    }

    def show(Long id) {
        def promotoraInstance = Promotora.get(id)
        if (!promotoraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'promotora.label', default: 'Promotora'), id])
            redirect(action: "list")
            return
        }

        [promotoraInstance: promotoraInstance]
    }

    def edit(Long id) {
        def promotoraInstance = Promotora.get(id)
        if (!promotoraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'promotora.label', default: 'Promotora'), id])
            redirect(action: "list")
            return
        }

        [promotoraInstance: promotoraInstance]
    }

    def update(Long id, Long version) {
        def promotoraInstance = Promotora.get(id)
        if (!promotoraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'promotora.label', default: 'Promotora'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (promotoraInstance.version > version) {
                promotoraInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'promotora.label', default: 'Promotora')] as Object[],
                          "Another user has updated this Promotora while you were editing")
                render(view: "edit", model: [promotoraInstance: promotoraInstance])
                return
            }
        }

        promotoraInstance.properties = params

        if (!promotoraInstance.save(flush: true)) {
            render(view: "edit", model: [promotoraInstance: promotoraInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'promotora.label', default: 'Promotora'), promotoraInstance.id])
        redirect(action: "show", id: promotoraInstance.id)
    }

    def delete(Long id) {
        def promotoraInstance = Promotora.get(id)
        if (!promotoraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'promotora.label', default: 'Promotora'), id])
            redirect(action: "list")
            return
        }

        try {
            promotoraInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'promotora.label', default: 'Promotora'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'promotora.label', default: 'Promotora'), id])
            redirect(action: "show", id: id)
        }
    }
}

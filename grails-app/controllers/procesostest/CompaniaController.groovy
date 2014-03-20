package procesostest

import org.springframework.dao.DataIntegrityViolationException

class CompaniaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [companiaInstanceList: Compania.list(params), companiaInstanceTotal: Compania.count()]
    }

    def create() {
        [companiaInstance: new Compania(params)]
    }

    def save() {
        def companiaInstance = new Compania(params)
        if (!companiaInstance.save(flush: true)) {
            render(view: "create", model: [companiaInstance: companiaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'compania.label', default: 'Compania'), companiaInstance.id])
        redirect(action: "show", id: companiaInstance.id)
    }

    def show(Long id) {
        def companiaInstance = Compania.get(id)
        if (!companiaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'compania.label', default: 'Compania'), id])
            redirect(action: "list")
            return
        }

        [companiaInstance: companiaInstance]
    }

    def edit(Long id) {
        def companiaInstance = Compania.get(id)
        if (!companiaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'compania.label', default: 'Compania'), id])
            redirect(action: "list")
            return
        }

        [companiaInstance: companiaInstance]
    }

    def update(Long id, Long version) {
        def companiaInstance = Compania.get(id)
        if (!companiaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'compania.label', default: 'Compania'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (companiaInstance.version > version) {
                companiaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'compania.label', default: 'Compania')] as Object[],
                          "Another user has updated this Compania while you were editing")
                render(view: "edit", model: [companiaInstance: companiaInstance])
                return
            }
        }

        companiaInstance.properties = params

        if (!companiaInstance.save(flush: true)) {
            render(view: "edit", model: [companiaInstance: companiaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'compania.label', default: 'Compania'), companiaInstance.id])
        redirect(action: "show", id: companiaInstance.id)
    }

    def delete(Long id) {
        def companiaInstance = Compania.get(id)
        if (!companiaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'compania.label', default: 'Compania'), id])
            redirect(action: "list")
            return
        }

        try {
            companiaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'compania.label', default: 'Compania'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'compania.label', default: 'Compania'), id])
            redirect(action: "show", id: id)
        }
    }
}

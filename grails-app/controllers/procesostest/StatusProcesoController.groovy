package procesostest

import org.springframework.dao.DataIntegrityViolationException

class StatusProcesoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [statusProcesoInstanceList: StatusProceso.list(params), statusProcesoInstanceTotal: StatusProceso.count()]
    }

    def create() {
        [statusProcesoInstance: new StatusProceso(params)]
    }

    def save() {
        def statusProcesoInstance = new StatusProceso(params)
        if (!statusProcesoInstance.save(flush: true)) {
            render(view: "create", model: [statusProcesoInstance: statusProcesoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), statusProcesoInstance.id])
        redirect(action: "show", id: statusProcesoInstance.id)
    }

    def show(Long id) {
        def statusProcesoInstance = StatusProceso.get(id)
        if (!statusProcesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), id])
            redirect(action: "list")
            return
        }

        [statusProcesoInstance: statusProcesoInstance]
    }

    def edit(Long id) {
        def statusProcesoInstance = StatusProceso.get(id)
        if (!statusProcesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), id])
            redirect(action: "list")
            return
        }

        [statusProcesoInstance: statusProcesoInstance]
    }

    def update(Long id, Long version) {
        def statusProcesoInstance = StatusProceso.get(id)
        if (!statusProcesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (statusProcesoInstance.version > version) {
                statusProcesoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'statusProceso.label', default: 'StatusProceso')] as Object[],
                          "Another user has updated this StatusProceso while you were editing")
                render(view: "edit", model: [statusProcesoInstance: statusProcesoInstance])
                return
            }
        }

        statusProcesoInstance.properties = params

        if (!statusProcesoInstance.save(flush: true)) {
            render(view: "edit", model: [statusProcesoInstance: statusProcesoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), statusProcesoInstance.id])
        redirect(action: "show", id: statusProcesoInstance.id)
    }

    def delete(Long id) {
        def statusProcesoInstance = StatusProceso.get(id)
        if (!statusProcesoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), id])
            redirect(action: "list")
            return
        }

        try {
            statusProcesoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'statusProceso.label', default: 'StatusProceso'), id])
            redirect(action: "show", id: id)
        }
    }
}

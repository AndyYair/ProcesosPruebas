package procesostest

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException

class FlujoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [flujoInstanceList: Flujo.list(params), flujoInstanceTotal: Flujo.count()]
    }

    def create() {
        [flujoInstance: new Flujo(params)]
    }

    def save() {
        
        params.nomenclatura = 'PROM_'+params.idpromotora+'COMP_'+params.idpromotora+'_'+params.idcompania
        def flujoInstance = new Flujo(params)
        if (!flujoInstance.save(flush: true)) {
            render(view: "create", model: [flujoInstance: flujoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'flujo.label', default: 'Flujo'), flujoInstance.id])
        redirect(action: "show", id: flujoInstance.id)
    }

    def show(Long id) {
        def flujoInstance = Flujo.get(id)
        if (!flujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'flujo.label', default: 'Flujo'), id])
            redirect(action: "list")
            return
        }

        [flujoInstance: flujoInstance]
    }

    def edit(Long id) {
        def flujoInstance = Flujo.get(id)
        if (!flujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'flujo.label', default: 'Flujo'), id])
            redirect(action: "list")
            return
        }

        [flujoInstance: flujoInstance]
    }

    def update(Long id, Long version) {
        def flujoInstance = Flujo.get(id)
        if (!flujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'flujo.label', default: 'Flujo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (flujoInstance.version > version) {
                flujoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'flujo.label', default: 'Flujo')] as Object[],
                          "Another user has updated this Flujo while you were editing")
                render(view: "edit", model: [flujoInstance: flujoInstance])
                return
            }
        }

        flujoInstance.properties = params

        if (!flujoInstance.save(flush: true)) {
            render(view: "edit", model: [flujoInstance: flujoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'flujo.label', default: 'Flujo'), flujoInstance.id])
        redirect(action: "show", id: flujoInstance.id)
    }

    def delete(Long id) {
        def flujoInstance = Flujo.get(id)
        if (!flujoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'flujo.label', default: 'Flujo'), id])
            redirect(action: "list")
            return
        }

        try {
            flujoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'flujo.label', default: 'Flujo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'flujo.label', default: 'Flujo'), id])
            redirect(action: "show", id: id)
        }
    }
    
    def obtenerCompania = {
        println("Hola")
        
    def companiaInstanceList = Compania.findAllByNumeprom(params.idpromotora)
    def companias = companiaInstanceList.collect {[id: it.numcomp, nombcomp: it.nombcomp]}
    //render companias as JSON
    render(template:"companias", model: ['companias' : companias])
}
}

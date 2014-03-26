package procesostest

import org.springframework.dao.DataIntegrityViolationException;
import groovy.sql.Sql;

class ReglaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def dataSource
    
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [reglaInstanceList: Regla.list(params), reglaInstanceTotal: Regla.count()]
    }

    def create() {
        [reglaInstance: new Regla(params)]
    }

    def save() {
        
        /*sql = Sql.newInstance(dataSource)
        sql.execute()*/
        
        //println "UPDATE $params.objAfe1 SET $params.attrAfe1 = $params.valorAsignado1 $params.condicion $params.objCond1.$params.attrCond1 = $params.objCond2.$params.attrCond2$params.valorCondicion2 $params.operadorEnlace $params.condicionEnlazada"
        def reglaInstance = new Regla(params)
        if (!reglaInstance.save(flush: true)) {
            render(view: "create", model: [reglaInstance: reglaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'regla.label', default: 'Regla'), reglaInstance.id])
        redirect(action: "show", id: reglaInstance.id)
    }

    def show(Long id) {
        def reglaInstance = Regla.get(id)
        if (!reglaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regla.label', default: 'Regla'), id])
            redirect(action: "list")
            return
        }

        [reglaInstance: reglaInstance]
    }

    def edit(Long id) {
        def reglaInstance = Regla.get(id)
        if (!reglaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regla.label', default: 'Regla'), id])
            redirect(action: "list")
            return
        }

        [reglaInstance: reglaInstance]
    }

    def update(Long id, Long version) {
        def reglaInstance = Regla.get(id)
        if (!reglaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regla.label', default: 'Regla'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (reglaInstance.version > version) {
                reglaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'regla.label', default: 'Regla')] as Object[],
                          "Another user has updated this Regla while you were editing")
                render(view: "edit", model: [reglaInstance: reglaInstance])
                return
            }
        }

        reglaInstance.properties = params

        if (!reglaInstance.save(flush: true)) {
            render(view: "edit", model: [reglaInstance: reglaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'regla.label', default: 'Regla'), reglaInstance.id])
        redirect(action: "show", id: reglaInstance.id)
    }

    def delete(Long id) {
        def reglaInstance = Regla.get(id)
        if (!reglaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'regla.label', default: 'Regla'), id])
            redirect(action: "list")
            return
        }

        try {
            reglaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'regla.label', default: 'Regla'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'regla.label', default: 'Regla'), id])
            redirect(action: "show", id: id)
        }
    }
}

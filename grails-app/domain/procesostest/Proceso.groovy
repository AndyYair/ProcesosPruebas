package procesostest

import procesostest.Regla

class Proceso {
    
    static hasMany = [reglas:Regla]
    static belongsTo = Regla
    
    static scallfold = true
    
    String descripcion
    String nomenclatura
    String status

    static constraints = {
    }
}

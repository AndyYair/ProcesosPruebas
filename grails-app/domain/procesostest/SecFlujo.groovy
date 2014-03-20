package procesostest

import procesostest.*

class SecFlujo {
    
    Flujo   fid
    Proceso   secuencia
    
    static hasMany = [procesos: Proceso]
    
    static constraints = {
    }
}

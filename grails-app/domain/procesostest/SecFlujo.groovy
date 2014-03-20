package procesostest

import procesostest.*

class SecFlujo {
    
    Flujo   fid
    Proceso   secuencia
    
    static hasMany = [secuencia: Proceso]
    
    static constraints = {
    }
}

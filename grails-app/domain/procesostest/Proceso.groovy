package procesostest

import procesostest.*

class Proceso {
   
    
    Integer  id
    String  descripcion
    String  status
    Flujo   fid
    Date    iniVig
    Date    finVig
   
    static belongsTo = SecFlujo
    
    String toString() {
        "$id - $descripcion"
    }
    
    static constraints = {
        status nullable: true
    }
}

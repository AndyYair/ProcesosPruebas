package procesostest

import procesostest.*

class Proceso {
   
    
    Integer  id
    String  descripcion
    String  status
    Flujo   fid
   
    static belongsTo = SecFlujo
    
    static constraints = {
    }
}

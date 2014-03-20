package procesostest

import procesostest.*

class Proceso {
   
    
    String  id
    String  descripcion
    String  nomenclatura
    String  status
    Flujo   fid
   
    static belongsTo = SecFlujo
    
    static constraints = {
    }
}

package procesostest

import procesostest.Promotora
import procesostest.Compania

class Flujo {
    
    String      nomenclatura
    String      descripcion
    Integer     idpromotora
    Integer     idcompania
    Date        iniVig
    Date        finVig
    String      status
    
    
    
    static constraints = {
        status(nullable: true )
    }
    
     String toString(){
        "$id"+"  -  "+"$descripcion"
    }
}

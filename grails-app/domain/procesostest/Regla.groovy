package procesostest

import flujo.Proceso

class Regla {
    
   static hasMany = [procesos:Proceso] 
   static scallfold = true
    
    String descripcion
    Proceso pid
    Date iniVig
    Date finVig
    String objAfe1
    String attrAfe1
    String operador1
    String valorAsignado1
    String condicion
    String objCond1
    String attrCond1
    String operadorCondicion
    String valorCondicion1
    String objCond2
    String attrCond2
    String valorCondicion2
    String operadorEnlace
    String condicionEnlazada
    
    static constraints = {
    }
}

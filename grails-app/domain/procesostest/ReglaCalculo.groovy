package procesostest

import procesostest.Proceso

class ReglaCalculo {

    Integer id
    Integer numConceptos
    String  formulaConceptual
    String  formulaExplicita
    Date    iniVig
    Date    finVig
    Proceso pid
    String  objAfe1
    String  attrAfe1
    String  valorAsignado1
    String  status
    
    static constraints = {
        objAfe1(blank: true, nullable: true)
        attrAfe1(blank: true, nullable: true)
        valorAsignado1(blank: true, nullable: true)
        status(blank: true, nullable: true)
        formulaExplicita(maxSize: 4000)
    }
}
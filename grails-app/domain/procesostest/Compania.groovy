package procesostest

class Compania implements Serializable {
    
    Integer numeprom
    Integer numcomp
    String nombcomp
    String rfccomp
    String clavemon
    Integer numdirec
    Integer numorg
    Integer tcambio
    Integer secontrato

    //static belongsTo = nomina.CoControl
    //static hasMany = [Cuentas:Cuenta,Control:nomina.CoControl]
    
    static mapping = {
        table 'COMPANIA'
        version false
        
        // verificar el campo id
        id composite: ['numeprom','numcomp']
        numeprom column:'NUMEROPROMOTORA'
        numcomp column: 'NUMEROCOMPANIA'
        nombcomp column: 'NOMBRECOMPANIA'
        rfccomp column: 'RFCCOMPANIA'
        clavemon column: 'CLAVEMONEDA'
        numdirec column: 'NUMERODIRECCIA'
        numorg column: 'NUMEROORIGEN'
        tcambio column: 'TIPOCAMBIO'
        secontrato column: 'SEC_CONTRATO'
    }
    
    String toString() {
        "$numcomp - $nombcomp"
    }
}

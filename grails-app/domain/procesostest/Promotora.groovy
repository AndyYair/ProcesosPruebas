package procesostest

class Promotora {
    
    String nombre
    
    static mapping = {
        
        table 'PROMOTORA'
        version false
        sort id: "asc"
        
        id  column:'NUMEROPROMOTORA'
        nombre column:'NOMBREPROMOTORA'
    }
    
    static constraints = {
    }
    
    String toString(){
        "$id"+"  -  "+"$nombre"
    }
}

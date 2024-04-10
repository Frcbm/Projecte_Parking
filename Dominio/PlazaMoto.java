package Dominio;

public class PlazaMoto extends Plaza{
    
    private final int ancho;
    private final int largo;
    
    public PlazaMoto(){
        super();
        this.ancho = 2;
        this.largo = 3;
        this.tipo = "moto";
    }
    
    public int getAncho(){
        return this.ancho;
    }
    
    public int getLargo(){
        return this.largo;
    }
    
    public void ocuparPlaza(){
        if(getOcupado() < 1){
            this.ocupado = getOcupado() + 1;
        }else{
            System.out.println("La plaza ya esta ocupada");
        }
        
    }
    
    public void vaciarPlaza(){
        if(getOcupado() > 0){
            this.ocupado = getOcupado() - 1;
        } else {
            System.out.println("La plaza ya esta vacia");
        }
        
    }
    
    public int getArea(){
        return this.largo * this.ancho;
    }
    
    @Override
    public String toString(){
        String estado = getOcupado() == 1 ? " ocupada" : " libre";
        String plaza = "";
        plaza += "Estado: " + estado + "\n";
        plaza += "Tipo: " + getTipo() + "\n";
        plaza += "Ancho: " + getAncho() + "\n";
        plaza += "Largo: " + getLargo() + "\n";
        plaza += "Area: " + getArea() + "\n";
        plaza += "Precio: " + 2;
        return plaza;
    }
}

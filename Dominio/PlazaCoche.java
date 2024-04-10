package Dominio;

public class PlazaCoche extends Plaza {
    
    private final int ancho;
    private final int largo;
    
    public PlazaCoche(){
        super();
        this.ancho = 3;
        this.largo = 5;
        this.tipo = "coche";
    }
    
    public void ocuparPlaza(){
        if(getOcupado() < 1){
            this.ocupado = getOcupado() + 2;
        }else{
            System.out.println("La plaza ya esta ocupada");
        }
    }
    
    public void vaciarPlaza(){
        if(getOcupado() > 0){
            this.ocupado = getOcupado() - 2;
        } else {
            System.out.println("La plaza ya esta vacia");
        }
        
    }
    
    public int getAncho(){
        return this.ancho;
    }
    
    public int getLargo(){
        return this.largo;
    }
    
    public int getArea(){
        return this.largo * this.ancho;
    }
    
    @Override
    public String toString(){
        String estado = getOcupado() == 2 ? " ocupada" : getOcupado() == 1 ? " queda 1 sitio para moto" : " libre";
        String plaza = "";
        plaza += "Estado: " + estado + "\n";
        plaza += "Tipo: " + getTipo() + "\n";
        plaza += "Ancho: " + getAncho() + "\n";
        plaza += "Largo: " + getLargo() + "\n";
        plaza += "Area: " + getArea() + "\n";
        plaza += "Precio: " + 4;
        return plaza;
    }
}

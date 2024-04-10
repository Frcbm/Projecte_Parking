package Dominio;

abstract class Plaza implements Plazas{
    
    protected int ocupado;
    protected String tipo;

    //L'atribut tipo l'he empleat per poder identificar desde la clase Parking si eren places de cotxe o moto
    protected Plaza(){
        this.ocupado = 0;
    }
   
    
    protected String getTipo(){
        return this.tipo;
    }
    
    protected int getOcupado(){
        return this.ocupado;
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
    
    public int getAncho(){
        return 0;
    }
    
    public int getLargo(){
        return 0;
    }
    
    public int getArea(){
        return 0;
    }
    
    public String toString(){
        return "";
    }
    
}

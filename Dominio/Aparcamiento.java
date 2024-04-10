package Dominio;

import java.util.HashSet;
public class Aparcamiento {
    HashSet<Plaza> parking;
    private final int areaTotal;
    
    //Dins el propi constructor emplei el mètode llenarParking per fer que automàticament ens crei les places
    public Aparcamiento(int areaTotal){
        this.parking = new HashSet();
        this.areaTotal = areaTotal;
        llenarParking();
    }
    
    private int areaOcupada(){
        int area = 0;
        for(Plaza p : parking){
           area += p.getArea();
        }
        return area;
    }
    
    //Aquest mètode plena un 80% de l'espai amb places de cotxe i un 20% amb places de moto
    public void llenarParking(){
        while( areaOcupada() < areaTotal * 80 / 100){
            parking.add(new PlazaCoche());
        }
        while( areaOcupada() < areaTotal){
            parking.add(new PlazaMoto());
        }
    }
    
    
    //Els mètodes que podriem emplear amb un HashSet per poder manipular-lo des de fora de la clase.
    public void add(Plaza p){
        if(parking.size() < areaTotal){
            parking.add(p);
        } else{
            System.out.println("No hay sitios para mas plazas");
        }
    }

    public boolean contains(Plaza p){
        return parking.contains(p);
    }
    
    public void remove(Plaza p){
        parking.remove(p);
    }
    
    public void clear(){
        parking.clear();
    }
    
    public int size(){
        return parking.size();
    }
    
    //Mètode per poder veure totes les places de parking
    public void getParking(){
        int i = 1;
        for(Plaza p : parking){
            System.out.println("Plaza " + i + ":");
            System.out.println(p + "\n");
            i++;
        }
    }
    
    //Mètodes per poder veure la propera plaça lliure
    public boolean sitioLibreCoche(){
        int i = 1;
        for(Plaza p: parking){
            if(p.getOcupado() == 0 && p.getTipo().equals("coche")){
                p.ocuparPlaza();
                System.out.println("Puede aparcar en la plaza " + i);
                return true;
            }
            i++;
        }
        System.out.println("Lo sentimos, en estos momentos no hay sitio libre");
        return false;
    }
    
    public boolean sitioLibreMoto(){
        int i = 1;
        for(Plaza p: parking){
            if(p.getOcupado() == 0 && p.getTipo().equals("moto")){
                p.ocuparPlaza();
                System.out.println("Puede aparcar en la plaza " + i);
                return true;
            }
            if(p.getOcupado() == 1 && p.getTipo().equals("coche")){
                p.ocuparPlaza();                
                System.out.println("Puede aparcar en la plaza " + i);
                return true;
            }
            i++;
        }
        System.out.println("Lo sentimos, en estos momentos no hay sitio libre");
        return false;
    }
    
    //Els seguents mètodes privats ens serveixen per poder saber cuantes places de cada tipus tenim
    private int plazasCoche(){
        int contador = 0;
        for(Plaza p : parking){
            if(p.getTipo().equals("coche")){
                contador++;
            }
        }
        return contador;
    }
    
    private int plazasMoto(){
        int contador = 0; 
        for(Plaza p : parking){
            if(p.getTipo().equals("moto")){
                contador++;
            }
        }
        return contador;
    }
    
    //Els seguents mètodes privats ens serveixen per poder veure quantes places de cada tipus estan ocupades
    private int plazasOcupadasCoche(){
        int contador = 0;
        for(Plaza p : parking){
            if(p.getTipo().equals("coche") && p.getOcupado() == 2){
                contador++;
            }
        }
        return contador;
    }
    
    private int plazasOcupadasMoto(){
        int contador = 0; 
        for(Plaza p : parking){
            if(p.getTipo().equals("moto") && p.getOcupado() == 1){
                contador++;
            }
        }
        return contador;
    }
    
    //Calcul del preu
    public int precioTotal(){
        return ((plazasOcupadasCoche() * 4) + (plazasOcupadasMoto() * 2));
    }
    
    //Calcul del total de places
    public String totalPlazas(){
        return "Hay " + plazasCoche() + " plazas de coche y " + plazasMoto() + " plazas de moto.";
    }

}

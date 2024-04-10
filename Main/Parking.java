package Main;

import Dominio.Aparcamiento;
import Dominio.PlazaCoche;
import Dominio.PlazaMoto;
import java.util.Scanner;

public class Parking {

    
    public static void main(String[] args) {
        Aparcamiento parking = new Aparcamiento(3153);
        System.out.println(parking.totalPlazas());
        
    }
}

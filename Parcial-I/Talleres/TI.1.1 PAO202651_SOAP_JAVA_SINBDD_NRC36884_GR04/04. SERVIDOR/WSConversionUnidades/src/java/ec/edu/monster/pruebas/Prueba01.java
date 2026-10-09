/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.pruebas;

import ec.edu.monster.servicios.ConversorUnidadesService;

/**
 *
 * @author MeatPuppets
 */
public class Prueba01 {
    public static void main(String[] args){
        int n1 = 3;
   
        ConversorUnidadesService service = new ConversorUnidadesService();
        int convertir = service.conversor(n1);
        System.out.println("Resultado de la conversión: " + convertir);
    }
}

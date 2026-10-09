/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.wsconversorclient.controller;

import ec.edu.monster.wsconversorclient.service.ConversorService;

/**
 *
 * @author meatpuppets
 */
public class AppControlador {
    public double convertirLogintud(double n1, String unidadInicial, String unidadFinal){
        ConversorService service = new ConversorService();
        double conversion = service.convertirLongitud(n1, unidadInicial, unidadFinal);
        return conversion;
    }
}

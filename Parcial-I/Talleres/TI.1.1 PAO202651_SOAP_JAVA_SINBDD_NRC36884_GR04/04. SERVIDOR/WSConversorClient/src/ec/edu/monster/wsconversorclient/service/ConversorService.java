/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.wsconversorclient.service;

/**
 *
 * @author meatpuppets
 */
public class ConversorService {

    public double convertirLongitud(double valor, java.lang.String unidadInicial, java.lang.String unidadFinal) {
        ec.edu.monster.ws.WSConversorUnidades_Service service = new ec.edu.monster.ws.WSConversorUnidades_Service();
        ec.edu.monster.ws.WSConversorUnidades port = service.getWSConversorUnidadesPort();
        return port.convertirLongitud(valor, unidadInicial, unidadFinal);
    }
    
}

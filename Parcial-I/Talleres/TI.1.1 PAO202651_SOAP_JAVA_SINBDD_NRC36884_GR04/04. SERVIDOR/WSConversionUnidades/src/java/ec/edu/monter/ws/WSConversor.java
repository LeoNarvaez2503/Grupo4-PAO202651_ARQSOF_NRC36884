/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package ec.edu.monter.ws;

import ec.edu.monster.servicios.ConversorUnidadesService;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

/**
 *
 * @author MeatPuppets
 */
@WebService(serviceName = "WSConversor")
public class WSConversor {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public int operation(@WebParam(name = "unidad") int unidad) {
        //TODO write your implementation code here:
        ConversorUnidadesService service = new ConversorUnidadesService();
        int conversor = service.conversor(unidad);                
        return conversor;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/MessageHandler.java to edit this template
 */
package ec.edu.monster.controladores.manejadoresws;

import java.util.Collections;
import java.util.Set;
import javax.xml.namespace.QName;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author MeatPuppets
 */
public class ManejadorAutenticador implements SOAPHandler<SOAPMessageContext> {
    
    @Override
    public boolean handleMessage(SOAPMessageContext messageContext) {
        SOAPMessage msg = messageContext.getMessage();
        return true;
    }
    
    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }
    
    @Override
    public boolean handleFault(SOAPMessageContext messageContext) {
        return true;
    }
    
    @Override
    public void close(MessageContext context) {
    }
    
}

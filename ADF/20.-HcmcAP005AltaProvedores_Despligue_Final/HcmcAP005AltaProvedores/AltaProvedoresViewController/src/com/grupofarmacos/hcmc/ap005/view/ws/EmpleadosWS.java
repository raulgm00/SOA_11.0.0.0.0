package com.grupofarmacos.hcmc.ap005.view.ws;

import com.grupofarmacos.hcmc.ap005.view.custom.core.EmpType;
import com.grupofarmacos.servicios.far.schema.farstandardheader.HeaderMessage;
import com.grupofarmacos.servicios.far.schema.farstandardheader.HeaderMessageResponse;
import com.grupofarmacos.servicios.far.schema.farstandardmessage.MessageError;
import com.grupofarmacos.servicios.far.schema.farstandardmessage.MessageResponse;
import com.grupofarmacos.servicios.far.schema.tipos.farempleados.AltaProveedorRequestType;
import com.grupofarmacos.servicios.far.schema.tipos.farempleados.AltaProveedorResponseType;
import com.grupofarmacos.servicios.far.services.farempleados.EmpleadosBindingQSService;
import com.grupofarmacos.servicios.far.services.farempleados.EmpleadosFaultMessage;
import com.grupofarmacos.servicios.far.services.farempleados.EmpleadosPortType;
import com.grupofarmacos.servicios.far.schema.farempleados.EmpleadosListaType;
import com.grupofarmacos.servicios.far.schema.farempleados.EmpleadoType;
import java.util.ArrayList;
import java.util.List;
import com.grupofarmacos.servicios.far.schema.farstandardheader.ObjectFactory;

import javax.xml.soap.SOAPHeader;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Binding;
import javax.xml.ws.WebServiceFeature;

public class EmpleadosWS {
    
    /*Standar Header*/
    private static HeaderMessage hmRequest;
    private static HeaderMessageResponse hmResponse;
    
    /*Standar Message*/
    private static MessageError msErrorRespose;
    
    /*Tipos Empleados*/
    private static AltaProveedorRequestType apRequestType;
    private static AltaProveedorResponseType apResponseType;
    
    /*Services*/
    private static EmpleadosBindingQSService service;
    private static EmpleadosPortType port;
    
    
    
    public EmpleadosWS() {
        super();
    }
    
    
    public static void main(String[] args){
        //Primero accedemos a un objeto Service
        
        //Creamos uns instancia de Request de Header en caso de necesitarlo
        //Seteamos los valores que requiere la peticion
        hmRequest = new HeaderMessage();
        hmRequest.setApplicationRequester("0");
        
        
        //Creamos uns instancia del Request de Alta de Empleado
        apRequestType = new AltaProveedorRequestType();
        apRequestType.setFechaEfectiva("2017-10-12");
        
                
        //Creamos un objeto del tipo EmpleadoType para lograr setear una lista del mismo tipo para la inyeccion al WS
        EmpleadoType objEmpleadoType = new EmpleadoType();
        
        
        //Request Fallido
        /* objEmpleadoType.setIdEmpleado("0");
        objEmpleadoType.setNumEmpleado("0");
        objEmpleadoType.setTipoEmpleado("PR");
        objEmpleadoType.setFechaEfectiva("2012-10-12");
        objEmpleadoType.setEstatusEmpleado("ACTIVE");
         */
        
        //Request Exitoso
        objEmpleadoType.setIdEmpleado("104");
        objEmpleadoType.setNumEmpleado("000104");
        objEmpleadoType.setTipoEmpleado("GF");
        objEmpleadoType.setFechaEfectiva("2012-10-12");
        objEmpleadoType.setEstatusEmpleado("ACTIVE");
        
        EmpleadosListaType empleado = new EmpleadosListaType();
        empleado.getEmpleado().add(objEmpleadoType);
        
        
            
        //apRequestType.getEmpleados().getEmpleado().add(objEmpleadoType);
        //Requiero enviarle : EmpleadosListaType
        apRequestType.setEmpleados(empleado);
        
        
        //Creamos las intancias de las respuestas 
        //HeaderMessage
        hmResponse = new HeaderMessageResponse();
        //Alta de Provedores Resposne
        apResponseType = new AltaProveedorResponseType();
        
        //Abrimos el binding (Port) del WS
        service = new EmpleadosBindingQSService();
        port = service.getEmpleadosBindingQSPort();
        
        //Creamos WebServiceFeature que permite habilitar o deshabilitar ciertas caracteristicas de los WebServices
        WebServiceFeature[] wfs = new WebServiceFeature[] {};
                
        
        try {
            
            
            apResponseType  = service.getEmpleadosBindingQSPort(wfs).altaProveedor(apRequestType);
            //apResponseType = port.altaProveedor(apRequestType);
            
            
            System.out.println("Response Codigo = " + apResponseType.getCodigo());
            System.out.println("Response Descripcion = " + apResponseType.getDescripcion());
            
            
        } catch (EmpleadosFaultMessage e) {
            //e.printStackTrace();
            
            System.out.println("CodigoError: "+e.getFaultInfo().getCodigoError());
            System.out.println("DescripcionError: "+e.getFaultInfo().getDescripcionError());
            System.out.println("TipoError: "+e.getFaultInfo().getTipoError());
            System.out.println("Severidad: "+e.getFaultInfo().getSeveridad());
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        
            
        }
        
        
    }
    
    
    public void generacionRequestSOAP(){
    
    }
    
    public String[] requestWebServices(String fechaEfectiva, ArrayList<EmpType> arrayListEmps){
        //El codigo de respuesta del servicio "0" indica exitoso
        String codigo = "";
        String descripcion= "";
        
        //Peticion
        hmRequest = new HeaderMessage();
        hmRequest.setApplicationRequester("0");
        
        apRequestType = new AltaProveedorRequestType();
        apRequestType.setFechaEfectiva("2017-10-12");
        
        EmpleadosListaType empleado = new EmpleadosListaType();
        EmpleadoType objEmpleadoType ;
        for( EmpType obj : arrayListEmps){
            objEmpleadoType = new EmpleadoType();
            objEmpleadoType.setIdEmpleado(obj.getIdEmpleado());
            objEmpleadoType.setNumEmpleado(obj.getNumEmpleado());
            objEmpleadoType.setTipoEmpleado(obj.getTipoEmpleado());
            objEmpleadoType.setFechaEfectiva(obj.getFechaEfectiva());
            objEmpleadoType.setEstatusEmpleado(obj.getEstatusEmpleado());
            empleado.getEmpleado().add(objEmpleadoType);    
        }
        
        apRequestType.setEmpleados(empleado);
        apResponseType = new AltaProveedorResponseType();
        
        //Abrimos el binding (Port) del WS
        service = new EmpleadosBindingQSService();
        
        port = service.getEmpleadosBindingQSPort();
        
        
       
        
        try { 
            
            apResponseType = port.altaProveedor(apRequestType);
            System.out.println("Response Codigo = " + apResponseType.getCodigo());
            System.out.println("Response Descripcion = " + apResponseType.getDescripcion());
            codigo = String.valueOf( apResponseType.getCodigo() );
            descripcion = "Recurso creado";
            
                                                
        } catch (EmpleadosFaultMessage e) {
                //e.printStackTrace();
                
                System.out.println("CodigoError: "+e.getFaultInfo().getCodigoError());
                System.out.println("DescripcionError: "+e.getFaultInfo().getDescripcionError());
                System.out.println("TipoError: "+e.getFaultInfo().getTipoError());
                System.out.println("Severidad: "+e.getFaultInfo().getSeveridad());
                codigo = e.getFaultInfo().getCodigoError();
                descripcion = e.getFaultInfo().getDescripcionError();
                
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        
        String[] resultado = { codigo, descripcion };                        
        return resultado;
    }
    
    public static StringBuilder generaPayload(String fe, ArrayList<EmpType> arrayListEmp){
    
    StringBuilder payload = new StringBuilder();
    payload.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:far=\"http://servicios.grupofarmacos.com/FAR/Schema/FARStandardHeader\" xmlns:far1=\"http://servicios.grupofarmacos.com/FAR/Schema/Elementos/FAREmpleados\" xmlns:far2=\"http://servicios.grupofarmacos.com/FAR/Schema/FAREmpleados\">\n" + 
    "   <soapenv:Header>\n" + 
    "      <far:headerMessage>\n" + 
    "         <applicationRequester>0</applicationRequester>\n" + 
    "      </far:headerMessage>\n" + 
    "   </soapenv:Header>\n" + 
    "   <soapenv:Body>\n" + 
    "      <far1:altaProveedorRequest>\n" + 
    "         <far2:fechaEfectiva>"+ fe +"</far2:fechaEfectiva>\n" + 
    "         <far2:empleados>\n");
    
    for(EmpType e : arrayListEmp){
        payload.append("            <far2:empleado>\n" + 
        "               <far2:idEmpleado>"+ e.getIdEmpleado() +"</far2:idEmpleado>\n" + 
        "               <far2:numEmpleado>"+ e.getNumEmpleado() +"</far2:numEmpleado>\n" + 
        "               <far2:tipoEmpleado>"+ e.getTipoEmpleado()+"</far2:tipoEmpleado>\n" + 
        "               <far2:fechaEfectiva>"+ e.getFechaEfectiva() +"</far2:fechaEfectiva>\n" + 
        "               <far2:estatusEmpleado>"+ e.getEstatusEmpleado() +"</far2:estatusEmpleado>\n" + 
        "            </far2:empleado>\n");
        
    }
    
    
    payload.append("         </far2:empleados>\n" + 
    "      </far1:altaProveedorRequest>\n" + 
    "   </soapenv:Body>\n" + 
    "</soapenv:Envelope>");
    
    System.out.println("Request : \n " + payload);
        System.out.println("________________________________________________________________________________________________");
        System.out.println("                                         Request a SOA ");
        System.out.println("________________________________________________________________________________________________");
    return payload;    
    }
    

    
}

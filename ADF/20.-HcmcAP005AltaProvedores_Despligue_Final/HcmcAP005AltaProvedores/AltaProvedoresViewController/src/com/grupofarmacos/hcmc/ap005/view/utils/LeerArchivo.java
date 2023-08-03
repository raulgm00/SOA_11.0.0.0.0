package com.grupofarmacos.hcmc.ap005.view.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Properties;

import javax.faces.context.FacesContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LeerArchivo {
    public LeerArchivo() {
        super();
    }
    
    
    public static void main(String [] args){
        LeerArchivo A = new LeerArchivo();
        ArrayList<String> result = A.assigProperties();
    }
    
    public static ArrayList<String> assigProperties() {//throws NamingException {
        //String[] p= new String[3];
        ArrayList<String> forReturn = new ArrayList<String>();
        
        try {
            //Context ic =new InitialContext();
            
            /**Creamos un Objeto de tipo Properties*/
            Properties propiedades = new Properties();
            
            /**Cargamos el archivo dentro del servidor*/
            //propiedades.load(new FileInputStream("C:\\Oracle\\Middleware_11g\\user_projects\\applications\\DefaultDomain\\grupofarmacos\\properties\\ap005.properties"));
            /**Servidor Local **/
            propiedades.load(new FileInputStream("grupofarmacos/properties/ap005.properties"));
            
            
            
            /**Cargamos el archivo de forma local**/
            //propiedades.load(new FileInputStream("src/com/grupofarmacos/hcmc/ap005/view/properties/ap005.properties"));
                        
            /**Obtenemos los parametros definidos en el archivo*/
            String uri = propiedades.getProperty("hcmc.tst.query.employ");
            String user = propiedades.getProperty("hcmc.tst.user");
            String password = propiedades.getProperty("hcmc.tst.password");
            
            forReturn.add(uri);
            forReturn.add(user);
            forReturn.add(password);
            
            /**Imprimimos los valores*/
            System.out.println("User: " + user + "\n" + "Password: " + password + "\n" + "URI: "+ uri);

        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
        } catch (IOException e) {
            System.out.println("Error, No se puede leer el archivo");
        }
        
        return forReturn;
        
    }

}

package com.grupofarmacos.hcmc.ap005.model.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import  java.sql.CallableStatement ; 
import  java.sql.SQLException ;

import  java.sql.Types ;

import oracle.jbo.JboException ;


public class Estandares {
    public Estandares() {
        super();
    }
    
    
    public static void main(String[] args) {
        //Mon Oct 16 13:05:37 CDT 2017
        //"lun oct 16 2017 04:41:29 PM"
        String fechaPredefinida = "2017-10-16";
        //System.out.println("Formato correcto (String)       = Mon Oct 16 13:05:37 CDT 2017");
        System.out.println("Formato correcto (String)       = "+fechaPredefinida);

        Date myDate = new Date();
        System.out.println("myDate (String)                 = " + new SimpleDateFormat("E MMM dd yyyy hh:mm:ss a").format(myDate));
        System.out.println("Fecha actual con formato (Date) = " + deStringToDate(fechaPredefinida));
        //System.out.println("Fecha actual con formato (Date) = " + deStringToDate( new SimpleDateFormat("E MMM dd yyyy hh:mm:ss a").format(myDate) ));

    }

    public static synchronized java.util.Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat formatoDelTexto = new SimpleDateFormat("E MMM dd yyyy hh:mm:ss a");
        
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
        public static java.util.Date dateToDateFormatoDB(Date input) {
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            String dateFormateado = formatoDelTexto.format(input);
            Date fechaEnviar = null;
            try {
                fechaEnviar = formatoDelTexto.parse(dateFormateado);
                return fechaEnviar;
            } catch (ParseException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        
        
    

    
    

    }


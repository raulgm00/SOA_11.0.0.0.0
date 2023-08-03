package com.grupofarmacos.hcmc.ap005.view.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;



public class ManejadorFechas {
    
    
    public static void main(String[] args){
        /* String fecha = "Mon Oct 16 11:35:13 CDT 2017";
        String fechaString = getFechaActual();
        System.out.println("String = "  + fechaString );
        System.out.println("deStringToDate ("+fechaString+") = " +deStringToDate(fechaString));
        System.out.println("deStringToDate ("+fechaString+") = " +deStringToDate(fechaString));
         */
        
        Date date = new Date();
        System.out.println("------------------------------------------------------------------");
        System.out.println("Date () = " + date);
        System.out.println("dateToDateFormatoDB(date) = " + dateToDateFormatoDB(date)) ;
        //System.out.println("Date () = " + deStringToDateDataBase(fechaString));
        
    }

    //Metodo usado para obtener la fecha actual
    //@return Retorna un <b>STRING</b> con la fecha actual formato "dd-MM-yyyy"

    public static String getFechaActual() {
        Date ahora = new Date();
        //System.out.println("Date () = " + ahora );
        //SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(ahora);
    }
    
    //Metodo usado para obtener la fecha actual
    //@return Retorna un <b>STRING</b> con la fecha actual formato "dd-MM-yyyy"

    public static Date getFechaActualDate() {
        Date ahora = new Date();
        
        return ahora;
    }
    
    public static String getFechaActualDateTime() {
        Date ahora = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy-MM-dd 'at' hh:mm:ss a");
        return ft.format(ahora);
    }
    
    
    //Metodo usado para obtener la fecha efectiva acorde al servico de HCMC
    //@return Retorna un <b>STRING</b> con la fecha actual formato "yyyy-MM-dd"

    public static String getEffectiveDay() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        return formateador.format(ahora);
    }

    //Metodo usado para obtener la hora actual del sistema
    //@return Retorna un <b>STRING</b> con la hora actual formato "hh:mm:ss"

    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }

    //Sumarle dias a una fecha determinada
    //@param fch La fecha para sumarle los dias
    //@param dias Numero de dias a agregar
    //@return La fecha agregando los dias

    public static java.sql.Date sumarFechasDias(java.sql.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Restarle dias a una fecha determinada
    //@param fch La fecha
    //@param dias Dias a restar
    //@return La fecha restando los dias

    public static synchronized java.sql.Date restarFechasDias(java.sql.Date fch,
                                                              int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, -dias);
        return new java.sql.Date(cal.getTimeInMillis());
    }

    //Diferencias entre dos fechas
    //@param fechaInicial La fecha de inicio
    //@param fechaFinal  La fecha de fin
    //@return Retorna el numero de dias entre dos fechas

    public static synchronized int diferenciasDeFechas(Date fechaInicial,
                                                       Date fechaFinal) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        return ((int)dias);
    }

    //Devuele un java.util.Date desde un String en formato dd-MM-yyyy
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date

    public static synchronized java.util.Date deStringToDate(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    //Devuele un java.util.Date desde un String en formato yyyy-MM-dd
    //@param La fecha a convertir a formato date
    //@return Retorna la fecha en formato Date


    public static synchronized java.util.Date deStringToDateDataBase(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static synchronized java.util.Date dateToDateFormatoDB(Date input) {
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



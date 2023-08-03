package com.grupofarmacos.hcmc.ap005.view.custom.core;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;


public class DeserealizarGsonCustom {
    public DeserealizarGsonCustom() {
        super();
    }
    
    
    public static void main(String[] args){
        String cadena = "[{\n" + 
        "  \"items\" : [ {\n" + 
        "    \"Salutation\" : \"MR.\",\n" + 
        "    \"DisplayName\" : \"IVAN APARICIO\",\n" + 
        "    \"assignments\" : [ {\n" + 
        "      \"AssignmentName\" : \"SUPERVISOR FACTURACION\",\n" + 
        "      \"AssignmentId\" : 300000001885025,\n" + 
        "      \"assignmentDFF\" : [ {\n" + 
        "        \"AssignmentId\" : 300000001885025,\n" + 
        "        \"EffectiveStartDate\" : \"2017-07-01\",\n" + 
        "        \"gfGrupoPago\" : \"INL ELITE\"\n" + 
        "      } ]\n" + 
        "    } ]\n" + 
        "  } ],\n" + 
        "  \"count\" : 1,\n" + 
        "  \"hasMore\" : false,\n" + 
        "  \"limit\" : 25,\n" + 
        "  \"offset\" : 0,\n" + 
        "  \"links\" : [ {\n" + 
        "    \"rel\" : \"self\",\n" + 
        "    \"href\" : \"https://eflk-test.hcm.us2.oraclecloud.com:443/hcmCoreApi/resources/11.12.1.0/emps\",\n" + 
        "    \"name\" : \"emps\",\n" + 
        "    \"kind\" : \"collection\"\n" + 
        "  } ]\n" + 
        "}]";
        
        System.out.println("Cadene sin tratamiento = \n" + cadena);
        
        
        DeserealizarGsonCustom objDese = new DeserealizarGsonCustom();
        ArrayList<String> Propiedades = objDese.deserializacionNiveles(cadena);
        System.out.println("Propiedades(0) = " + Propiedades.get(0));
        System.out.println("Propiedades(1) = " + Propiedades.get(1));
    }

    public ArrayList<String> deserializacionNiveles(String cadena){
        ArrayList<String> Atributos = new ArrayList<String>();
        String count ;
        String Salutation ;
        String AssignmentId ;
        String id ;
        String EffectiveStartDate ;
        String gfGrupoPago ;
        JsonObject gsonObj;
        Boolean ban= false;
        // Parseo
        JsonParser parser = new JsonParser();
        // Obtengo el arreglo parseado a Json
        JsonArray gsonArr = parser.parse(cadena).getAsJsonArray();
        
        // Array de 1° Nivel
        for (JsonElement obj : gsonArr) {
            // Obtenemos el primer arreglo del Nivel 1°
             gsonObj = obj.getAsJsonObject();
             count = gsonObj.get("count").getAsString();
             //System.out.println("Count = " + count);
             
             // Obtenemos el primer arreglo de Itemas
             JsonArray arrayItems = gsonObj.get("items").getAsJsonArray();
            // Array de 2° Nivel Items
            for(JsonElement obj2 : arrayItems){
                // Obtenemos el primer elemento del arreglo del Nivel 2°
                //JsonObject gsonObj2 = obj2.getAsJsonObject();
                gsonObj = obj2.getAsJsonObject();
                Salutation = gsonObj.get("DisplayName").getAsString();
                //System.out.println("DisplayName = " + Salutation);
                
                JsonArray arrayAssignments =gsonObj.get("assignments").getAsJsonArray();
                //Array del 3° Nivel Assignments
                for(JsonElement obj3 : arrayAssignments){
                    // Obtenemos el primer elemento del arreglo del Nivel 3°
                    gsonObj = obj3.getAsJsonObject();
                    AssignmentId = gsonObj.get("AssignmentId").getAsString();
                    //System.out.println("AssignmentId = " + AssignmentId);
                        
                    JsonArray arrayAssignmentDFF = gsonObj.get("assignmentDFF").getAsJsonArray();
                    //Array del 4° Nivel AssignmentDFF
                    for(JsonElement obj4 : arrayAssignmentDFF){
                        // Obtenemos el primer elemento del arreglo del Nivel 4°
                        gsonObj = obj4.getAsJsonObject();
                        id = gsonObj.get("AssignmentId").getAsString();
                        //System.out.println(" 4° Nivel AssignmentId = " + id);
                        
                        if(id.equals(AssignmentId)){
                            //System.out.println("Existe el valor dentro del Resquest " + id );
                            EffectiveStartDate = gsonObj.get("EffectiveStartDate").getAsString();
                            gfGrupoPago = gsonObj.get("gfGrupoPago").getAsString();
                            //System.out.println("Retorno [gfGrupoPago] =" + gfGrupoPago + " [EffectiveStartDate]= " + EffectiveStartDate);
                            // 0 Asignacion de EffectiveStartDate
                            Atributos.add(0, EffectiveStartDate);
                            // 1 Asignacion de EffectiveStartDate
                            Atributos.add(1, gfGrupoPago);
                            ban = true;
                        }
                        if(ban)
                            break;
                    }
                    if(ban)
                        break;
                 }       
                if(ban)
                    break;
            }
            if(ban)
                break;
        }
     return Atributos;
    }
}
package com.grupofarmacos.hcmc.ap005.model.am;

import com.grupofarmacos.hcmc.ap005.model.am.common.AP005AM;
import com.grupofarmacos.hcmc.ap005.model.utils.Estandares;


import com.grupofarmacos.hcmc.ap005.model.vo.EmployeeTableVOImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;

import java.sql.Types;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import oracle.jbo.JboException;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.TooManyObjectsException;
import oracle.jbo.domain.Number;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;


// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Oct 17 19:24:08 CDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AP005AMImpl extends ApplicationModuleImpl implements AP005AM {
    
    /**
     * This is the default constructor (do not remove).
     */
    public AP005AMImpl() {
        
    }
    
    /**Metodo que busca los permisos de acceso**/
    public Boolean garantizarAcceso(String user){
        user = user.toUpperCase();
        System.out.println("Creiterio de busqueda =" + user);
        //Hacemos la consulta de accesoa al aplicativo
        Boolean ban = false;
        this.getAcesosVO1().setNamedWhereClauseParam("v_userName", user);
        this.getAcesosVO1().executeQuery();
        Row fila = this.getAcesosVO1().first();
        while(fila!=null){
            System.out.println("User = " + fila.getAttribute("UserName") + " ----  Accesos = " + fila.getAttribute("Accesos"));
            
            String accesos = fila.getAttribute("Accesos").toString();
            String[] idAcceso = accesos.split(",");
            for(int x=0; x<idAcceso.length; x++){
                this.getRequerimientoVO1().setNamedWhereClauseParam("v_idAcceso", idAcceso[x]);
                this.getRequerimientoVO1().executeQuery();
                Row filaReq = this.getRequerimientoVO1().first();
                while(filaReq != null){
                        
                    if(filaReq.getAttribute("Pagina").equals("altaProvedores.jspx")){
                        ban =true;
                        System.out.println("pagina encontrada = " + filaReq.getAttribute("Pagina") );
                    }
                        
                        if(ban)
                            break;    
                    }
            }
            if(ban)
                break;
            fila = this.getAcesosVO1().next();
        }
        //Retornamos su acceso
     System.out.println("Bandera = " + ban);
     return ban;   
    }

 
    /**Obetener Properties desde base de datos**/
    public Map getProperties(String criterial) {
        Map mapa = new HashMap<String,String>();
        System.out.println("Criterial = " + criterial);
        
        //Ejecucion de ViewCriterial Progrmatico
        this.getPropertyVO1().setApplyViewCriteriaName("PropertyVOCriteria");
        //En caso de tener paramtros dentro de ,-nuetro viewCriterial
        //this.getPropertiVO1().setNamedWhereClauseParam("parametro", "parametro_entrada_metodo");
        this.getPropertyVO1().executeQuery();
        
        //Obtener la fila del las properties
        Row fila = this.getPropertyVO1().first();
        
        while (fila != null) {
            System.out.println(fila.getAttribute("Id") + "\t" + fila.getAttribute("GapId") + "\t" + fila.getAttribute("Clave") + "\t" + fila.getAttribute("Valor"));
            mapa.put( fila.getAttribute("Id").toString(), fila.getAttribute("Valor").toString() );
            fila = this.getPropertyVO1().next();
        }
    
    return mapa;
    }
    
    /**Metodo que inserta empleados con Fecha Efectiva en tiempo de ejecuion**/
    public Boolean insertEmploy() {
        
        try{
                Row filaEmpTable = this.getEmployeeTableVO1().first();
            
                while(filaEmpTable != null){
                    //Row fila = this.getEmployeeVO1().createRow();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("No. Empleado = " + filaEmpTable.getAttribute("EmployeNumberPsoft"));
                    System.out.println("Nombre = " + filaEmpTable.getAttribute("VendorName"));
                    System.out.println("Fecha Efectiva = " + filaEmpTable.getAttribute("EffectiveStartDate"));
                    System.out.println("Estatus = " + filaEmpTable.getAttribute("ActiveUser"));
                    System.out.println("Tipo Empleado = " + filaEmpTable.getAttribute("TypeUser"));
       
                        
                    System.out.println("--------------------------------------------------------------------------------");
                    /*Inserccion de atributos del Objeto Programatico 1 a Objeto 2 Entity*/
                    
                    //ID No se �de por la condifuracion en la EO (sequencias)
                    //fila.setAttribute("Id", new Number(1));
                    
                    /* Fechga Efectiva del campo GRUPO PAGO
                     * Las fechas deden ser de tipo java.util.Date 
                     * Formato:[yyyy-MM-dd]
                    */
                    //System.out.println("Fecha de Vista = " + filaEmpTable.getAttribute("EffectiveStartDate").toString());
                    Date efFiel = Estandares.deStringToDate( filaEmpTable.getAttribute("EffectiveStartDate").toString());
                    //System.out.println("String -> Date = " +  efFiel);
                    //fila.setAttribute("EfDateField",  efFiel );
                    
                    
                    //Fecha Efectiva del Grupo de Pago
                    //fila.setAttribute("EfStartDateAp005", new java.util.Date() );
                    
                    //Sequencia Efectiva: no se solicita al usuario asi que se omite para ser ejecutada por el sequencial en BD
                    //fila.setAttribute("EffectiveSequenceIdAp005", new Number(1));
                    
                    //Inserccion de Flag de registro activo:
                    //fila.setAttribute("SequenceFlag", "Y");
                    
                    //Numero de empleado
                    //fila.setAttribute("EmployeeNumberPs", filaEmpTable.getAttribute("EmployeNumberPsoft") );
                    
                    //Nombre completo
                    //fila.setAttribute("VendorName", filaEmpTable.getAttribute("VendorName") );
                    
                    //Estatus del usuario
                    //fila.setAttribute("ActiveUser", filaEmpTable.getAttribute("ActiveUser") );
                    
                    //Tipo de empleado
                    //fila.setAttribute("TypeEmployee", filaEmpTable.getAttribute("TypeUser") );
                    
                    /**Inserccion a Tabla con Fecha Efectiva**/
                    
                    /* updateMultiChangesSingleDayEffDatedVORow(String numEmp,
                     * String name,
                     * String status,
                     * String typeEmp, 
                     * Date efField,       : EffectiveStartDate(Date:Formato:"yyyy-MM-dd") Campo
                     * Date startDate,     : startDate(Date:FechaActual:Formato:"yyyy-MM-dd")
                     * Date endDate,       : endDate(Date:Formato:"yyyy-MM-dd")
                     * Date effectiveDate, : Fecha Actual en Date
                     * int mode)           : mode (1)
                     */
                     updateMultiChangesSingleDayEffDatedVORow(filaEmpTable.getAttribute("EmployeNumberPsoft").toString(),
                                                             filaEmpTable.getAttribute("VendorName").toString(),
                                                             filaEmpTable.getAttribute("ActiveUser").toString(),
                                                             filaEmpTable.getAttribute("TypeUser").toString(),
                                                             Estandares.dateToDateFormatoDB(efFiel),
                                                             null,
                                                             null,
                                                             new Date(),
                                                             1);
                     
                    //this.getEmployeeVO1().insertRow(fila);
                    filaEmpTable = this.getEmployeeTableVO1().next();
                }
                //this.getDBTransaction().commit();
                //Thread.sleep(10000);
                System.out.println("--------------------- Inserccion Empleados Correcta [AM]---------------------");
        }catch(TooManyObjectsException tmoe){
                tmoe.printStackTrace(); 
        /*}catch(InterruptedException e){
            System.out.println("que transcurran 2 segundos ok");
        */}catch(Exception e){
            e.printStackTrace(); 
        }
        
        return true;
    }
    
    
    /**Metodo Inserta Usuarios con mecanismo de Fecha Efectiva**/
    public void updateMultiChangesSingleDayEffDatedVORow(String numEmp, String name, String status, String typeEmp, Date efField, Date startDate, Date endDate, Date effectiveDate, Integer mode){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date objDate = new java.util.Date();
         
          try{
             if (effectiveDate != null) {
                 ApplicationModuleImpl rootAM = this.getRootApplicationModule();
                 rootAM.setProperty(EFF_DT_PROPERTY_STR, effectiveDate);
             }
             ViewObjectImpl vo = this.getEmpVO1();
             Row row = null;
             row = (vo.findByKey(new Key(new Object[]{ numEmp, null, null, "Y"}), 1))[0];
             //System.out.println("row.getAttributeCount() = " + row.getAttributeCount());
             //System.out.println("row.getKey().isNull() = " + row.getKey().isNull());
             if(mode==1)
                 row.setEffectiveDateMode(Row.EFFDT_UPDATE_MODE     );
             else if(mode==2)
                 row.setEffectiveDateMode(Row.EFFDT_UPDATE_CHANGE_INSERT_MODE       );
             else if(mode==3)
                 row.setEffectiveDateMode(Row.EFFDT_UPDATE_CORRECTION        );
             else if(mode==4)
                 row.setEffectiveDateMode(Row.EFFDT_UPDATE_NEW_EARLIEST_CHANGE_MODE        );       
             else if(mode==5)
                 row.setEffectiveDateMode(Row.EFFDT_UPDATE_OVERRIDE_MODE         );
             else if(mode==6)
                 row.setEffectiveDateMode(Row.EFFDT_NONE_MODE         );
             
            if(startDate!=null)
                 row.setAttribute("StartDate", startDate);
            if(endDate!=null)
                 row.setAttribute("EndDate", endDate);
            if(efField != null)
              row.setAttribute("EfDateField", sdf.format(efField));
            if(typeEmp != null)
              row.setAttribute("TypeEmployee", typeEmp);
            this.getDBTransaction().commit();
          
          }catch(ArrayIndexOutOfBoundsException aiobe){
              
              Row fila = this.getEmpVO1().createRow();
              //java.util.Date ff = Estandares.deStringToDate( filaEmpTable.getAttribute("EffectiveStartDate").toString());
              //System.out.println("String -> Date = " +  ff);
              
              System.out.println("Identificador nuevo = " + numEmp );
              fila.setAttribute("EmployeeNumberPs", numEmp);
              
              System.out.println("[1] efField = " + efField );
              System.out.println("[2] sdf.format(efField) = " + sdf.format(efField));
              fila.setAttribute("EfDateField", sdf.format(efField));
              fila.setAttribute("VendorName", name);
              fila.setAttribute("ActiveUser", status);
              fila.setAttribute("TypeEmployee", typeEmp);
              
              fila.setAttribute("StartDate", sdf.format(objDate));
              fila.setAttribute("EndDate", "4712-12-31");
              //row.setAttribute("Sequence", );
              fila.setAttribute("SequenceFlag", "Y");
              
              this.getEmpVO1().insertRow(fila);
              this.getDBTransaction().commit();
          }catch(Exception e){
              e.printStackTrace();
          }
     }

     
    /**Metodo que invoca un FUNCNTION en PL/SQL**/
    /* public Boolean insertEmp() {
        
        try{
                //Invocacion a Procedimiento almacenado SP:  UPDATE_EF_FLAG_EMPLOYEE(P__NUMEMPLOYEE NUMBER)
                
                //Obtenemos la filas de la EmployVOTable para insertarkas en el EmpleyVO
                Row filaEmpTable = this.getEmployeeTableVO1().first();
            
                while(filaEmpTable != null){
                    Row fila = this.getEmployeeVO1().createRow();
                    
                    
                    // Invocacion de una funcion FUNCTION: FN_UPD_FLAG_SEQUENCE(P__NU_EMPLOYEE NUMBER)
                    Integer numEmpleado = Integer.getInteger( filaEmpTable.getAttribute("EmployeNumberPsoft").toString() );
                    String resultadoEjecucion = "No Found";
                    Object rs = callStoredFunction(Types.VARCHAR, "HCMC_AP005_PACKAGE.FN_UPD_FLAG_SEQUENCE(?)", new Object[] { numEmpleado });
                    if (rs != null) {
                              resultadoEjecucion = rs.toString();
                              System.out.println(" resultadoEjecucion = " + resultadoEjecucion);
                    }
                    
                    
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("No. Empleado = " + filaEmpTable.getAttribute("EmployeNumberPsoft"));
                    System.out.println("Nombre = " + filaEmpTable.getAttribute("VendorName"));
                    System.out.println("Fecha Efectiva = " + filaEmpTable.getAttribute("EffectiveStartDate"));
                    System.out.println("Estatus = " + filaEmpTable.getAttribute("ActiveUser"));
                    System.out.println("Tipo Empleado = " + filaEmpTable.getAttribute("TypeUser"));
       
                        
                    System.out.println("--------------------------------------------------------------------------------");
                    //Inserccion de atributos del Objeto Programatico 1 a Objeto 2 Entity
                    
                    //ID No se �de por la condifuracion en la EO (sequencias)
                    //fila.setAttribute("Id", new Number(1));
                    
                    //Fechga Efectiva del campo
                    //Las fechas deden ser de tipo java.util.Date
                    System.out.println("Fecha de Vista = " + filaEmpTable.getAttribute("EffectiveStartDate").toString());
                    Date ff = Estandares.deStringToDate( filaEmpTable.getAttribute("EffectiveStartDate").toString());
                    System.out.println("String -> Date = " +  ff);
                    fila.setAttribute("EfDateField",  ff  );
                    
                    
                    //Fecha Efectiva del Grupo de Pago
                    fila.setAttribute("EfStartDateAp005", new java.util.Date() );
                    
                    //Sequencia Efectiva: no se solicita al usuario asi que se omite para ser ejecutada por el sequencial en BD
                    //fila.setAttribute("EffectiveSequenceIdAp005", new Number(1));
                    
                    //Inserccion de Flag de registro activo:
                    fila.setAttribute("SequenceFlag", "S");
                    
                    //Numero de empleado
                    fila.setAttribute("EmployeeNumberPs", filaEmpTable.getAttribute("EmployeNumberPsoft") );
                    
                    //Nombre completo
                    fila.setAttribute("VendorName", filaEmpTable.getAttribute("VendorName") );
                    
                    //Estatus del usuario
                    fila.setAttribute("ActiveUser", filaEmpTable.getAttribute("ActiveUser") );
                    
                    //Tipo de empleado
                    fila.setAttribute("TypeEmployee", filaEmpTable.getAttribute("TypeUser") );
                    
                    
                    this.getEmployeeVO1().insertRow(fila);
                    filaEmpTable = this.getEmployeeTableVO1().next();
                }
                this.getDBTransaction().commit();
                //Thread.sleep(10000);
                System.out.println("--------------------- Inserccion Empleados Correcta ---------------------");
        }catch(TooManyObjectsException tmoe){
                tmoe.printStackTrace(); 
        }catch(InterruptedException e){
            System.out.println("que transcurran 2 segundos ok");
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
        return true;
    } */
    
    
    /**Metodo que invoca un Funcion dentro d eun Paquete en Base de Datos**/
    public String updateEmployeeFlag(Integer numEmp) {
        
    String resultadoEjecucion = "No Found";
    if(numEmp > 0){
            Object rs = callStoredFunction(Types.VARCHAR, "HCMC_AP005_PACKAGE.FN_UPD_FLAG_SEQUENCE(?)", new Object[] {numEmp} );
            if (rs != null) {
                resultadoEjecucion = rs.toString();
                System.out.println(" resultadoEjecucion = " + resultadoEjecucion);
            }
    }
    return resultadoEjecucion;
    }

   /*  public Boolean insertEmployMethod(String fechaCreacion, String fechaEfectiva, String flag, String numEmp,String tipoEmp,String nomEmp, String estatus ) {
        
        try{
                    Row fila = this.getEmployeeVO1().createRow();
                    
                    //Numero de empleado
                    //fila.setAttribute("Id", id);
                    
                    //Fecha Efectiva del campo
                    fila.setAttribute("EfDateField", new Date() );
                    //Fecha Efectiva de Creacion
                    fila.setAttribute("EfStartDateAp005", new Date());
                    //Sequencia no se aplcara como parametro por que esta habilitada como nunca
                    //fila.setAttribute("EfSequenceIdAp005", );
                    //Bandera de Flag [s/n]
                    fila.setAttribute("SequenceFlag", flag);
                    //Numero de empleado
                    fila.setAttribute("EmployeeNumberPs", numEmp );
                    //Nombre completo de empleado
                    fila.setAttribute("VendorName", nomEmp );
                    //Estatus
                    fila.setAttribute("ActiveUser", estatus);
                    //Tipo de empleado
                    fila.setAttribute("TypeEmployee",tipoEmp );
                    this.getEmployeeVO1().insertRow(fila);
                    this.getDBTransaction().commit();
                
                System.out.println("------------- Inserccion Empleados Correcta -------------");
        }catch(TooManyObjectsException tmoe){
                tmoe.printStackTrace(); 
        
        }catch(Exception e){
            e.printStackTrace(); 
        }
        
        return true;
    } */
    
    /**  Metodo que solo actualiza en tabla **/
    public Boolean insertPayload(String payload, String estatus, String dateTime) {
        System.out.println("Estatus = " + estatus);
        Row fila = this.getBitacoraVO1().createRow();
        fila.setAttribute("Payload", payload );
        fila.setAttribute("Execution", new Date() );
        fila.setAttribute("Status", estatus);
        System.out.println("_________________________ Inserccion Empleados Correcta en BITACORA _________________________");
        this.getBitacoraVO1().insertRow(fila);
        this.getDBTransaction().commit();
        
        return true;
    }
    
    /** M�todo para llamar a la funci�n de base de datos 
         * @param sqlReturnType (Tipo de devoluci�n de la funci�n) 
         * @param stmt (Nombre de la funci�n con par�metros) 
         * @ param bindVars (Valor del par�metro) 
         * @return 
    **/ 

     protected Object callStoredFunction(int sqlReturnType, String stmt, Object[] bindVars) {
             CallableStatement cst = null;
             
             try {
                 //Creating sql statement
                 cst = this.getDBTransaction().createCallableStatement("begin ? := "+stmt+";end;", 0);
                 //Register dataType for return value
                 cst.registerOutParameter(1, sqlReturnType);
                 //Pass input parameters value
                 if (bindVars != null) {
                     for (int z = 0; z < bindVars.length; z++) {
                         cst.setObject(z + 2, bindVars[z]);
                     }
                 }
                 //cst.executeQuery();
                 cst.executeUpdate();
                 //Finally get returned value
                 return cst.getObject(1);
             } catch (SQLException e) {
                 throw new JboException(e.getMessage());
             } finally {
                 if (cst != null) {
                     try {
                         cst.close();
                     } catch (SQLException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }

    /**
     * Container's getter for EmployeeTableVO1.
     * @return EmployeeTableVO1
     */
    public EmployeeTableVOImpl getEmployeeTableVO1() {
        return (EmployeeTableVOImpl)findViewObject("EmployeeTableVO1");
    }


    /**
     * Container's getter for PropertyVO1.
     * @return PropertyVO1
     */
    public ViewObjectImpl getPropertyVO1() {
        return (ViewObjectImpl)findViewObject("PropertyVO1");
    }

    /**
     * Container's getter for EmpVO1.
     * @return EmpVO1
     */
    public ViewObjectImpl getEmpVO1() {
        return (ViewObjectImpl)findViewObject("EmpVO1");
    }

    /**
     * Container's getter for BitacoraVO1.
     * @return BitacoraVO1
     */
    public ViewObjectImpl getBitacoraVO1() {
        return (ViewObjectImpl)findViewObject("BitacoraVO1");
    }

    /**
     * Container's getter for AcesosVO1.
     * @return AcesosVO1
     */
    public ViewObjectImpl getAcesosVO1() {
        return (ViewObjectImpl)findViewObject("AcesosVO1");
    }

    /**
     * Container's getter for RequerimientoVO1.
     * @return RequerimientoVO1
     */
    public ViewObjectImpl getRequerimientoVO1() {
        return (ViewObjectImpl)findViewObject("RequerimientoVO1");
    }
}

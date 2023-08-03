package com.grupofarmacos.hcmc.ap005.view.custom.core;


import com.grupofarmacos.hcmc.ap005.view.utils.AppModReturn;
import com.grupofarmacos.hcmc.ap005.view.utils.ManejadorFechas;
import com.grupofarmacos.hcmc.sx002.model.bean.assignment.Assignment;
import com.grupofarmacos.hcmc.sx002.model.bean.employe.Employe;
import com.grupofarmacos.hcmc.sx002.model.exception.SX002Exception;
import com.grupofarmacos.hcmc.sx002.model.utilities.Utils;
import com.grupofarmacos.hcmc.sx002.model.vobject.HcmcRestConnector;
import com.grupofarmacos.hcmc.sx002.model.vobject.assignment.AssignmentVO;
import com.grupofarmacos.hcmc.sx002.model.vobject.employe.EmployeVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.OperationBinding;
import oracle.adf.model.binding.DCBindingContainer;

import org.apache.commons.lang.StringUtils;


public class EmployeeCustom {
    
    private BigDecimal index;
    private String employee_number_psoft;
    private String employee_number_old;
    private String first_name;
    private String last_name;
    private String gender;
    private String curp;
    private String from_date;
    private String to_date;
    private String birth_date;
    private String email;
    private String work_telephone;
    private String employee_number_sicoss;
    private String employee_number_sonarh;
    private String vendor_name;
    private String rfc;
    private String vendor_site_code;
    private String default_expense_account;
    private String liability_account;
    private String prepayment_account;
    private String bank_name;
    private BigDecimal account_num;
    private String currency_code;
    private String org_name;
    private String process_id;
    private BigDecimal org_id;
    private String creation_date;
    private String created_by;
    private String last_update_date;
    private String last_updated_by;
    private String effective_start_date;
    private BigDecimal effective_sequence;
    private String active_user;
    private String type_employ;
    private String previousLastName;
    ArrayList<String> P = null;
    
    public EmployeeCustom() {
        super();
        //ADFContext.initADFContext(null, null, null, null);
        setSecirity();
        //this.P = LeerArchivo.assigProperties();
    }

    /** Metodo que prueba la conexion a HCMC **/
    public static void main(String[] args) {
        EmployeeCustom objEmp = new EmployeeCustom();
        objEmp.searchEmploy("104");
    }
    
    /**Metodo de busqueda de empleados en HCMC Cloud**/
    public void searchEmploy(String numEmp) {
        StringBuilder restURI = new StringBuilder("");
        StringUtils Comunes = new StringUtils();
        if(Comunes.isNumeric(numEmp)){
        System.out.println("numEmp = " + numEmp);
        System.out.println("Comunes.isNumeric(numEmp) = " + Comunes.isNumeric(numEmp) );
            try {
                String fechaEfectiva = null;
                //System.out.println("Fecha efectiva = " + ManejadorFechas.getFechaActualDateTime());
                Boolean fechaE = true;
                //System.out.println("Numero de empleado = " + numEmp);
                restURI = new StringBuilder(P.get(0));
                //StringBuilder restURI = new StringBuilder("https://eflk-test.hcm.us2.oraclecloud.com:443/hcmCoreApi/resources/11.12.1.0/emps?q=PersonId=");
                if (fechaE) {
                    fechaEfectiva = ManejadorFechas.getEffectiveDay();
                    //System.out.println("Substring de fecha efectiva = " + fechaEfectiva.substring(0,10));  
                    restURI =
                            restURI.append(numEmp).append(";effectiveDate=").append(fechaEfectiva.substring(0,10));
                } else {
                    restURI = restURI.append(numEmp);
                }
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("URL = " + restURI.toString());
                System.out.println("------------------------------------------------------------------------------------------------");
                EmployeVO objVO = new EmployeVO(restURI.toString(), P.get(1), P.get(2), null);
                
                //EmployeVO objVO = new EmployeVO("https://eflk-test.hcm.us2.oraclecloud.com/hcmCoreApi/resources/11.12.1.0/emps?q=PersonNumber=", P.get(1), P.get(2), null);
                //EmployeVO objVO = new EmployeVO("https://eflk-test.hcm.us2.oraclecloud.com:443/hcmCoreApi/resources/latest/emps?q=PersonNumber=002962", P.get(1), P.get(2), null);
                //EmployeVO objVO = new EmployeVO("https://eflk-test.hcm.us2.oraclecloud.com:443/hcmCoreApi/resources/latest/emps?q=PersonNumber=000104;effectiveDate=2017-11-01", "TIGALLEGOS", "Ataway0917", null);
               
                
                if (objVO.getObjects().isEmpty()) {
                    System.out.println("_______________ No existe el empleado en HCMC Cloud ___________");
                    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null,"El numero de empleado " + numEmp +" no existe en el aplicativo HCMC Cloud ");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                } else {
                    System.out.println("_______________ El empleado existe en HCMC Cloud ___________");
                    //EmployeVO objVO = new EmployeVO(restURI.toString(),"TIGALLEGOS" ,"Ataway0917", null);
                    ArrayList<Employe> employesList = objVO.getObjects();
                    Boolean exitoso = searchAtributos(employesList.get(0),restURI);
                    System.out.println("_______________ Exito " + exitoso + "___________");
                    System.out.println("________________________________________________");
                    System.out.println("_______________ Empleado Listo _________________");
                    System.out.println("________________________________________________");
                }
            } catch (SX002Exception mE) {
                mE.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, null,"El parametro de busqueda debe ser un número entero");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    /**Metodo de busqueda de empleados en HCMC CLoud**/
    public Boolean clearView() {
        /* LIMPIEZA DE ATRIBUTOS 1° Nivel*/
        
            this.employee_number_psoft = "";
            this.employee_number_old = "";
            this.first_name = "";
            this.last_name = "";
            this.gender = "";
            this.curp = "";
            this.from_date =  "";
            this.to_date =  "";
            this.birth_date =  "";
            this.email = "";
            this.work_telephone = "";
            /* this.employee_number_sicoss = ;
            this.employee_number_sonarh = ;
            */
            /** Asignacion de nombre completo **/
            this.vendor_name = "";
            this.vendor_site_code = "";
            /* this.default_expense_account = ; */
            this.liability_account = "";
            this.prepayment_account = "";
            this.bank_name = "";
            /* this.account_num = ; */
            this.currency_code = "";
            this.org_name = "";
            /* this.process_id = ; */
            this.creation_date =  "";
            this.created_by = "";
            this.last_update_date =  "";
            this.last_updated_by = "1";
            
            /* LIMPIEZA DE ATRIBUTOS 2° Nivel ASSIGMENT*/
            /* this.rfc =  ; */
            this.org_id = null;
            this.active_user = "";
            
            /*LIM´PIEZA DE ATRIBUTOS DE 3° NIVEL*/
            this.type_employ = "";
            this.effective_start_date =  "";
        
        return true;
        
    }

    /** Metodo de asignacion de atributos**/
    public Boolean searchAtributos(Employe employe,StringBuilder uri) throws SX002Exception {

        Boolean activeUser = activeUser(employe);


        if (activeUser) {
            /* ASIGNACION DE ATRIBUTOS 1° Nivel*/
            if (employe.getPersonId() != null)
                this.employee_number_psoft = employe.getPersonId();
            if (employe.getPersonId() != null)
                this.employee_number_old = employe.getPersonId();
            if (employe.getFirstName() != null)
                this.first_name = employe.getFirstName();
            if (employe.getLastName() != null)
                this.last_name = employe.getLastName();
            if (employe.getGender() != null)
                this.gender = employe.getGender();
            if (employe.getNationalId() != null){
                this.curp = employe.getNationalId();
                this.rfc = employe.getNationalId();
            }
            if (employe.getHireDate() != null)
                this.from_date = employe.getHireDate().toString();
            if (employe.getTerminationDate() != null)
                this.to_date =  employe.getTerminationDate().toString();
            if (employe.getDateOfBirth() != null)
                this.birth_date = employe.getDateOfBirth().toString();
            if (employe.getWorkEmail() != null)
                this.email = employe.getWorkEmail();
            if (employe.getWorkPhoneNumber() != null)
                this.work_telephone = employe.getWorkPhoneNumber();
            /* this.employee_number_sicoss = ;
              this.employee_number_sonarh = ;
               */
            /** Asignacion de nombre completo **/
            if (employe.getLastName() != null && employe.getMiddleName() != null &&  employe.getFirstName() != null)
                this.vendor_name = employe.getLastName() + " " + employe.getMiddleName() + " " + employe.getFirstName();
            else if (employe.getLastName() != null &&  employe.getFirstName() != null){
                this.vendor_name = employe.getLastName() + " " + employe.getFirstName();
            }
            if (employe.getPersonNumber() != null)
                this.vendor_site_code = employe.getPersonNumber();
            /* this.default_expense_account = ; */
            this.liability_account = "18-046-6004-6010-3012-00-0000-000";
            this.prepayment_account = "06-085-1120-1802-0000-00-0000-000";
            this.bank_name = "BANCO SANTANDER SERFIN, S.A";
            /* this.account_num = ; */
            this.currency_code = "MXN";
            this.org_name = "I";
            /* this.process_id = ; */
            this.creation_date = ManejadorFechas.getFechaActual();
            this.created_by = "1";
            if (employe.getLastUpdateDate() != null)
            this.last_update_date = employe.getLastUpdateDate().toString();
            this.last_updated_by = "1";
            

            /* ASIGNACION DE ATRIBUTOS 2° Nivel ASSIGMENT*/
            AssignmentVO objAssignmentsVO = new AssignmentVO(Utils.getHREFByName(employe, "assignments"), P.get(1), P.get(2), null);
            //AssignmentVO objAssignmentsVO = new AssignmentVO(Utils.getHREFByName(employe, "assignments"), "TIGALLEGOS" ,"Ataway0917", null);
            ArrayList<Assignment> assignmentsList =  objAssignmentsVO.getObjects();
            /* this.rfc =  ; */
            if (assignmentsList.get(0).getDepartmentId() != null)
                this.org_id = new BigDecimal(assignmentsList.get(0).getDepartmentId().toString());
            
            this.active_user = "ACTIVE";
            
            /* ASIGNACION DE ATRIBUTOS DE 3 NIVEL ASSIGNMENTS DFP */
            //URI&fields=DisplayName,Salutation;assignments:AssignmentName,AssignmentId;assignments.assignmentDFF:AssignmentId,gfGrupoPago,EffectiveStartDate&expand=assignments,assignments.assignmentDFF&onlyData=true
            //uri.append("&fields=DisplayName,Salutation;assignments:AssignmentName,AssignmentId;assignments.assignmentDFF:AssignmentId,gfGrupoPago,EffectiveStartDate&expand=assignments,assignments.assignmentDFF&onlyData=true");
            uri.append(P.get(3).toString());
            System.out.println("________________________________________________________________________________________");
            System.out.println("URL Custom [Properties]= "+ uri.toString());
            System.out.println("________________________________________________________________________________________");
            //Se utiliza el objeto padre para navegacion generica
            HcmcRestConnector objCore = new HcmcRestConnector(uri.toString(),P.get(1),P.get(2));
            
            StringBuilder response = new StringBuilder("[").append(objCore.getResponseStream()).append("]");
            //System.out.println("response = " +response);
            DeserealizarGsonCustom des = new DeserealizarGsonCustom();
            ArrayList<String> atributos = des.deserializacionNiveles(response.toString());
            //System.out.println("Atributo 1 = " + atributos.get(0));
            //System.out.println("Atributo 2 = " + atributos.get(1));
            
            this.effective_start_date = atributos.get(0);
            //Conciderar los 2 primeros caracteres de la cadena
            this.type_employ = atributos.get(1).substring(0,2);
            
            
        }

        return activeUser;
    }

    /**Metodo de Utileria: Busca las propiedades de Conexion en PaaS**/
    public void setSecirity(){
        try{
        AppModReturn resul;
        Map params = new HashMap();
        params.put("criterial", "AP005");
        resul = (AppModReturn) invocarAM("getProperties", params);

       /*  if (resul.getErrors().isEmpty()) {
            System.out.println("Los datos retornados son = " + resul.getResult());
        } else {
            System.out.println("No pudo ejecutarse el metodo del AM");
        } */
        
        Map seguridad = new HashMap();
        seguridad = (Map) resul.getResult();
        P = new ArrayList<String>();
            
        Iterator it = seguridad.entrySet().iterator();
        System.out.println("[ Clave , Valor ] ");
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                System.out.println("[ "+e.getKey() + " , " + e.getValue()+" ]");
                P.add(e.getValue().toString());
           }
        //URL
        P.add(0, seguridad.get("1").toString());
        //User
        P.add(1, seguridad.get("2").toString());
        //Pass
        P.add(2, seguridad.get("3").toString());
        //Quey Custom:
        P.add(3, seguridad.get("4").toString());
        }catch(Exception e){
            e.printStackTrace();    
        }
        }
    
    /** Metodo Utileria Verificacion de usuario activos**/
    public Boolean activeUser(Employe employe) {
        Boolean user = false;
        String empActivo = null;

        try {
            /* Recoleccion de arreglo de Links y link unico */
            AssignmentVO objAssignmentsVO =
                new AssignmentVO(Utils.getHREFByName(employe, "assignments"),P.get(1), P.get(2), null);
            ArrayList<Assignment> assignmentsList;
            assignmentsList = objAssignmentsVO.getObjects();
            empActivo = assignmentsList.get(0).getAssignmentStatus();
            //System.out.println("assignmentsList.get(0).getAssignmentStatus(): " + assignmentsList.get(0).getAssignmentStatus());
            
            if (empActivo.equals("ACTIVE")) {
                user = true;
            } else {
                user = false;
            }

        } catch (SX002Exception e) {
            e.printStackTrace();

        }
        return user;
    }

    /**Metodo Utilitaria que invoca el modulo de alicaciones**/
    public AppModReturn invocarAM(String method, Map params) {
        AppModReturn am = new AppModReturn();
        
        try {
                        
            BindingContext bcx = new BindingContext().getCurrent();
            DCBindingContainer bc =
                (DCBindingContainer)bcx.getCurrentBindingsEntry();
            OperationBinding opb =
                (OperationBinding)bc.getOperationBinding(method);

            if (params != null) {
                opb.getParamsMap().putAll(params);
            }

            opb.invoke();
            am.setErrors(opb.getErrors());
            am.setResult(opb.getResult());
            

    
        } catch (Exception e) {

            e.printStackTrace();
        }
        return am;
    }
    
    public void setIndex(BigDecimal index) {
        this.index = index;
    }

    public BigDecimal getIndex() {
        return index;
    }

    public void setEmployee_number_psoft(String employee_number_psoft) {
        this.employee_number_psoft = employee_number_psoft;
    }

    public String getEmployee_number_psoft() {
        return employee_number_psoft;
    }

    public void setEmployee_number_old(String employee_number_old) {
        this.employee_number_old = employee_number_old;
    }

    public String getEmployee_number_old() {
        return employee_number_old;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCurp() {
        return curp;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setWork_telephone(String work_telephone) {
        this.work_telephone = work_telephone;
    }

    public String getWork_telephone() {
        return work_telephone;
    }

    public void setEmployee_number_sicoss(String employee_number_sicoss) {
        this.employee_number_sicoss = employee_number_sicoss;
    }

    public String getEmployee_number_sicoss() {
        return employee_number_sicoss;
    }

    public void setEmployee_number_sonarh(String employee_number_sonarh) {
        this.employee_number_sonarh = employee_number_sonarh;
    }

    public String getEmployee_number_sonarh() {
        return employee_number_sonarh;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    public void setVendor_site_code(String vendor_site_code) {
        this.vendor_site_code = vendor_site_code;
    }

    public String getVendor_site_code() {
        return vendor_site_code;
    }

    public void setDefault_expense_account(String default_expense_account) {
        this.default_expense_account = default_expense_account;
    }

    public String getDefault_expense_account() {
        return default_expense_account;
    }

    public void setLiability_account(String liability_account) {
        this.liability_account = liability_account;
    }

    public String getLiability_account() {
        return liability_account;
    }

    public void setPrepayment_account(String prepayment_account) {
        this.prepayment_account = prepayment_account;
    }

    public String getPrepayment_account() {
        return prepayment_account;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setAccount_num(BigDecimal account_num) {
        this.account_num = account_num;
    }

    public BigDecimal getAccount_num() {
        return account_num;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setProcess_id(String process_id) {
        this.process_id = process_id;
    }

    public String getProcess_id() {
        return process_id;
    }

    public void setOrg_id(BigDecimal org_id) {
        this.org_id = org_id;
    }

    public BigDecimal getOrg_id() {
        return org_id;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setLast_update_date(String last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getLast_update_date() {
        return last_update_date;
    }

    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }

    public String getLast_updated_by() {
        return last_updated_by;
    }

    public void setEffective_start_date(String effective_start_date) {
        this.effective_start_date = effective_start_date;
    }

    public String getEffective_start_date() {
        return effective_start_date;
    }

    public void setEffective_sequence(BigDecimal effective_sequence) {
        this.effective_sequence = effective_sequence;
    }

    public BigDecimal getEffective_sequence() {
        return effective_sequence;
    }

    public void setActive_user(String active_user) {
        this.active_user = active_user;
    }

    public String getActive_user() {
        return active_user;
    }

    public void setType_employ(String type_employ) {
        this.type_employ = type_employ;
    }

    public String getType_employ() {
        return type_employ;
    }

    public void setPreviousLastName(String previousLastName) {
        this.previousLastName = previousLastName;
    }

    public String getPreviousLastName() {
        return previousLastName;
    }
}

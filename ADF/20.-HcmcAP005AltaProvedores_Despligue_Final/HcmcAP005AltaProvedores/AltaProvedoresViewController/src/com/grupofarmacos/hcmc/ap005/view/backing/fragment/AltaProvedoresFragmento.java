package com.grupofarmacos.hcmc.ap005.view.backing.fragment;

import com.grupofarmacos.hcmc.ap005.view.custom.core.EmpType;
import com.grupofarmacos.hcmc.ap005.view.utils.ADFUtil;
import com.grupofarmacos.hcmc.ap005.view.utils.JSFUtils;
import com.grupofarmacos.hcmc.ap005.view.utils.ManejadorFechas;

import com.grupofarmacos.hcmc.ap005.view.ws.EmpleadosWS;

import java.util.ArrayList;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.layout.RichPanelLabelAndMessage;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandToolbarButton;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.adf.view.rich.util.FacesMessageUtils;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class AltaProvedoresFragmento {

    private RichPanelGroupLayout pgl1;
    private RichPanelHeader ph1;
    private RichPanelHeader ph2;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichCommandButton cb1;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichGridRow gr2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichGridRow gr3;
    private RichGridCell gc5;
    private RichGridCell gc6;
    private RichGridRow gr4;
    private RichGridCell gc7;
    private RichGridCell gc8;
    private RichGridRow gr5;
    private RichGridCell gc9;
    private RichGridCell gc10;
    private RichGridRow gr6;
    private RichGridCell gc11;
    private RichGridCell gc12;
    private RichGridRow gr7;
    private RichGridCell gc13;
    private RichGridCell gc14;
    private RichGridRow gr8;
    private RichGridCell gc15;
    private RichGridCell gc16;
    private RichGridRow gr9;
    private RichGridCell gc17;
    private RichGridCell gc18;
    private RichGridRow gr10;
    private RichGridCell gc19;
    private RichGridCell gc20;
    private RichGridRow gr11;
    private RichGridCell gc21;
    private RichGridCell gc22;
    private RichPanelLabelAndMessage plam1;
    private RichOutputText ot1;
    private RichPanelLabelAndMessage plam2;
    private RichOutputText ot2;
    private RichPanelLabelAndMessage plam3;
    private RichOutputText ot3;
    private RichPanelLabelAndMessage plam4;
    private RichOutputText ot4;
    private RichPanelLabelAndMessage plam5;
    private RichOutputText ot5;
    private RichPanelLabelAndMessage plam6;
    private RichOutputText ot6;
    private RichPanelLabelAndMessage plam7;
    private RichOutputText ot7;
    private RichPanelLabelAndMessage plam8;
    private RichOutputText ot8;
    private RichPanelLabelAndMessage plam9;
    private RichOutputText ot9;
    private RichPanelLabelAndMessage plam10;
    private RichOutputText ot10;
    private RichPanelLabelAndMessage plam11;
    private RichOutputText ot11;
    private RichPanelLabelAndMessage plam12;
    private RichOutputText ot12;
    private RichPanelLabelAndMessage plam13;
    private RichOutputText ot13;
    private RichPanelLabelAndMessage plam14;
    private RichOutputText ot14;
    private RichPanelLabelAndMessage plam15;
    private RichOutputText ot15;
    private RichPanelLabelAndMessage plam16;
    private RichOutputText ot16;
    private RichPanelLabelAndMessage plam17;
    private RichOutputText ot17;
    private RichPanelLabelAndMessage plam18;
    private RichOutputText ot18;
    private RichPanelLabelAndMessage plam19;
    private RichOutputText ot19;
    private RichPanelLabelAndMessage plam20;
    private RichOutputText ot20;
    private RichCommandButton cb2;
    private RichPanelCollection pc1;
    private RichTable t1;
    private RichToolbar t2;
    private RichCommandToolbarButton ctb1;
    private RichPanelGroupLayout pgl3;
    private RichPanelGroupLayout pgl4;
    private RichImage i1;


    //Popup Confirmacion
    private RichPopup p1;
    private RichDialog d1;
    //Popup Error Operation
    private RichPopup p2;
    private RichDialog d2;
    //Popup Success Operation
    private RichPopup p3;
    private RichDialog d3;
    //Popup Reloj Arena
    private RichPopup p4;
    private RichDialog d4;
    private RichCommandButton cb4;
    private RichPanelGroupLayout pgl5;
    private RichPanelStretchLayout psl1;
    private RichPanelLabelAndMessage plam21;
    private RichPanelLabelAndMessage plam22;
    private RichPanelStretchLayout psl2;
    private RichPanelStretchLayout psl3;
    private RichCommandButton cb5;
    private RichCommandButton cb6;
    private ArrayList<EmpType> listEmpleados;


    /** Metodo Agregar empleados desde una tabla programatica **/
    public String addEmployProgramatic() {
        //Me aseguro que la tabla tenga un partialTriger sobre le boton que esta ejecutando este metodo

        Boolean empleadoExiste = false;
        DCBindingContainer bindings = (DCBindingContainer) getBindings();

        /*Busqueda de parametros*/
        if (JSFUtils.resolveExpression("#{bindings.vendor_name.inputValue}") != null &&
            JSFUtils.resolveExpression("#{bindings.vendor_site_code.inputValue}") != null &&
            JSFUtils.resolveExpression("#{bindings.active_user.inputValue}") != null &&
            JSFUtils.resolveExpression("#{bindings.type_employ.inputValue}") != null &&
            JSFUtils.resolveExpression("#{bindings.effective_start_date.inputValue}") != null ) 
        {

            /**Bajamos los bindigns del contexto**/
            String numeroEmpleado = JSFUtils.resolveExpression("#{bindings.vendor_site_code.inputValue}").toString();
            String nombreCompleto = JSFUtils.resolveExpression("#{bindings.vendor_name.inputValue}").toString();
            String estatus =JSFUtils.resolveExpression("#{bindings.active_user.inputValue}").toString();
            String tipoCategoria =JSFUtils.resolveExpression("#{bindings.type_employ.inputValue}").toString();
            String fechaEfectiva =JSFUtils.resolveExpression("#{bindings.effective_start_date.inputValue}").toString();
            
            //System.out.println("---" + numeroEmpleado + " " + nombreCompleto + " " + estatus + " " + tipoCategoria + " " + fechaEfectiva + "---");
            
            /**Obtengo el Iterador de la tabla a la que deseo programar**/
            DCIteratorBinding iterator = (DCIteratorBinding)bindings.get("EmployeeTableVO1Iterator");
            /**Creamos un Row Iterator**/
            RowSetIterator rowSetIteratior = iterator.getRowSetIterator();
            ViewObject vo = iterator.getViewObject();
            

            /**Obtengo el tamaño de row del iterador**/
            int tam = rowSetIteratior.getRowCount();
            //System.out.println("Tamaña de objetos en tabla = " + tam);

            /**Creamos un row nuevo para insertarlo en la tabla**/
            Row rowInsert = null;

            if (tam > 0) {
                
                /**Colocamos el cursor en la primera fila**/
                Row row = rowSetIteratior.first();
                //Navegamos el iterador para identificar objetos iguales
                while(row != null){
                    //Buscamos duplicados
                    System.out.println("Num empleado Table :" + row.getAttribute("EmployeNumberPsoft").toString() );
                    if(row.getAttribute("EmployeNumberPsoft").toString().equals(numeroEmpleado)){
                        empleadoExiste = true;
                        System.out.println("_________________________ Empleado repetido _________________________");
                        System.out.println("___________________________________________________________________");
                    }
                    if(empleadoExiste)
                        break;
                    row = rowSetIteratior.next();
                }
                //Podria estar comentada para noa fectar la insercion cuando la bandera es false
                rowSetIteratior.closeRowSetIterator();
                    //Inserta empleado en caso de no encontrar duplicados
                    if(!empleadoExiste){
                        //Es primera vez que anexa valores
                        System.out.println("_________________________ Inserccion de un nuevo Empleado _________________________");
                        System.out.println("["+ numeroEmpleado+ " , "+ nombreCompleto + " , " + estatus + "]" );
                        System.out.println("__________________________________________________________________________________");
                        rowInsert =  rowSetIteratior.createRow();
                        rowInsert.setAttribute("EmployeNumberPsoft", numeroEmpleado);
                        rowInsert.setAttribute("VendorName", nombreCompleto);
                        rowInsert.setAttribute("ActiveUser", estatus);
                        rowInsert.setAttribute("TypeUser", tipoCategoria);
                        rowInsert.setAttribute("EffectiveStartDate", fechaEfectiva);
                        
                        vo.insertRow(rowInsert);
                    }else{
                        //En caso de existir un duplicado se lanza un mensaje de advertencia
                        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, null,"El empleado ya se encutra agregado en la tabla");
                        FacesContext.getCurrentInstance().addMessage(null, msg);
                    }
            }else{
                System.out.println("_________________________ Inserccion del 1° Empleado _________________________");
                System.out.println("[" + numeroEmpleado + " , " + nombreCompleto + " , " + estatus + "]");
                System.out.println("____________________________________________________________________________");
                rowInsert = rowSetIteratior.createRow();
                rowInsert.setAttribute("EmployeNumberPsoft", numeroEmpleado);
                rowInsert.setAttribute("VendorName", nombreCompleto);
                rowInsert.setAttribute("ActiveUser", estatus);
                rowInsert.setAttribute("TypeUser", tipoCategoria);
                rowInsert.setAttribute("EffectiveStartDate", fechaEfectiva);
                vo.insertRow(rowInsert);
                //this.buttonSend.setVisible(true);
                this.ctb1.setVisible(true);
                
            }


        }else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, null,"El empleado que desea insertar en la tabla no cumple con los parametros necesarios para ser enviado a Oracle EBS");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
        refresh();
    
    return null;
    
    }
        
    /**Metodo Action que oculta componente nativo**/
    public String setComponentVisible(){
        
        //if(componente.equals("ctb1")){
            DCBindingContainer bindings = (DCBindingContainer)getBindings();
            //Obtengo el Iterador de la tabla a la que deseo programar
            DCIteratorBinding iterator = (DCIteratorBinding)bindings.get("EmployeeTableVO1Iterator");
            //Creamos un Row Iterator
            RowSetIterator rowSetIteratior = iterator.getRowSetIterator();
            //Obtengo el tamaño de row del iterador
            int tam = rowSetIteratior.getRowCount();
            //Si cumple limpia la tabla
            if (tam <= 0) {
                //this.buttonSend.setVisible(false);
                this.ctb1.setVisible(false);
                
            }
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.ctb1);
        //}
        return null;
    }
    
    /** Metodo Agregar empleados desde una tabla programatica **/
    public String invokePopupSendClasification() {
        System.out.println("Entra al metodo incocarPopupEnviarCriterios()");
        //Mostrar Popup de Confirmacion
        mostrarAfPopup(this.p1);
        return "";
    }
    
    /** Metodo que ejecuta el la confirmacion del envio de la informacion a SOA - Guarda el exito/fallo dentro BD **/
     public String executeSend() {
            System.out.println("_________________________________________________________ executeSend()");
            Boolean resultOp = false;
            String mensaje = "N/A";
            StringBuilder payload = new StringBuilder();
            try{
            
            //1.-Lectura de Empleados de la tabla & Asignarla a una estructura Lista Empleados
            listEmpleados = cargarEmpleados();
            payload = EmpleadosWS.generaPayload(ManejadorFechas.getEffectiveDay().toString().substring(0,10), listEmpleados);
            Boolean exito = invokeWebServices();
            System.out.println("_________________________ Manejo de respuesta SOAP (2) _________________________");
             if(exito){
                //Guarda en BD Regristo de la tabla
                BindingContainer bindings = getBindings();
                OperationBinding op = bindings.getOperationBinding("insertEmploy");                    
                resultOp = (Boolean) op.execute();
                 //ocultarAfPopup(this.p4); 
                if(resultOp){
                    System.out.println("_________________________ Inserccion DB Exitosa _________________________");
                    //Thread.sleep(5000);
                    mostrarAfPopup(this.p3);
                    mensaje = "PROCESADO";
                }else{
                    System.out.println("_________________________ Inserccion DB Fallida _________________________");
                    mensaje = "SIN PROCESAR";
                }
                
             resultOp = insertPayload(payload.toString(),mensaje);
             
             }else{
                 //Inserccion a BD el Payload,Estatus,FechaActual (TIMESTRAP)
                 mensaje = "SIN PROCESAR";
                 
                 if(resultOp){
                     mostrarAfPopup(this.p2);
                     System.out.println("_________________________ Inserccion DB Exitosa _________________________");
                 }else{
                     System.out.println("_________________________ Inserccion DB Fallida _________________________");
                 }
                resultOp = insertPayload(payload.toString(),mensaje);
            }
                    
            }catch (Exception e){
                     //e.printStackTrace();
                     resultOp = insertPayload(payload.toString(),mensaje);    
             }
         
         return "";    
    }
    
    
    /**Metodo que Inserta el payload con el estatus asignado PROCESADO/SIN PROCESAR**/
    private Boolean insertPayload(String payload, String mensaje){
        System.out.println("insertPayload(mensaje) = " + mensaje );
        Boolean resultOp = false;
        BindingContainer bindings = getBindings();
        OperationBinding op = bindings.getOperationBinding("insertPayload");                    
        op.getParamsMap().put("payload",payload.toString());
        op.getParamsMap().put("estatus",mensaje);
        op.getParamsMap().put("dateTime",ManejadorFechas.getFechaActualDateTime());
        resultOp = (Boolean) op.execute();
        return resultOp;
    }
    
    /**Metodo que Invoca el WebServices de SOA para el envio de Empleados a EBS para su clasificacion acorde al negocio [GB/PR/GF]**/
    public Boolean invokeWebServices(){
        Boolean ban = false;
        
        try {
        //Cerrar Popup Confirmacion
        //ocultarAfPopup(this.p1); 
        //mostrarAfPopup(this.p4);
        //AdfFacesContext.getCurrentInstance ().addPartialTarget (this.p4);
            
        //2.-Invocar el metodo de EmpleadosWS.requestWebServices(fechaEfectiva, ListaEmpleados)
        EmpleadosWS empWS = new EmpleadosWS();
        String res[] = empWS.requestWebServices(ManejadorFechas.getEffectiveDay().toString().substring(0,10), listEmpleados);
        
        //3.-Asignacion del mensaje de exito por parte del servicio
            if(res[0].equals("0")){
                ADFUtil.setEL("#{pageFlowScope.msgSucess}", "El envio de solicitud de alta de empleados fue exitosa");
                ban= true;
            }else{
                ADFUtil.setEL("#{pageFlowScope.msgError}", res[1].toString());
                ban= false;
            }
        
        //Thread.sleep(10000);
        
        } catch (Exception e) {
                e.printStackTrace();
                // Asignacion del mensaje de exito por parte del servicio
                ADFUtil.setEL("#{pageFlowScope.msgError}", "Ocurrio un error al invocar el Web Services EBS");
        }
        return ban;
    }
    
    /**Metodo que refresca todos loc componentes de la pantalla**/
    public String refreshAll(){
        refresh();
        refreshTable();
        System.out.println("_________Ejecutando el refresh() 3° Nivel_____________");
        return "Componentes Limpios";
    }
        
    /** Metodo de Refresca campos **/
    public void refresh(){
       System.out.println("_________Ejecutando el refresh() 1° Nivel_____________");
       try {
            ADFUtil.setEL("#{bindings.employee_number_psoft.inputValue}",null);
            ADFUtil.setEL("#{bindings.vendor_name.inputValue}",null);
            ADFUtil.setEL("#{bindings.curp.inputValue}",null);
            ADFUtil.setEL("#{bindings.from_date.inputValue}",null); 
            ADFUtil.setEL("#{bindings.email.inputValue}",null);
            ADFUtil.setEL("#{bindings.rfc.inputValue}",null);
            ADFUtil.setEL("#{bindings.default_expense_account.inputValue}",null);
            ADFUtil.setEL("#{bindings.prepayment_account.inputValue}",null);
            ADFUtil.setEL("#{bindings.account_num.inputValue}",null);
            ADFUtil.setEL("#{bindings.org_name.inputValue}",null);
            ADFUtil.setEL("#{bindings.employee_number_psoft.inputValue}",null);
            ADFUtil.setEL("#{bindings.gender.inputValue}",null);
            ADFUtil.setEL("#{bindings.birth_date.inputValue}",null);
            ADFUtil.setEL("#{bindings.work_telephone.inputValue}",null);
            ADFUtil.setEL("#{bindings.vendor_site_code.inputValue}",null);
            ADFUtil.setEL("#{bindings.liability_account.inputValue}",null);
            ADFUtil.setEL("#{bindings.bank_name.inputValue}",null);
            ADFUtil.setEL("#{bindings.currency_code.inputValue}",null);
            ADFUtil.setEL("#{bindings.active_user.inputValue}",null);
            //setComponentVisible("buttonSend");
            setComponentVisible();
            
            ADFUtil.setEL("#{bindings.type_employ.inputValue}",null);
            ADFUtil.setEL("#{bindings.effective_start_date.inputValue}",null);
            
           
            
               
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
    }
    
    /** Metodo de Refresca Tabla de Empleados a clasificar**/
    public void refreshTable(){
        System.out.println("_________Ejecutando el refresh() 2° Nivel_____________");
       try {
           /**Obtengo el Iterador del VO que deseamos ejecutar una operacion[inser/delete]**/
           DCBindingContainer bindings = (DCBindingContainer)getBindings();
           DCIteratorBinding iterator = (DCIteratorBinding)bindings.get("EmployeeTableVO1Iterator");
           
           
           /** Creamos un Iterador de filas que tiene el VO**/
           RowSetIterator rowSI = iterator.getRowSetIterator();
           /**Obtengo el tamaño de row del iterador**/
           int tam = rowSI.getRowCount();
           //System.out.println("Tamaña de objetos en tabla = " + tam);
        
           
           /**Obtenemos el cursos de el vo **/
           ViewObject EmployeeTableVO = iterator.getViewObject();
           
           /**Ciclo de borrado**/
           while(EmployeeTableVO.hasNext()){
               EmployeeTableVO.removeCurrentRow();
           }
            /**Limpiamos el VO Programatico**/
            EmployeeTableVO.clearCache();
           /**Cerramos el Iterator**/
            rowSI.closeRowSetIterator();
            setComponentVisible();
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.t1);

           
    } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    /** Metodo de Carga de Empleados en Lista**/
    public ArrayList<EmpType> cargarEmpleados(){
     ArrayList<EmpType> lista = new ArrayList<EmpType>();
       try {
           
           //Obtengo el Iterador del VO que deseamos ejecutar una operacion[inser/delete/read]
           DCBindingContainer bindings = (DCBindingContainer)getBindings();
           DCIteratorBinding iterator = (DCIteratorBinding)bindings.get("EmployeeTableVO1Iterator");
                
           // Creamos un Row Set Iterador del Iterator
           RowSetIterator rowSI = iterator.getRowSetIterator();
        
           //Obtengo el tamaño de row del iterador
           int tam = rowSI.getRowCount();
           //System.out.println("cargarEmpleados() -> Tamaño de la tabla = " + tam );
           
           //Ceamos un contendor de ROW [filas] y asignamos el primer registro
           Row currentRow = rowSI.first();
           
           //Iteramos nuestras filas
           while(currentRow != null){
               EmpType emp = new EmpType();
               emp.setIdEmpleado(currentRow.getAttribute("EmployeNumberPsoft").toString().replaceFirst ("^0*", ""));
               emp.setNumEmpleado(currentRow.getAttribute("EmployeNumberPsoft").toString());
               emp.setTipoEmpleado(currentRow.getAttribute("TypeUser").toString());
               emp.setFechaEfectiva(currentRow.getAttribute("EffectiveStartDate").toString());
               emp.setEstatusEmpleado(currentRow.getAttribute("ActiveUser").toString());
               lista.add(emp);
               //Recorremos el Row Set Iterator para qeu asigne la siguiente ROW[fila] al contenedor de filas
               currentRow = rowSI.next();
               
           }

           //Cerramos el Iterator
            rowSI.closeRowSetIterator();
           
      /*      System.out.println("-----------Lista---------------");
           //Imprimir Lista
           for(EmpType obj : lista){
               System.out.println("Emp");
               System.out.println("--" + obj.getIdEmpleado());
               System.out.println("--" + obj.getNumEmpleado());
               System.out.println("--" + obj.getTipoEmpleado());
               System.out.println("--" + obj.getFechaEfectiva());
               System.out.println("--" + obj.getEstatusEmpleado());
               
           } */
           
           
           
           return lista;
    } catch (Exception e) {
            e.printStackTrace();
        }
    return lista;
 }
    
    /** Metodo de Utileria Abre popop progrmaticamente **/
    public static void mostrarAfPopup(RichPopup popup) {
      FacesContext ctx = FacesContext.getCurrentInstance();
      String popupId = popup.getClientId(ctx);
      //System.out.println("Identificador popup apertura = " + popupId);
      ExtendedRenderKitService erkService = Service.getService(ctx.getRenderKit(),ExtendedRenderKitService.class);
      erkService.addScript(ctx,"var hints = {autodismissNever:true}; " + "AdfPage.PAGE.findComponent('" + popupId +  "').show(hints);");
    }
    
    /** Metodo de Utileria Cierra popop progrmaticamente **/
    public static void ocultarAfPopup(RichPopup popup) {
    FacesContext ctx = FacesContext.getCurrentInstance();
    String popupId = popup.getClientId(ctx);
    //System.out.println("Identificador popup cierre = " + popupId);
    ExtendedRenderKitService erkService = Service.getService(ctx.getRenderKit(),ExtendedRenderKitService.class);
    erkService.addScript(ctx,"var hints = {autodismissNever:true}; " + "AdfPage.PAGE.findComponent('" + popupId + "').hide();");
    }
    
    /** Metodo de Utileria Abre popop RELOJ ARENA programaticamente **/
    public void showPopupRelojArena(ActionEvent actionEvent) {
        System.out.println("_________________________________________________________ showPopupRelojArena(ActionEvent actionEvent)");
              RichPopup.PopupHints hints = new RichPopup.PopupHints();
              this.getP4().show(hints);
     
    }
    
    /** Metodo de Utileria Cierra popop RELOJ ARENA programaticamente **/
    public void hidePopupRelojArena(ActionEvent actionEvent) {
          System.out.println("_________________________________________________________ hidePopupRelojArena(ActionEvent actionEvent)");
               RichPopup.PopupHints hints = new RichPopup.PopupHints();
               this.getP4().hide();
     
      }

    /** Metodo que obtiene le contexto del los bindigns **/
    public static BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public void setPh2(RichPanelHeader ph2) {
        this.ph2 = ph2;
    }

    public RichPanelHeader getPh2() {
        return ph2;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichDialog getD1() {
        return d1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setPgl2(RichPanelGridLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGridLayout getPgl2() {
        return pgl2;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc6() {
        return gc6;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGc7(RichGridCell gc7) {
        this.gc7 = gc7;
    }

    public RichGridCell getGc7() {
        return gc7;
    }

    public void setGc8(RichGridCell gc8) {
        this.gc8 = gc8;
    }

    public RichGridCell getGc8() {
        return gc8;
    }

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGc9(RichGridCell gc9) {
        this.gc9 = gc9;
    }

    public RichGridCell getGc9() {
        return gc9;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

    public void setGr6(RichGridRow gr6) {
        this.gr6 = gr6;
    }

    public RichGridRow getGr6() {
        return gr6;
    }

    public void setGc11(RichGridCell gc11) {
        this.gc11 = gc11;
    }

    public RichGridCell getGc11() {
        return gc11;
    }

    public void setGc12(RichGridCell gc12) {
        this.gc12 = gc12;
    }

    public RichGridCell getGc12() {
        return gc12;
    }

    public void setGr7(RichGridRow gr7) {
        this.gr7 = gr7;
    }

    public RichGridRow getGr7() {
        return gr7;
    }

    public void setGc13(RichGridCell gc13) {
        this.gc13 = gc13;
    }

    public RichGridCell getGc13() {
        return gc13;
    }

    public void setGc14(RichGridCell gc14) {
        this.gc14 = gc14;
    }

    public RichGridCell getGc14() {
        return gc14;
    }

    public void setGr8(RichGridRow gr8) {
        this.gr8 = gr8;
    }

    public RichGridRow getGr8() {
        return gr8;
    }

    public void setGc15(RichGridCell gc15) {
        this.gc15 = gc15;
    }

    public RichGridCell getGc15() {
        return gc15;
    }

    public void setGc16(RichGridCell gc16) {
        this.gc16 = gc16;
    }

    public RichGridCell getGc16() {
        return gc16;
    }

    public void setGr9(RichGridRow gr9) {
        this.gr9 = gr9;
    }

    public RichGridRow getGr9() {
        return gr9;
    }

    public void setGc17(RichGridCell gc17) {
        this.gc17 = gc17;
    }

    public RichGridCell getGc17() {
        return gc17;
    }

    public void setGc18(RichGridCell gc18) {
        this.gc18 = gc18;
    }

    public RichGridCell getGc18() {
        return gc18;
    }

    public void setGr10(RichGridRow gr10) {
        this.gr10 = gr10;
    }

    public RichGridRow getGr10() {
        return gr10;
    }

    public void setGc19(RichGridCell gc19) {
        this.gc19 = gc19;
    }

    public RichGridCell getGc19() {
        return gc19;
    }

    public void setGc20(RichGridCell gc20) {
        this.gc20 = gc20;
    }

    public RichGridCell getGc20() {
        return gc20;
    }

    public void setGr11(RichGridRow gr11) {
        this.gr11 = gr11;
    }

    public RichGridRow getGr11() {
        return gr11;
    }

    public void setGc21(RichGridCell gc21) {
        this.gc21 = gc21;
    }

    public RichGridCell getGc21() {
        return gc21;
    }

    public void setGc22(RichGridCell gc22) {
        this.gc22 = gc22;
    }

    public RichGridCell getGc22() {
        return gc22;
    }

    public void setPlam1(RichPanelLabelAndMessage plam1) {
        this.plam1 = plam1;
    }

    public RichPanelLabelAndMessage getPlam1() {
        return plam1;
    }

    public void setOt1(RichOutputText ot1) {
        this.ot1 = ot1;
    }

    public RichOutputText getOt1() {
        return ot1;
    }

    public void setPlam2(RichPanelLabelAndMessage plam2) {
        this.plam2 = plam2;
    }

    public RichPanelLabelAndMessage getPlam2() {
        return plam2;
    }

    public void setOt2(RichOutputText ot2) {
        this.ot2 = ot2;
    }

    public RichOutputText getOt2() {
        return ot2;
    }

    public void setPlam3(RichPanelLabelAndMessage plam3) {
        this.plam3 = plam3;
    }

    public RichPanelLabelAndMessage getPlam3() {
        return plam3;
    }

    public void setOt3(RichOutputText ot3) {
        this.ot3 = ot3;
    }

    public RichOutputText getOt3() {
        return ot3;
    }

    public void setPlam4(RichPanelLabelAndMessage plam4) {
        this.plam4 = plam4;
    }

    public RichPanelLabelAndMessage getPlam4() {
        return plam4;
    }

    public void setOt4(RichOutputText ot4) {
        this.ot4 = ot4;
    }

    public RichOutputText getOt4() {
        return ot4;
    }

    public void setPlam5(RichPanelLabelAndMessage plam5) {
        this.plam5 = plam5;
    }

    public RichPanelLabelAndMessage getPlam5() {
        return plam5;
    }

    public void setOt5(RichOutputText ot5) {
        this.ot5 = ot5;
    }

    public RichOutputText getOt5() {
        return ot5;
    }

    public void setPlam6(RichPanelLabelAndMessage plam6) {
        this.plam6 = plam6;
    }

    public RichPanelLabelAndMessage getPlam6() {
        return plam6;
    }

    public void setOt6(RichOutputText ot6) {
        this.ot6 = ot6;
    }

    public RichOutputText getOt6() {
        return ot6;
    }

    public void setPlam7(RichPanelLabelAndMessage plam7) {
        this.plam7 = plam7;
    }

    public RichPanelLabelAndMessage getPlam7() {
        return plam7;
    }

    public void setOt7(RichOutputText ot7) {
        this.ot7 = ot7;
    }

    public RichOutputText getOt7() {
        return ot7;
    }

    public void setPlam8(RichPanelLabelAndMessage plam8) {
        this.plam8 = plam8;
    }

    public RichPanelLabelAndMessage getPlam8() {
        return plam8;
    }

    public void setOt8(RichOutputText ot8) {
        this.ot8 = ot8;
    }

    public RichOutputText getOt8() {
        return ot8;
    }

    public void setPlam9(RichPanelLabelAndMessage plam9) {
        this.plam9 = plam9;
    }

    public RichPanelLabelAndMessage getPlam9() {
        return plam9;
    }

    public void setOt9(RichOutputText ot9) {
        this.ot9 = ot9;
    }

    public RichOutputText getOt9() {
        return ot9;
    }

    public void setPlam10(RichPanelLabelAndMessage plam10) {
        this.plam10 = plam10;
    }

    public RichPanelLabelAndMessage getPlam10() {
        return plam10;
    }

    public void setOt10(RichOutputText ot10) {
        this.ot10 = ot10;
    }

    public RichOutputText getOt10() {
        return ot10;
    }

    public void setPlam11(RichPanelLabelAndMessage plam11) {
        this.plam11 = plam11;
    }

    public RichPanelLabelAndMessage getPlam11() {
        return plam11;
    }

    public void setOt11(RichOutputText ot11) {
        this.ot11 = ot11;
    }

    public RichOutputText getOt11() {
        return ot11;
    }

    public void setPlam12(RichPanelLabelAndMessage plam12) {
        this.plam12 = plam12;
    }

    public RichPanelLabelAndMessage getPlam12() {
        return plam12;
    }

    public void setOt12(RichOutputText ot12) {
        this.ot12 = ot12;
    }

    public RichOutputText getOt12() {
        return ot12;
    }

    public void setPlam13(RichPanelLabelAndMessage plam13) {
        this.plam13 = plam13;
    }

    public RichPanelLabelAndMessage getPlam13() {
        return plam13;
    }

    public void setOt13(RichOutputText ot13) {
        this.ot13 = ot13;
    }

    public RichOutputText getOt13() {
        return ot13;
    }

    public void setPlam14(RichPanelLabelAndMessage plam14) {
        this.plam14 = plam14;
    }

    public RichPanelLabelAndMessage getPlam14() {
        return plam14;
    }

    public void setOt14(RichOutputText ot14) {
        this.ot14 = ot14;
    }

    public RichOutputText getOt14() {
        return ot14;
    }

    public void setPlam15(RichPanelLabelAndMessage plam15) {
        this.plam15 = plam15;
    }

    public RichPanelLabelAndMessage getPlam15() {
        return plam15;
    }

    public void setOt15(RichOutputText ot15) {
        this.ot15 = ot15;
    }

    public RichOutputText getOt15() {
        return ot15;
    }

    public void setPlam16(RichPanelLabelAndMessage plam16) {
        this.plam16 = plam16;
    }

    public RichPanelLabelAndMessage getPlam16() {
        return plam16;
    }

    public void setOt16(RichOutputText ot16) {
        this.ot16 = ot16;
    }

    public RichOutputText getOt16() {
        return ot16;
    }

    public void setPlam17(RichPanelLabelAndMessage plam17) {
        this.plam17 = plam17;
    }

    public RichPanelLabelAndMessage getPlam17() {
        return plam17;
    }

    public void setOt17(RichOutputText ot17) {
        this.ot17 = ot17;
    }

    public RichOutputText getOt17() {
        return ot17;
    }

    public void setPlam18(RichPanelLabelAndMessage plam18) {
        this.plam18 = plam18;
    }

    public RichPanelLabelAndMessage getPlam18() {
        return plam18;
    }

    public void setOt18(RichOutputText ot18) {
        this.ot18 = ot18;
    }

    public RichOutputText getOt18() {
        return ot18;
    }

    public void setPlam19(RichPanelLabelAndMessage plam19) {
        this.plam19 = plam19;
    }

    public RichPanelLabelAndMessage getPlam19() {
        return plam19;
    }

    public void setOt19(RichOutputText ot19) {
        this.ot19 = ot19;
    }

    public RichOutputText getOt19() {
        return ot19;
    }

    public void setPlam20(RichPanelLabelAndMessage plam20) {
        this.plam20 = plam20;
    }

    public RichPanelLabelAndMessage getPlam20() {
        return plam20;
    }

    public void setOt20(RichOutputText ot20) {
        this.ot20 = ot20;
    }

    public RichOutputText getOt20() {
        return ot20;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }


    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }


    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

    public void setCtb1(RichCommandToolbarButton ctb1) {
        this.ctb1 = ctb1;
    }

    public RichCommandToolbarButton getCtb1() {
        return ctb1;
    }


    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void setD2(RichDialog d2) {
        this.d2 = d2;
    }

    public RichDialog getD2() {
        return d2;
    }

    public void setP3(RichPopup p3) {
        this.p3 = p3;
    }

    public RichPopup getP3() {
        return p3;
    }

    public void setD3(RichDialog d3) {
        this.d3 = d3;
    }

    public RichDialog getD3() {
        return d3;
    }

    public void setP4(RichPopup p4) {
        this.p4 = p4;
    }

    public RichPopup getP4() {
        return p4;
    }

    public void setD4(RichDialog d4) {
        this.d4 = d4;
    }

    public RichDialog getD4() {
        return d4;
    }


    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }


    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }


    public void setI1(RichImage i1) {
        this.i1 = i1;
    }

    public RichImage getI1() {
        return i1;
    }


    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setPgl5(RichPanelGroupLayout pgl5) {
        this.pgl5 = pgl5;
    }

    public RichPanelGroupLayout getPgl5() {
        return pgl5;
    }

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setPlam21(RichPanelLabelAndMessage plam21) {
        this.plam21 = plam21;
    }

    public RichPanelLabelAndMessage getPlam21() {
        return plam21;
    }

    public void setPlam22(RichPanelLabelAndMessage plam22) {
        this.plam22 = plam22;
    }

    public RichPanelLabelAndMessage getPlam22() {
        return plam22;
    }

    public void setPsl2(RichPanelStretchLayout psl2) {
        this.psl2 = psl2;
    }

    public RichPanelStretchLayout getPsl2() {
        return psl2;
    }

    public void setPsl3(RichPanelStretchLayout psl3) {
        this.psl3 = psl3;
    }

    public RichPanelStretchLayout getPsl3() {
        return psl3;
    }


    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }
}

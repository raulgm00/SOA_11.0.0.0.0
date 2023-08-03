package com.grupofarmacos.hcmc.ap005.view.custom.core;

public class EmpType {
   
   private String idEmpleado;
   private String numEmpleado;
   private String tipoEmpleado;
   private String fechaEfectiva;
   private String estatusEmpleado;
  
    
    public EmpType() {
        super();
    }
    
    public EmpType(String idEmp, String numEmp, String tipEmp, String fE, String estEmp) {
      this.idEmpleado = idEmp;
      this.numEmpleado = numEmp;
      this. tipoEmpleado = tipEmp;
      this.fechaEfectiva = fE;
      this.estatusEmpleado = estEmp;
    }


    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setFechaEfectiva(String fechaEfectiva) {
        this.fechaEfectiva = fechaEfectiva;
    }

    public String getFechaEfectiva() {
        return fechaEfectiva;
    }

    public void setEstatusEmpleado(String estatusEmpleado) {
        this.estatusEmpleado = estatusEmpleado;
    }

    public String getEstatusEmpleado() {
        return estatusEmpleado;
    }
}

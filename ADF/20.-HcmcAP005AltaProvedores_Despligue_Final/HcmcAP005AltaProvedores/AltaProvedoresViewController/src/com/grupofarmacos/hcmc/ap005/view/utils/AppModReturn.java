package com.grupofarmacos.hcmc.ap005.view.utils;
import java.util.List;

public class AppModReturn {
    
    private Object result;
    private List errors;
    
    public AppModReturn() {
        super();
    }


    public void setResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setErrors(List errors) {
        this.errors = errors;
    }

    public List getErrors() {
        return errors;
    }
}

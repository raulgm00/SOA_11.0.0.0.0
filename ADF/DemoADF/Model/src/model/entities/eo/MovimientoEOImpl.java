package model.entities.eo;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.DBSequence;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/*import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Logger;*/


// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Dec 27 14:40:41 CST 2020
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MovimientoEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        IdMovimiento {
            public Object get(MovimientoEOImpl obj) {
                return obj.getIdMovimiento();
            }

            public void put(MovimientoEOImpl obj, Object value) {
                obj.setIdMovimiento((DBSequence)value);
            }
        }
        ,
        IdCliente {
            public Object get(MovimientoEOImpl obj) {
                return obj.getIdCliente();
            }

            public void put(MovimientoEOImpl obj, Object value) {
                obj.setIdCliente((Number)value);
            }
        }
        ,
        Estado {
            public Object get(MovimientoEOImpl obj) {
                return obj.getEstado();
            }

            public void put(MovimientoEOImpl obj, Object value) {
                obj.setEstado((String)value);
            }
        }
        ,
        FechaMov {
            public Object get(MovimientoEOImpl obj) {
                return obj.getFechaMov();
            }

            public void put(MovimientoEOImpl obj, Object value) {
                obj.setFechaMov((Date)value);
            }
        }
        ,
        Total {
            public Object get(MovimientoEOImpl obj) {
                return obj.getTotal();
            }

            public void put(MovimientoEOImpl obj, Object value) {
                obj.setTotal((Number)value);
            }
        }
        ,
        DetalleEO {
            public Object get(MovimientoEOImpl obj) {
                return obj.getDetalleEO();
            }

            public void put(MovimientoEOImpl obj, Object value) {
                obj.setAttributeInternal(index(), value);
            }
        }
        ,
        ClienteEO {
            public Object get(MovimientoEOImpl obj) {
                return obj.getClienteEO();
            }

            public void put(MovimientoEOImpl obj, Object value) {
                obj.setClienteEO((EntityImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(MovimientoEOImpl object);

        public abstract void put(MovimientoEOImpl object, Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }
    //public static final org.apache.log4j.Logger log = new Logger.getLogger(MovimientoEOImpl.class);
    public static final int IDMOVIMIENTO = AttributesEnum.IdMovimiento.index();
    public static final int IDCLIENTE = AttributesEnum.IdCliente.index();
    public static final int ESTADO = AttributesEnum.Estado.index();
    public static final int FECHAMOV = AttributesEnum.FechaMov.index();
    public static final int TOTAL = AttributesEnum.Total.index();
    public static final int DETALLEEO = AttributesEnum.DetalleEO.index();
    public static final int CLIENTEEO = AttributesEnum.ClienteEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public MovimientoEOImpl() throws FileNotFoundException {
    
        /*
         * D:\Hp\ssd\JDeveloper_11g\mywork\DemoADF\Model\src\model
         * */
        File log4jProperties = new File("src/model/log4j.properties");
        PropertyConfigurator.configure(new FileInputStream(log4jProperties));
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("model.entities.eo.MovimientoEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for IdMovimiento, using the alias name IdMovimiento.
     * @return the IdMovimiento
     */
    public DBSequence getIdMovimiento() {
        return (DBSequence)getAttributeInternal(IDMOVIMIENTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for IdMovimiento.
     * @param value value to set the IdMovimiento
     */
    public void setIdMovimiento(DBSequence value) {
        setAttributeInternal(IDMOVIMIENTO, value);
    }

    /**
     * Gets the attribute value for IdCliente, using the alias name IdCliente.
     * @return the IdCliente
     */
    public Number getIdCliente() {
        return (Number)getAttributeInternal(IDCLIENTE);
    }

    /**
     * Sets <code>value</code> as the attribute value for IdCliente.
     * @param value value to set the IdCliente
     */
    public void setIdCliente(Number value) {
        setAttributeInternal(IDCLIENTE, value);
    }

    /**
     * Gets the attribute value for Estado, using the alias name Estado.
     * @return the Estado
     */
    public String getEstado() {
        return (String)getAttributeInternal(ESTADO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Estado.
     * @param value value to set the Estado
     */
    public void setEstado(String value) {
        setAttributeInternal(ESTADO, value);
    }

    /**
     * Gets the attribute value for FechaMov, using the alias name FechaMov.
     * @return the FechaMov
     */
    public Date getFechaMov() {
        return (Date)getAttributeInternal(FECHAMOV);
    }

    /**
     * Sets <code>value</code> as the attribute value for FechaMov.
     * @param value value to set the FechaMov
     */
    public void setFechaMov(Date value) {
        setAttributeInternal(FECHAMOV, value);
    }

    /**
     * Gets the attribute value for Total, using the alias name Total.
     * @return the Total
     */
    public Number getTotal() {
        return (Number)getAttributeInternal(TOTAL);
    }

    /**
     * Sets <code>value</code> as the attribute value for Total.
     * @param value value to set the Total
     */
    public void setTotal(Number value) {
        setAttributeInternal(TOTAL, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getDetalleEO() {
        return (RowIterator)getAttributeInternal(DETALLEEO);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getClienteEO() {
        return (EntityImpl)getAttributeInternal(CLIENTEEO);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setClienteEO(EntityImpl value) {
        setAttributeInternal(CLIENTEEO, value);
    }


    /**
     * @param idMovimiento key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(DBSequence idMovimiento) {
        return new Key(new Object[]{idMovimiento});
    }

    public void calcularTotal(){
            float totalDetalle=0;
            RowIterator iteDetalle = this.getDetalleEO();
            
            while(iteDetalle.hasNext()){
                Row filaDatalle = iteDetalle.next();
                totalDetalle = totalDetalle +((Number) filaDatalle.getAttribute("Subtotal")).floatValue();
            }
            System.out.println( "==========REDONDEO =============" );
            //Formula para redon y casteo de daots en java
            totalDetalle = (float) (Math.round(totalDetalle*100d)/100d);
            System.out.println( totalDetalle );
            System.out.println( "=================================" );
            //(float) -> NUMBER(8,2)
            this.setTotal(new Number(totalDetalle));
        }
}

/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.routines;


import org.example.table_generated.pg_catalog.PgCatalog;
import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class XmlIsWellFormed extends AbstractRoutine<Boolean> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>pg_catalog.xml_is_well_formed.RETURN_VALUE</code>.
     */
    public static final Parameter<Boolean> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.BOOLEAN, false, false);

    /**
     * The parameter <code>pg_catalog.xml_is_well_formed._1</code>.
     */
    public static final Parameter<String> _1 = Internal.createParameter("_1", SQLDataType.CLOB, false, true);

    /**
     * Create a new routine call instance
     */
    public XmlIsWellFormed() {
        super("xml_is_well_formed", PgCatalog.PG_CATALOG, SQLDataType.BOOLEAN);

        setReturnParameter(RETURN_VALUE);
        addInParameter(_1);
    }

    /**
     * Set the <code>_1</code> parameter IN value to the routine
     */
    public void set__1(String value) {
        setValue(_1, value);
    }

    /**
     * Set the <code>_1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__1(Field<String> field) {
        setField(_1, field);
    }
}
/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.routines;


import java.time.LocalDateTime;

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
public class TimestampLarger extends AbstractRoutine<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>pg_catalog.timestamp_larger.RETURN_VALUE</code>.
     */
    public static final Parameter<LocalDateTime> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.LOCALDATETIME(6), false, false);

    /**
     * The parameter <code>pg_catalog.timestamp_larger._1</code>.
     */
    public static final Parameter<LocalDateTime> _1 = Internal.createParameter("_1", SQLDataType.LOCALDATETIME(6), false, true);

    /**
     * The parameter <code>pg_catalog.timestamp_larger._2</code>.
     */
    public static final Parameter<LocalDateTime> _2 = Internal.createParameter("_2", SQLDataType.LOCALDATETIME(6), false, true);

    /**
     * Create a new routine call instance
     */
    public TimestampLarger() {
        super("timestamp_larger", PgCatalog.PG_CATALOG, SQLDataType.LOCALDATETIME(6));

        setReturnParameter(RETURN_VALUE);
        addInParameter(_1);
        addInParameter(_2);
    }

    /**
     * Set the <code>_1</code> parameter IN value to the routine
     */
    public void set__1(LocalDateTime value) {
        setValue(_1, value);
    }

    /**
     * Set the <code>_1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__1(Field<LocalDateTime> field) {
        setField(_1, field);
    }

    /**
     * Set the <code>_2</code> parameter IN value to the routine
     */
    public void set__2(LocalDateTime value) {
        setValue(_2, value);
    }

    /**
     * Set the <code>_2</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__2(Field<LocalDateTime> field) {
        setField(_2, field);
    }
}
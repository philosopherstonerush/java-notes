/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.routines;


import org.example.table_generated.pg_catalog.PgCatalog;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PgGetWalReplayPauseState extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter
     * <code>pg_catalog.pg_get_wal_replay_pause_state.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * Create a new routine call instance
     */
    public PgGetWalReplayPauseState() {
        super("pg_get_wal_replay_pause_state", PgCatalog.PG_CATALOG, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
    }
}

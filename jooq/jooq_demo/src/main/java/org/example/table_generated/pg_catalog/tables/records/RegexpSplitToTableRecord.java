/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables.records;


import org.example.table_generated.pg_catalog.tables.RegexpSplitToTable;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RegexpSplitToTableRecord extends TableRecordImpl<RegexpSplitToTableRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for
     * <code>pg_catalog.regexp_split_to_table.regexp_split_to_table</code>.
     */
    public void setRegexpSplitToTable(String value) {
        set(0, value);
    }

    /**
     * Getter for
     * <code>pg_catalog.regexp_split_to_table.regexp_split_to_table</code>.
     */
    public String getRegexpSplitToTable() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RegexpSplitToTableRecord
     */
    public RegexpSplitToTableRecord() {
        super(RegexpSplitToTable.REGEXP_SPLIT_TO_TABLE);
    }

    /**
     * Create a detached, initialised RegexpSplitToTableRecord
     */
    public RegexpSplitToTableRecord(String regexpSplitToTable) {
        super(RegexpSplitToTable.REGEXP_SPLIT_TO_TABLE);

        setRegexpSplitToTable(regexpSplitToTable);
        resetChangedOnNotNull();
    }
}

/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables.records;


import org.example.table_generated.pg_catalog.tables.JsonbEachText;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JsonbEachTextRecord extends TableRecordImpl<JsonbEachTextRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>pg_catalog.jsonb_each_text.key</code>.
     */
    public void setKey(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>pg_catalog.jsonb_each_text.key</code>.
     */
    public String getKey() {
        return (String) get(0);
    }

    /**
     * Setter for <code>pg_catalog.jsonb_each_text.value</code>.
     */
    public void setValue(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pg_catalog.jsonb_each_text.value</code>.
     */
    public String getValue() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JsonbEachTextRecord
     */
    public JsonbEachTextRecord() {
        super(JsonbEachText.JSONB_EACH_TEXT);
    }

    /**
     * Create a detached, initialised JsonbEachTextRecord
     */
    public JsonbEachTextRecord(String key, String value) {
        super(JsonbEachText.JSONB_EACH_TEXT);

        setKey(key);
        setValue(value);
        resetChangedOnNotNull();
    }
}

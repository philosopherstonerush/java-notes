/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables.records;


import org.example.table_generated.pg_catalog.tables.TsStat;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TsStatRecord extends TableRecordImpl<TsStatRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>pg_catalog.ts_stat.word</code>.
     */
    public void setWord(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>pg_catalog.ts_stat.word</code>.
     */
    public String getWord() {
        return (String) get(0);
    }

    /**
     * Setter for <code>pg_catalog.ts_stat.ndoc</code>.
     */
    public void setNdoc(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>pg_catalog.ts_stat.ndoc</code>.
     */
    public Integer getNdoc() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>pg_catalog.ts_stat.nentry</code>.
     */
    public void setNentry(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>pg_catalog.ts_stat.nentry</code>.
     */
    public Integer getNentry() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TsStatRecord
     */
    public TsStatRecord() {
        super(TsStat.TS_STAT);
    }

    /**
     * Create a detached, initialised TsStatRecord
     */
    public TsStatRecord(String word, Integer ndoc, Integer nentry) {
        super(TsStat.TS_STAT);

        setWord(word);
        setNdoc(ndoc);
        setNentry(nentry);
        resetChangedOnNotNull();
    }
}
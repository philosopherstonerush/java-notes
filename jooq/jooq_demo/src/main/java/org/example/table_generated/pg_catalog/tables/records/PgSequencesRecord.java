/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables.records;


import org.example.table_generated.pg_catalog.tables.PgSequences;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PgSequencesRecord extends TableRecordImpl<PgSequencesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>pg_catalog.pg_sequences.schemaname</code>.
     */
    public void setSchemaname(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.schemaname</code>.
     */
    public String getSchemaname() {
        return (String) get(0);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.sequencename</code>.
     */
    public void setSequencename(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.sequencename</code>.
     */
    public String getSequencename() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.sequenceowner</code>.
     */
    public void setSequenceowner(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.sequenceowner</code>.
     */
    public String getSequenceowner() {
        return (String) get(2);
    }

    /**
     * @deprecated Unknown data type. If this is a qualified, user-defined type,
     * it may have been excluded from code generation. If this is a built-in
     * type, you can define an explicit {@link org.jooq.Binding} to specify how
     * this type should be handled. Deprecation can be turned off using
     * {@literal <deprecationOnUnknownTypes/>} in your code generator
     * configuration.
     */
    @Deprecated
    public void setDataType(Object value) {
        set(3, value);
    }

    /**
     * @deprecated Unknown data type. If this is a qualified, user-defined type,
     * it may have been excluded from code generation. If this is a built-in
     * type, you can define an explicit {@link org.jooq.Binding} to specify how
     * this type should be handled. Deprecation can be turned off using
     * {@literal <deprecationOnUnknownTypes/>} in your code generator
     * configuration.
     */
    @Deprecated
    public Object getDataType() {
        return get(3);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.start_value</code>.
     */
    public void setStartValue(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.start_value</code>.
     */
    public Long getStartValue() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.min_value</code>.
     */
    public void setMinValue(Long value) {
        set(5, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.min_value</code>.
     */
    public Long getMinValue() {
        return (Long) get(5);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.max_value</code>.
     */
    public void setMaxValue(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.max_value</code>.
     */
    public Long getMaxValue() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.increment_by</code>.
     */
    public void setIncrementBy(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.increment_by</code>.
     */
    public Long getIncrementBy() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.cycle</code>.
     */
    public void setCycle(Boolean value) {
        set(8, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.cycle</code>.
     */
    public Boolean getCycle() {
        return (Boolean) get(8);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.cache_size</code>.
     */
    public void setCacheSize(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.cache_size</code>.
     */
    public Long getCacheSize() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>pg_catalog.pg_sequences.last_value</code>.
     */
    public void setLastValue(Long value) {
        set(10, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_sequences.last_value</code>.
     */
    public Long getLastValue() {
        return (Long) get(10);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PgSequencesRecord
     */
    public PgSequencesRecord() {
        super(PgSequences.PG_SEQUENCES);
    }

    /**
     * Create a detached, initialised PgSequencesRecord
     */
    public PgSequencesRecord(String schemaname, String sequencename, String sequenceowner, Object dataType, Long startValue, Long minValue, Long maxValue, Long incrementBy, Boolean cycle, Long cacheSize, Long lastValue) {
        super(PgSequences.PG_SEQUENCES);

        setSchemaname(schemaname);
        setSequencename(sequencename);
        setSequenceowner(sequenceowner);
        setDataType(dataType);
        setStartValue(startValue);
        setMinValue(minValue);
        setMaxValue(maxValue);
        setIncrementBy(incrementBy);
        setCycle(cycle);
        setCacheSize(cacheSize);
        setLastValue(lastValue);
        resetChangedOnNotNull();
    }
}
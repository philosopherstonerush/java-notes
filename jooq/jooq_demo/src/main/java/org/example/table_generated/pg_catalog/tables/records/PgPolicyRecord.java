/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables.records;


import org.example.table_generated.pg_catalog.tables.PgPolicy;
import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PgPolicyRecord extends UpdatableRecordImpl<PgPolicyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>pg_catalog.pg_policy.oid</code>.
     */
    public void setOid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_policy.oid</code>.
     */
    public Long getOid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>pg_catalog.pg_policy.polname</code>.
     */
    public void setPolname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_policy.polname</code>.
     */
    public String getPolname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>pg_catalog.pg_policy.polrelid</code>.
     */
    public void setPolrelid(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_policy.polrelid</code>.
     */
    public Long getPolrelid() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>pg_catalog.pg_policy.polcmd</code>.
     */
    public void setPolcmd(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_policy.polcmd</code>.
     */
    public String getPolcmd() {
        return (String) get(3);
    }

    /**
     * Setter for <code>pg_catalog.pg_policy.polpermissive</code>.
     */
    public void setPolpermissive(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_policy.polpermissive</code>.
     */
    public Boolean getPolpermissive() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>pg_catalog.pg_policy.polroles</code>.
     */
    public void setPolroles(Long[] value) {
        set(5, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_policy.polroles</code>.
     */
    public Long[] getPolroles() {
        return (Long[]) get(5);
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
    public void setPolqual(Object value) {
        set(6, value);
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
    public Object getPolqual() {
        return get(6);
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
    public void setPolwithcheck(Object value) {
        set(7, value);
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
    public Object getPolwithcheck() {
        return get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PgPolicyRecord
     */
    public PgPolicyRecord() {
        super(PgPolicy.PG_POLICY);
    }

    /**
     * Create a detached, initialised PgPolicyRecord
     */
    public PgPolicyRecord(Long oid, String polname, Long polrelid, String polcmd, Boolean polpermissive, Long[] polroles, Object polqual, Object polwithcheck) {
        super(PgPolicy.PG_POLICY);

        setOid(oid);
        setPolname(polname);
        setPolrelid(polrelid);
        setPolcmd(polcmd);
        setPolpermissive(polpermissive);
        setPolroles(polroles);
        setPolqual(polqual);
        setPolwithcheck(polwithcheck);
        resetChangedOnNotNull();
    }
}
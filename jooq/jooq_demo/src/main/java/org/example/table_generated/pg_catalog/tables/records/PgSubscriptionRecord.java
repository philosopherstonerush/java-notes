/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables.records;


import org.example.table_generated.pg_catalog.tables.PgSubscription;
import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PgSubscriptionRecord extends UpdatableRecordImpl<PgSubscriptionRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>pg_catalog.pg_subscription.oid</code>.
     */
    public void setOid(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.oid</code>.
     */
    public Long getOid() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subdbid</code>.
     */
    public void setSubdbid(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subdbid</code>.
     */
    public Long getSubdbid() {
        return (Long) get(1);
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
    public void setSubskiplsn(Object value) {
        set(2, value);
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
    public Object getSubskiplsn() {
        return get(2);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subname</code>.
     */
    public void setSubname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subname</code>.
     */
    public String getSubname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subowner</code>.
     */
    public void setSubowner(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subowner</code>.
     */
    public Long getSubowner() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subenabled</code>.
     */
    public void setSubenabled(Boolean value) {
        set(5, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subenabled</code>.
     */
    public Boolean getSubenabled() {
        return (Boolean) get(5);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subbinary</code>.
     */
    public void setSubbinary(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subbinary</code>.
     */
    public Boolean getSubbinary() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.substream</code>.
     */
    public void setSubstream(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.substream</code>.
     */
    public String getSubstream() {
        return (String) get(7);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subtwophasestate</code>.
     */
    public void setSubtwophasestate(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subtwophasestate</code>.
     */
    public String getSubtwophasestate() {
        return (String) get(8);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subdisableonerr</code>.
     */
    public void setSubdisableonerr(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subdisableonerr</code>.
     */
    public Boolean getSubdisableonerr() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subpasswordrequired</code>.
     */
    public void setSubpasswordrequired(Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subpasswordrequired</code>.
     */
    public Boolean getSubpasswordrequired() {
        return (Boolean) get(10);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subrunasowner</code>.
     */
    public void setSubrunasowner(Boolean value) {
        set(11, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subrunasowner</code>.
     */
    public Boolean getSubrunasowner() {
        return (Boolean) get(11);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subconninfo</code>.
     */
    public void setSubconninfo(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subconninfo</code>.
     */
    public String getSubconninfo() {
        return (String) get(12);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subslotname</code>.
     */
    public void setSubslotname(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subslotname</code>.
     */
    public String getSubslotname() {
        return (String) get(13);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subsynccommit</code>.
     */
    public void setSubsynccommit(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subsynccommit</code>.
     */
    public String getSubsynccommit() {
        return (String) get(14);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.subpublications</code>.
     */
    public void setSubpublications(String[] value) {
        set(15, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.subpublications</code>.
     */
    public String[] getSubpublications() {
        return (String[]) get(15);
    }

    /**
     * Setter for <code>pg_catalog.pg_subscription.suborigin</code>.
     */
    public void setSuborigin(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>pg_catalog.pg_subscription.suborigin</code>.
     */
    public String getSuborigin() {
        return (String) get(16);
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
     * Create a detached PgSubscriptionRecord
     */
    public PgSubscriptionRecord() {
        super(PgSubscription.PG_SUBSCRIPTION);
    }

    /**
     * Create a detached, initialised PgSubscriptionRecord
     */
    public PgSubscriptionRecord(Long oid, Long subdbid, Object subskiplsn, String subname, Long subowner, Boolean subenabled, Boolean subbinary, String substream, String subtwophasestate, Boolean subdisableonerr, Boolean subpasswordrequired, Boolean subrunasowner, String subconninfo, String subslotname, String subsynccommit, String[] subpublications, String suborigin) {
        super(PgSubscription.PG_SUBSCRIPTION);

        setOid(oid);
        setSubdbid(subdbid);
        setSubskiplsn(subskiplsn);
        setSubname(subname);
        setSubowner(subowner);
        setSubenabled(subenabled);
        setSubbinary(subbinary);
        setSubstream(substream);
        setSubtwophasestate(subtwophasestate);
        setSubdisableonerr(subdisableonerr);
        setSubpasswordrequired(subpasswordrequired);
        setSubrunasowner(subrunasowner);
        setSubconninfo(subconninfo);
        setSubslotname(subslotname);
        setSubsynccommit(subsynccommit);
        setSubpublications(subpublications);
        setSuborigin(suborigin);
        resetChangedOnNotNull();
    }
}
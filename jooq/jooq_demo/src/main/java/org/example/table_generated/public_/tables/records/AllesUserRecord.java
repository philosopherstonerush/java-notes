/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.public_.tables.records;


import org.example.table_generated.public_.tables.AllesUser;
import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AllesUserRecord extends UpdatableRecordImpl<AllesUserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.alles_user.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.alles_user.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.alles_user.password</code>.
     */
    public void setPassword(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.alles_user.password</code>.
     */
    public String getPassword() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.alles_user.role</code>.
     */
    public void setRole(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.alles_user.role</code>.
     */
    public String getRole() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.alles_user.username</code>.
     */
    public void setUsername(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.alles_user.username</code>.
     */
    public String getUsername() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AllesUserRecord
     */
    public AllesUserRecord() {
        super(AllesUser.ALLES_USER);
    }

    /**
     * Create a detached, initialised AllesUserRecord
     */
    public AllesUserRecord(Integer id, String password, String role, String username) {
        super(AllesUser.ALLES_USER);

        setId(id);
        setPassword(password);
        setRole(role);
        setUsername(username);
        resetChangedOnNotNull();
    }
}
/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.information_schema.tables.records;


import org.example.table_generated.information_schema.tables.ApplicableRoles;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ApplicableRolesRecord extends TableRecordImpl<ApplicableRolesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>information_schema.applicable_roles.grantee</code>.
     */
    public void setGrantee(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>information_schema.applicable_roles.grantee</code>.
     */
    public String getGrantee() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.applicable_roles.role_name</code>.
     */
    public void setRoleName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.applicable_roles.role_name</code>.
     */
    public String getRoleName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.applicable_roles.is_grantable</code>.
     */
    public void setIsGrantable(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.applicable_roles.is_grantable</code>.
     */
    public String getIsGrantable() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ApplicableRolesRecord
     */
    public ApplicableRolesRecord() {
        super(ApplicableRoles.APPLICABLE_ROLES);
    }

    /**
     * Create a detached, initialised ApplicableRolesRecord
     */
    public ApplicableRolesRecord(String grantee, String roleName, String isGrantable) {
        super(ApplicableRoles.APPLICABLE_ROLES);

        setGrantee(grantee);
        setRoleName(roleName);
        setIsGrantable(isGrantable);
        resetChangedOnNotNull();
    }
}
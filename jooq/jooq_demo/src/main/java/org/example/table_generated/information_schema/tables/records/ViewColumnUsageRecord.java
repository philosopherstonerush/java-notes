/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.information_schema.tables.records;


import org.example.table_generated.information_schema.tables.ViewColumnUsage;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ViewColumnUsageRecord extends TableRecordImpl<ViewColumnUsageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for
     * <code>information_schema.view_column_usage.view_catalog</code>.
     */
    public void setViewCatalog(String value) {
        set(0, value);
    }

    /**
     * Getter for
     * <code>information_schema.view_column_usage.view_catalog</code>.
     */
    public String getViewCatalog() {
        return (String) get(0);
    }

    /**
     * Setter for <code>information_schema.view_column_usage.view_schema</code>.
     */
    public void setViewSchema(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>information_schema.view_column_usage.view_schema</code>.
     */
    public String getViewSchema() {
        return (String) get(1);
    }

    /**
     * Setter for <code>information_schema.view_column_usage.view_name</code>.
     */
    public void setViewName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>information_schema.view_column_usage.view_name</code>.
     */
    public String getViewName() {
        return (String) get(2);
    }

    /**
     * Setter for
     * <code>information_schema.view_column_usage.table_catalog</code>.
     */
    public void setTableCatalog(String value) {
        set(3, value);
    }

    /**
     * Getter for
     * <code>information_schema.view_column_usage.table_catalog</code>.
     */
    public String getTableCatalog() {
        return (String) get(3);
    }

    /**
     * Setter for
     * <code>information_schema.view_column_usage.table_schema</code>.
     */
    public void setTableSchema(String value) {
        set(4, value);
    }

    /**
     * Getter for
     * <code>information_schema.view_column_usage.table_schema</code>.
     */
    public String getTableSchema() {
        return (String) get(4);
    }

    /**
     * Setter for <code>information_schema.view_column_usage.table_name</code>.
     */
    public void setTableName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>information_schema.view_column_usage.table_name</code>.
     */
    public String getTableName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>information_schema.view_column_usage.column_name</code>.
     */
    public void setColumnName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>information_schema.view_column_usage.column_name</code>.
     */
    public String getColumnName() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ViewColumnUsageRecord
     */
    public ViewColumnUsageRecord() {
        super(ViewColumnUsage.VIEW_COLUMN_USAGE);
    }

    /**
     * Create a detached, initialised ViewColumnUsageRecord
     */
    public ViewColumnUsageRecord(String viewCatalog, String viewSchema, String viewName, String tableCatalog, String tableSchema, String tableName, String columnName) {
        super(ViewColumnUsage.VIEW_COLUMN_USAGE);

        setViewCatalog(viewCatalog);
        setViewSchema(viewSchema);
        setViewName(viewName);
        setTableCatalog(tableCatalog);
        setTableSchema(tableSchema);
        setTableName(tableName);
        setColumnName(columnName);
        resetChangedOnNotNull();
    }
}
/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.information_schema.tables;


import java.util.Collection;

import org.example.table_generated.information_schema.Domains;
import org.example.table_generated.information_schema.InformationSchema;
import org.example.table_generated.information_schema.tables.records.ForeignDataWrappersRecord;
import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ForeignDataWrappers extends TableImpl<ForeignDataWrappersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of
     * <code>information_schema.foreign_data_wrappers</code>
     */
    public static final ForeignDataWrappers FOREIGN_DATA_WRAPPERS = new ForeignDataWrappers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ForeignDataWrappersRecord> getRecordType() {
        return ForeignDataWrappersRecord.class;
    }

    /**
     * The column
     * <code>information_schema.foreign_data_wrappers.foreign_data_wrapper_catalog</code>.
     */
    public final TableField<ForeignDataWrappersRecord, String> FOREIGN_DATA_WRAPPER_CATALOG = createField(DSL.name("foreign_data_wrapper_catalog"), Domains.SQL_IDENTIFIER.getDataType(), this, "");

    /**
     * The column
     * <code>information_schema.foreign_data_wrappers.foreign_data_wrapper_name</code>.
     */
    public final TableField<ForeignDataWrappersRecord, String> FOREIGN_DATA_WRAPPER_NAME = createField(DSL.name("foreign_data_wrapper_name"), Domains.SQL_IDENTIFIER.getDataType(), this, "");

    /**
     * The column
     * <code>information_schema.foreign_data_wrappers.authorization_identifier</code>.
     */
    public final TableField<ForeignDataWrappersRecord, String> AUTHORIZATION_IDENTIFIER = createField(DSL.name("authorization_identifier"), Domains.SQL_IDENTIFIER.getDataType(), this, "");

    /**
     * The column
     * <code>information_schema.foreign_data_wrappers.library_name</code>.
     */
    public final TableField<ForeignDataWrappersRecord, String> LIBRARY_NAME = createField(DSL.name("library_name"), Domains.CHARACTER_DATA.getDataType(), this, "");

    /**
     * The column
     * <code>information_schema.foreign_data_wrappers.foreign_data_wrapper_language</code>.
     */
    public final TableField<ForeignDataWrappersRecord, String> FOREIGN_DATA_WRAPPER_LANGUAGE = createField(DSL.name("foreign_data_wrapper_language"), Domains.CHARACTER_DATA.getDataType(), this, "");

    private ForeignDataWrappers(Name alias, Table<ForeignDataWrappersRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private ForeignDataWrappers(Name alias, Table<ForeignDataWrappersRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("""
        create view "foreign_data_wrappers" as  SELECT foreign_data_wrapper_catalog,
         foreign_data_wrapper_name,
         authorization_identifier,
         (NULL::character varying)::information_schema.character_data AS library_name,
         foreign_data_wrapper_language
        FROM information_schema._pg_foreign_data_wrappers w;
        """), where);
    }

    /**
     * Create an aliased <code>information_schema.foreign_data_wrappers</code>
     * table reference
     */
    public ForeignDataWrappers(String alias) {
        this(DSL.name(alias), FOREIGN_DATA_WRAPPERS);
    }

    /**
     * Create an aliased <code>information_schema.foreign_data_wrappers</code>
     * table reference
     */
    public ForeignDataWrappers(Name alias) {
        this(alias, FOREIGN_DATA_WRAPPERS);
    }

    /**
     * Create a <code>information_schema.foreign_data_wrappers</code> table
     * reference
     */
    public ForeignDataWrappers() {
        this(DSL.name("foreign_data_wrappers"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : InformationSchema.INFORMATION_SCHEMA;
    }

    @Override
    public ForeignDataWrappers as(String alias) {
        return new ForeignDataWrappers(DSL.name(alias), this);
    }

    @Override
    public ForeignDataWrappers as(Name alias) {
        return new ForeignDataWrappers(alias, this);
    }

    @Override
    public ForeignDataWrappers as(Table<?> alias) {
        return new ForeignDataWrappers(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public ForeignDataWrappers rename(String name) {
        return new ForeignDataWrappers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ForeignDataWrappers rename(Name name) {
        return new ForeignDataWrappers(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public ForeignDataWrappers rename(Table<?> name) {
        return new ForeignDataWrappers(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ForeignDataWrappers where(Condition condition) {
        return new ForeignDataWrappers(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ForeignDataWrappers where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ForeignDataWrappers where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ForeignDataWrappers where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ForeignDataWrappers where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ForeignDataWrappers where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ForeignDataWrappers where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public ForeignDataWrappers where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ForeignDataWrappers whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public ForeignDataWrappers whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
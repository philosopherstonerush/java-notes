/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables;


import java.util.Collection;

import org.example.table_generated.pg_catalog.PgCatalog;
import org.example.table_generated.pg_catalog.tables.records.PgTablesRecord;
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
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PgTables extends TableImpl<PgTablesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>pg_catalog.pg_tables</code>
     */
    public static final PgTables PG_TABLES = new PgTables();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PgTablesRecord> getRecordType() {
        return PgTablesRecord.class;
    }

    /**
     * The column <code>pg_catalog.pg_tables.schemaname</code>.
     */
    public final TableField<PgTablesRecord, String> SCHEMANAME = createField(DSL.name("schemaname"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pg_catalog.pg_tables.tablename</code>.
     */
    public final TableField<PgTablesRecord, String> TABLENAME = createField(DSL.name("tablename"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pg_catalog.pg_tables.tableowner</code>.
     */
    public final TableField<PgTablesRecord, String> TABLEOWNER = createField(DSL.name("tableowner"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pg_catalog.pg_tables.tablespace</code>.
     */
    public final TableField<PgTablesRecord, String> TABLESPACE = createField(DSL.name("tablespace"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pg_catalog.pg_tables.hasindexes</code>.
     */
    public final TableField<PgTablesRecord, Boolean> HASINDEXES = createField(DSL.name("hasindexes"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>pg_catalog.pg_tables.hasrules</code>.
     */
    public final TableField<PgTablesRecord, Boolean> HASRULES = createField(DSL.name("hasrules"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>pg_catalog.pg_tables.hastriggers</code>.
     */
    public final TableField<PgTablesRecord, Boolean> HASTRIGGERS = createField(DSL.name("hastriggers"), SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>pg_catalog.pg_tables.rowsecurity</code>.
     */
    public final TableField<PgTablesRecord, Boolean> ROWSECURITY = createField(DSL.name("rowsecurity"), SQLDataType.BOOLEAN, this, "");

    private PgTables(Name alias, Table<PgTablesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PgTables(Name alias, Table<PgTablesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("""
        create view "pg_tables" as  SELECT n.nspname AS schemaname,
          c.relname AS tablename,
          pg_get_userbyid(c.relowner) AS tableowner,
          t.spcname AS tablespace,
          c.relhasindex AS hasindexes,
          c.relhasrules AS hasrules,
          c.relhastriggers AS hastriggers,
          c.relrowsecurity AS rowsecurity
         FROM ((pg_class c
           LEFT JOIN pg_namespace n ON ((n.oid = c.relnamespace)))
           LEFT JOIN pg_tablespace t ON ((t.oid = c.reltablespace)))
        WHERE (c.relkind = ANY (ARRAY['r'::"char", 'p'::"char"]));
        """), where);
    }

    /**
     * Create an aliased <code>pg_catalog.pg_tables</code> table reference
     */
    public PgTables(String alias) {
        this(DSL.name(alias), PG_TABLES);
    }

    /**
     * Create an aliased <code>pg_catalog.pg_tables</code> table reference
     */
    public PgTables(Name alias) {
        this(alias, PG_TABLES);
    }

    /**
     * Create a <code>pg_catalog.pg_tables</code> table reference
     */
    public PgTables() {
        this(DSL.name("pg_tables"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : PgCatalog.PG_CATALOG;
    }

    @Override
    public PgTables as(String alias) {
        return new PgTables(DSL.name(alias), this);
    }

    @Override
    public PgTables as(Name alias) {
        return new PgTables(alias, this);
    }

    @Override
    public PgTables as(Table<?> alias) {
        return new PgTables(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PgTables rename(String name) {
        return new PgTables(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PgTables rename(Name name) {
        return new PgTables(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PgTables rename(Table<?> name) {
        return new PgTables(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgTables where(Condition condition) {
        return new PgTables(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgTables where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgTables where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgTables where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgTables where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgTables where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgTables where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgTables where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgTables whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgTables whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
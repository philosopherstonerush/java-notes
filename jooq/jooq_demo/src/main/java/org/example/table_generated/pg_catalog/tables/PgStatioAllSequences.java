/*
 * This file is generated by jOOQ.
 */
package org.example.table_generated.pg_catalog.tables;


import java.util.Collection;

import org.example.table_generated.pg_catalog.PgCatalog;
import org.example.table_generated.pg_catalog.tables.records.PgStatioAllSequencesRecord;
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
public class PgStatioAllSequences extends TableImpl<PgStatioAllSequencesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>pg_catalog.pg_statio_all_sequences</code>
     */
    public static final PgStatioAllSequences PG_STATIO_ALL_SEQUENCES = new PgStatioAllSequences();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PgStatioAllSequencesRecord> getRecordType() {
        return PgStatioAllSequencesRecord.class;
    }

    /**
     * The column <code>pg_catalog.pg_statio_all_sequences.relid</code>.
     */
    public final TableField<PgStatioAllSequencesRecord, Long> RELID = createField(DSL.name("relid"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>pg_catalog.pg_statio_all_sequences.schemaname</code>.
     */
    public final TableField<PgStatioAllSequencesRecord, String> SCHEMANAME = createField(DSL.name("schemaname"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pg_catalog.pg_statio_all_sequences.relname</code>.
     */
    public final TableField<PgStatioAllSequencesRecord, String> RELNAME = createField(DSL.name("relname"), SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>pg_catalog.pg_statio_all_sequences.blks_read</code>.
     */
    public final TableField<PgStatioAllSequencesRecord, Long> BLKS_READ = createField(DSL.name("blks_read"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>pg_catalog.pg_statio_all_sequences.blks_hit</code>.
     */
    public final TableField<PgStatioAllSequencesRecord, Long> BLKS_HIT = createField(DSL.name("blks_hit"), SQLDataType.BIGINT, this, "");

    private PgStatioAllSequences(Name alias, Table<PgStatioAllSequencesRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private PgStatioAllSequences(Name alias, Table<PgStatioAllSequencesRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("""
        create view "pg_statio_all_sequences" as  SELECT c.oid AS relid,
          n.nspname AS schemaname,
          c.relname,
          (pg_stat_get_blocks_fetched(c.oid) - pg_stat_get_blocks_hit(c.oid)) AS blks_read,
          pg_stat_get_blocks_hit(c.oid) AS blks_hit
         FROM (pg_class c
           LEFT JOIN pg_namespace n ON ((n.oid = c.relnamespace)))
        WHERE (c.relkind = 'S'::"char");
        """), where);
    }

    /**
     * Create an aliased <code>pg_catalog.pg_statio_all_sequences</code> table
     * reference
     */
    public PgStatioAllSequences(String alias) {
        this(DSL.name(alias), PG_STATIO_ALL_SEQUENCES);
    }

    /**
     * Create an aliased <code>pg_catalog.pg_statio_all_sequences</code> table
     * reference
     */
    public PgStatioAllSequences(Name alias) {
        this(alias, PG_STATIO_ALL_SEQUENCES);
    }

    /**
     * Create a <code>pg_catalog.pg_statio_all_sequences</code> table reference
     */
    public PgStatioAllSequences() {
        this(DSL.name("pg_statio_all_sequences"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : PgCatalog.PG_CATALOG;
    }

    @Override
    public PgStatioAllSequences as(String alias) {
        return new PgStatioAllSequences(DSL.name(alias), this);
    }

    @Override
    public PgStatioAllSequences as(Name alias) {
        return new PgStatioAllSequences(alias, this);
    }

    @Override
    public PgStatioAllSequences as(Table<?> alias) {
        return new PgStatioAllSequences(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public PgStatioAllSequences rename(String name) {
        return new PgStatioAllSequences(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PgStatioAllSequences rename(Name name) {
        return new PgStatioAllSequences(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public PgStatioAllSequences rename(Table<?> name) {
        return new PgStatioAllSequences(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatioAllSequences where(Condition condition) {
        return new PgStatioAllSequences(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatioAllSequences where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatioAllSequences where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatioAllSequences where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatioAllSequences where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatioAllSequences where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatioAllSequences where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public PgStatioAllSequences where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatioAllSequences whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public PgStatioAllSequences whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
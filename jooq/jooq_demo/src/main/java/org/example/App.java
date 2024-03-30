package org.example;

import org.example.table_generated.public_.tables.Email;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;


import org.jooq.impl.DSL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;

import static org.example.table_generated.public_.tables.Email.EMAIL;
public class App
{
    public static void main( String[] args ) {
        String userName = "postgres";
        String password = "test";
        String url = "jdbc:postgresql://localhost:5432/alles";

        try(Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext d = DSL.using(conn, SQLDialect.POSTGRES);
            Result<Record> result = d.select().from(EMAIL).fetch();
            for (Record r : result) {
                String[] emails = r.getValue(EMAIL.EMAILS);
                System.out.println(Arrays.toString(emails));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

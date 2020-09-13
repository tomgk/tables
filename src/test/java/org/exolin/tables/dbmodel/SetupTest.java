package org.exolin.tables.dbmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * Tests für {@link Setup}
 * 
 * @author tomgk
 */
public class SetupTest
{
    @Test
    public void test() throws SQLException
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:"))
        {
            System.out.println("Connection to SQLite has been established.");
            
            Database database = new Database();
            
            Table addressTable = database.addTable("address", "id");
            addressTable.addColumn("street", Type.VARCHAR(255));
            addressTable.addColumn("town", Type.VARCHAR(255));
            addressTable.addColumn("postalCode", Type.VARCHAR(30));
            
            Table personTable = database.addTable("person", "id");
            personTable.addColumn("first_name", Type.VARCHAR(255));
            personTable.addColumn("last_name", Type.VARCHAR(255));
            personTable.addColumn("main_address_id", Type.INTEGER(), Optional.of(addressTable));
            
            Setup setup = new Setup(conn);
            setup.setup(database);
        }
    }
    
    public static void main(String[] args) throws SQLException
    {
        new SetupTest().test();
    }
}

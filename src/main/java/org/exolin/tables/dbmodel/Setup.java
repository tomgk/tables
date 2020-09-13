package org.exolin.tables.dbmodel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tomgk
 */
public class Setup
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Setup.class);
    
    private final Connection connection;

    public Setup(Connection connection)
    {
        this.connection = Objects.requireNonNull(connection);
    }
    
    public void setup(Database database) throws SQLException
    {
        for(Table t: database.getTables())
        {
            createTable(t);
        }
        
        for(Table t: database.getTables())
        {
            createFKs(t);
        }
    }

    private void createTable(Table t) throws SQLException
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("CREATE TABLE ").append(t.getName()).append("(");
        
        sb.append(t.getIdColumn().getName()).append(" INTEGER PRIMARY KEY");
        
        for(Column c: t.getDataColumns())
        {
            sb.append(", ");
            
            sb.append(c.getName()).append(" ");
            writeType(c.getType(), sb);
        }
        
        sb.append(")");
        
        executeSQL(sb.toString());
    }
    
    private void executeSQL(String sql) throws SQLException
    {
        try(Statement stmt = connection.createStatement())
        {
            LOGGER.info(sql);
            stmt.execute(sql);
        }
    }

    private void writeType(Type type, StringBuilder sb)
    {
        if(type instanceof TypeAlias)
            writeType(((TypeAlias)type).getActualType(), sb);
        else if(type instanceof Type.Varchar)
            sb.append("VARCHAR(").append(((Type.Varchar)type).getLen()).append(")");
        else if(type instanceof Type.Integer)
            sb.append("INTEGER");
        else
            throw new UnsupportedOperationException(type.getClass().getName());
    }

    private void createFKs(Table t) throws SQLException
    {
        //TODO: SQLite doesn't support adding FKs with ALTER TABLE
        if(false)
            return;
        
        for(Column c: t.getColumns())
        {
            if(!c.getReferencedTable().isPresent())
                continue;
            
            StringBuilder sb = new StringBuilder();
            
            Table table = c.getReferencedTable().get();
            
            sb.append("ALTER TABLE ").append(t.getName());
            sb.append(" ADD (CONSTRAINT fk_").append(t.getName()).append("_").append(c.getName());
            sb.append(" FOREIGN KEY(").append(c.getName()).append(")");
            sb.append(" REFERENCES ").append(table.getName()).append("(").append(table.getIdColumn().getName()).append("))");
            
            executeSQL(sb.toString());
        }
    }
}

package org.exolin.tables.dbmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
  * A relational database
  */
public class Database
{
    private final List<Table> tables = new ArrayList<>();

    public List<Table> getTables()
    {
        return tables;
    }
    
    public Table addTable(String tableName, String idColumnName)
    {
        Table table = new Table(tableName, new Column(idColumnName, Type.INTEGER(), Optional.empty()));
        tables.add(table);
        return table;
    }
    
    /**
      * Returns a list of all columns of tables in this databae that have an foreign key on the given table
      */
    public List<Column> getAllReferencingColumnsFor(Table table)
    {
        throw new UnsupportedOperationException("TODO");
    }
}

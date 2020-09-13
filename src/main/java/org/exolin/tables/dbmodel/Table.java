package org.exolin.tables.dbmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
  * A relational table
  */
public class Table
{
    /**
      * the name of the table
      */
    private String name;

    /**
      * the column that is the primary key (composite primary keys aren't supported).
      * This column isn't contained in {@link #dataColumns}
      */
    private Column idColumn;

    private final List<Column> dataColumns = new ArrayList<>();

    public Table(String name, Column idColumn)
    {
        this.name = name;
        this.idColumn = idColumn;
    }
    
    public void addColumn(String name, Type type)
    {
        addColumn(name, type, Optional.empty());
    }
    
    public void addColumn(String name, Type type, Optional<Table> referencedTable)
    {
        dataColumns.add(new Column(name, type, referencedTable));
    }
    
    public String getName()
    {
        return name;
    }

    public Column getIdColumn()
    {
        return idColumn;
    }

    public List<Column> getDataColumns()
    {
        return dataColumns;
    }
    
    public List<Column> getColumns()
    {
        List<Column> columns = new ArrayList<>(1+dataColumns.size());
        columns.add(idColumn);
        columns.addAll(dataColumns);
        return columns;
    }
}

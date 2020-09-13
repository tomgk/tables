package org.exolin.tables.dbmodel;

import java.util.Objects;
import java.util.Optional;

/**
 * A column in a {@link Table table}
 */
public class Column
{
    private String name;

    /**
      * the type of the column itself, also in case of a column referencing another table
      */
    private Type type;

    /**
      * The table that's being referenced by this column
      * It always rerences the primary key of the table
      */
    private Optional<Table> referencedTable;

    public Column(String name, Type type, Optional<Table> referencedTable)
    {
        this.name = Objects.requireNonNull(name, "name");
        this.type = Objects.requireNonNull(type, "type");
        this.referencedTable = Objects.requireNonNull(referencedTable, "referencedTable");
    }
    
    public String getName()
    {
        return name;
    }

    public Type getType()
    {
        return type;
    }

    public Optional<Table> getReferencedTable()
    {
        return referencedTable;
    }
}

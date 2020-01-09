package org.exolin.tables.dbmodel;

import java.util.Optional;

/**
 * A column in a {@link Table table}
 */
class Column
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
}

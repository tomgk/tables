package org.exolin.tables.dbmodel;

import java.util.ArrayList;
import java.util.List;

/**
  * A relational table
  */
class Table
{
  /**
    * the name of the table
    */
  private String name;
  
  /**
    * the column that is the primary key (composite primary keys aren't supported).
    * This column isn't contained in {@link #dataColumns}
    */
  private final Column idColumn;
  
  private final List<Column> dataColumns = new ArrayList<>();
  
  public List<Column> getColumns()
  {
    List<Column> columns = new ArrayList<>(1+dataColumns.size());
    columns.add(idColumn);
    columns.addAll(dataColumns);
    return columns;
  }
}

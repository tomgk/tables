/**
  * A relational database
  */
class Database
{
  private final List<Table> tables = new ArrayList<>();
  
  /**
    * Returns a list of all columns of tables in this databae that have an foreign key on the given table
    */
  public List<Column> getAllReferencingColumnsFor(Table table)
  {
    ...
  }
}

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

/**
  * Provides an abstraction to reuse the same type for multiple columns with the
  * possibilty to change all affected columns automatically
  */
class TypeAlias implements Type
{
  private final String name;
  private final Type actualType;
}

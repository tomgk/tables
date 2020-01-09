package org.exolin.tables.dbmodel;

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
    throw new UnsupportedOperationException("TODO");
  }
}

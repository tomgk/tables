package org.exolin.tables.dbmodel;

/**
  * Provides an abstraction to reuse the same type for multiple columns with the
  * possibilty to change all affected columns automatically
  */
class TypeAlias implements Type
{
  private final String name;
  private final Type actualType;
}

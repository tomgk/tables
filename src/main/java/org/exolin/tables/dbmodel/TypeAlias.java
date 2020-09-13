package org.exolin.tables.dbmodel;

import java.util.Objects;

/**
  * Provides an abstraction to reuse the same type for multiple columns with the
  * possibilty to change all affected columns automatically
  */
public class TypeAlias implements Type
{
    private String name;
    private Type actualType;

    public TypeAlias(String name, Type actualType)
    {
        this.name = Objects.requireNonNull(name, "name");
        this.actualType = Objects.requireNonNull(actualType, "actualType");
    }

    public String getName()
    {
        return name;
    }

    public Type getActualType()
    {
        return actualType;
    }
}

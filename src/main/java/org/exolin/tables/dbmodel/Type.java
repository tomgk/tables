package org.exolin.tables.dbmodel;

/**
  * A type (of a column)
  */
public interface Type
{
    public static class Varchar implements Type
    {
        private final int len;

        public Varchar(int len)
        {
            this.len = len;
        }

        public int getLen()
        {
            return len;
        }
    }
    
    public static class Integer implements Type{}
    
    public static Varchar VARCHAR(int len)
    {
        return new Varchar(len);
    }
    
    public static Integer INTEGER()
    {
        return new Integer();
    }
}

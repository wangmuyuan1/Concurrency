package com.mw.java8.c8.chain;

public abstract class OldProcessingObject<T>
{
    protected OldProcessingObject<T> successor;

    public void setSuccessor(OldProcessingObject<T> successor)
    {
        this.successor = successor;
    }

    public T handle(T input)
    {
        T r = handleWork(input);
        if (successor != null)
        {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}
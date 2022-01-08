package com.berec.algorithms;

public class Pair<T, G>
{
    private final T first;
    private final G second;

    public Pair(T first, G second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return first;
    }

    public G getSecond()
    {
        return second;
    }
}

package com.berec.algorithms;

import java.util.Arrays;

public class Paging
{
    private final int[] input;
    private final int cache_size;

    public Paging(int[] input, int cache_size)
    {
        this.input = input;
        this.cache_size = cache_size;
    }

    public int solveWith(PagingAlgorithm algorithm) {
        return algorithm.solve(input, cache_size);
    }

    @Override public String toString()
    {
        return "Paging{" +
                "input=" + Arrays.toString(input) +
                ", cache_size=" + cache_size +
                '}';
    }
}

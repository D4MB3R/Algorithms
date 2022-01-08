package com.berec.algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

public class PagingFIFO implements PagingAlgorithm
{
    private final Queue<Integer> cache = new ArrayDeque<>();
    private static int cost = 0;

    @Override
    public int solve(int[] input, int cache_size)
    {
        for (int i : input)
        {
            if (cache.size() < cache_size)
            {
                insertIntoCache(i);
            }
            else {
                if (insertIntoCache(i)){
                    cache.remove();
                }
            }
            //System.out.println(cache); - for debugging
        }
        return cost;
    }

    private boolean insertIntoCache(int element) {
        if (!cache.contains(element))  {
            cache.add(element);
            cost++;
            return true;
        }
        return false;
    }
}

package com.berec.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PagingLRU implements PagingAlgorithm
{

    private final Map<Integer, Integer> cache = new HashMap<>();
    private static Integer cost = 0;
    private static Integer timeStamp = 1;

    @Override
    public int solve(int[] input, int cache_size)
    {
        for (int i : input) {
            if (cache.size() < cache_size) {
                insertIntoCache(i);
            }
            else {
                if (!insertIntoCache(i)) {
                    Optional<Integer> oldestTimestamp = cache.values().stream()
                            .sorted()
                            .findFirst();
                    Optional<Map.Entry<Integer, Integer>> leastRecentlyUsed = cache.entrySet().stream()
                            .filter(e -> Objects.equals(e.getValue(), oldestTimestamp.get()))
                            .findFirst();
                    leastRecentlyUsed.ifPresent(lru -> cache.remove(lru.getKey()));
                }
            }
            //System.out.println(cache); - for debugging
        }
        return cost;
    }

    private boolean insertIntoCache(int element)
    {
        boolean alreadyInserted = true;
        if (!cache.containsKey(element))  {
            cost++;
            alreadyInserted = false;
        }
        cache.put(element, timeStamp++);
        return alreadyInserted;
    }
}

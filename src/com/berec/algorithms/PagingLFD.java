package com.berec.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PagingLFD implements PagingAlgorithm
{
    private final List<Integer> cache = new ArrayList<>();
    private static int cost = 0;

    @Override
    public int solve(int[] input, int cache_size)
    {
        for (int i = 0; i < input.length; i++) {
            if (cache.size() < cache_size) {
                insertIntoCache(input[i]);
            }
            else if (!cache.contains(input[i])){
                List<Pair<Integer, Integer>> nextOccurrencesOfCacheElements = new ArrayList<>();
                for (Integer element : cache) {
                    nextOccurrencesOfCacheElements.add(getNextPositionOf(element, input, i+1));
                }
                Optional<Integer> maxPosition = nextOccurrencesOfCacheElements.stream()
                        .map(Pair::getSecond).max(Comparator.naturalOrder());
                Optional<Pair<Integer, Integer>> latestForwardDistanceElement = nextOccurrencesOfCacheElements.stream()
                        .filter(e -> Objects.equals(e.getSecond(), maxPosition.get()))
                        .findFirst();
                latestForwardDistanceElement.ifPresent(lfd -> cache.remove(lfd.getFirst()));
                insertIntoCache(input[i]);
            }
        }
        return cost;
    }

    private void insertIntoCache(int element) {
        if (!cache.contains(element))  {
            cache.add(element);
            cost++;
        }
    }

    private Pair<Integer, Integer> getNextPositionOf(int element, int[] input, int startPos) {
        for (int j = startPos; j < input.length; j++) {
            if (input[j] == element) {
                return new Pair<>(element, j);
            }
        }
        return new Pair<>(element, Integer.MAX_VALUE);
    }
}

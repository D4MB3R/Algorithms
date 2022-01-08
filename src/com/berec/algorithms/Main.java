package com.berec.algorithms;

public class Main
{
    public static void main(String[] args) {
        int[] input = {15,8,48,8,8,484,9,93,4,8,1,8,1,8,81,8,18,1,83,4,4,6,19,73,1};
        int[] input2 = {1, 2, 3, 2, 4, 2, 4, 3, 5, 1, 2, 1, 5, 4, 3, 5};
        Paging pagingProblem = new Paging(input2, 3);

        System.out.println("The cost of running FIFO on this input is: " +
                pagingProblem.solveWith(new PagingFIFO()));

        System.out.println("The cost of running LRU on this input is: " +
                pagingProblem.solveWith(new PagingLRU()));

        System.out.println("The cost of running LFD on this input is: " +
                pagingProblem.solveWith(new PagingLFD()));
    }
}

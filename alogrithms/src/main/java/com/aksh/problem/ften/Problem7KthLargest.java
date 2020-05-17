package com.aksh.problem.ften;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author aksha
 *
 *         Design a class to find the kth largest element in a stream. Note that
 *         it is the kth largest elemetn in the sorted order not the kth
 *         distinct The class should have a constructor which accepts an integer
 *         k and an integer array which contains initial elements form the
 *         stream. For each call to the method KthLargest.add return Kth largest
 *         element.
 */
public class Problem7KthLargest {
	private int[] elements;
	private int k;
	LinkedList<Integer> sorted;
	
	
	public Problem7KthLargest(int[] elements, int k) {
		super();
		this.elements = elements;
		this.k = k;
		BiConsumer<LinkedList<Integer>, Integer> bif=(l,t)->{l.add(t);};
		BiConsumer<LinkedList<Integer>, LinkedList<Integer>> combiner=(l1,l2)->l1.addAll(l2);
		sorted=Arrays.stream(elements).boxed().sorted(Collections.reverseOrder()).collect(()->{return new LinkedList<Integer>();}, bif, combiner);
	}

	/**
	 * This will not work with add use case since one would have to sort all over again. 
	 * @return
	 */
	public List<Integer> kthLargestWithSort() {
		return Arrays.stream(elements).boxed().sorted(Collections.reverseOrder()).limit(k).collect(Collectors.toList());
	}
	
	public List<Integer> kthLargestWithSortUsingQueue(){
		return sorted.stream().limit(k).collect(Collectors.toList());
	}
	
	public Optional<Integer> add(int i) {
		ListIterator<Integer>it=sorted.listIterator();
		if(!it.hasNext()) {
			it.add(i);
		}else {
			while(it.hasNext()&&i<=it.next()) {
				System.out.println("Iterating");
			}
			it.previous();
			it.add(i);
		}
		
		return sorted.stream().skip(k-1).findFirst();
	}
	
	public static void main(String[] args) {
		Problem7KthLargest problem=new Problem7KthLargest(new int[] {}, 4);
		
		System.out.println(problem.add(45));
		System.out.println(problem.add(4));
		System.out.println(problem.add(5));
		System.out.println(problem.add(15));
		System.out.println(problem.kthLargestWithSortUsingQueue());
		System.out.println(problem.kthLargestWithSortUsingQueue());
		;
	}

}

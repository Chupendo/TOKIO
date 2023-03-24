package com.tokio.colas;

import java.util.LinkedList;
import java.util.Queue;
/*
 * Ejemplo de Cola con LinkedList
 * Extiende de Collection<E>, Iterable<E>
 * SubInterfaces: BlockingDeque<E>, BlockingQueue<E>, Deque<E>, TransferQueue<E>
 * Implementaciones: AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue, DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue, PriorityBlockingQueue, PriorityQueue, SynchronousQueue
 */
public class ColaExample {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		System.out.println("peek: "+queue.peek());
	}

}

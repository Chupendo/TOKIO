package com.tokio.colagen;


public class QueueGen<T> implements IQueue<T>{
	private T[] q; // Matriz con los elementos
	private int putloc,getloc; // Indices put y get

	public QueueGen(T[] ref) {
		q = ref;
		putloc = getloc = 0;
	}
	
	@Override
	public void put(T t) throws QueueFullException {
		if(putloc == q.length)
			throw new QueueFullException(q.length);
		System.err.println("ADD "+t);
		q[putloc] = t;
		putloc++;
	}

	@Override
	public T get() throws QueueEmpatyException {
		if(getloc == putloc )
			throw new QueueEmpatyException();
		getloc++;
		return q[getloc-1];
	}
}

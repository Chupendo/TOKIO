package com.tokio.genericos01;

public class Gen<T> {//Una clase generica

		private T obj;
		
		public Gen(T obj) {
			this.obj = obj;
		}
		
		public String showType() {
			return this.obj.getClass().toString();
		}
		
		public T getObj() {
			return this.obj;
		}
}

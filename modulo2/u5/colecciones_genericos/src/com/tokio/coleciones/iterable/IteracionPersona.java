package com.tokio.coleciones.iterable;

import java.util.Iterator;

public class IteracionPersona implements Iterable<Persona>{
		Persona persona[];
		public IteracionPersona(Persona[] persona) {
			this.persona = persona;
		}
		@Override
		public Iterator<Persona> iterator() {
			// TODO Auto-generated method stub
			return new Iterator<Persona>() {
				int i=0;
				@Override
				public boolean hasNext() {
					if(i>=persona.length)
						return false;
					else
						return true;
				}
				@Override
				public Persona next() {
					// TODO Auto-generated method stubç
					if(hasNext()) {
						i++;
						return persona[i-1];
					}else {
						if(i==persona.length) {
							return null;
						}else {
							return persona[i];
						}
					}
					
				}
			};
		}
}

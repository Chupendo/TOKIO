package com.tokio.p11.run;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import com.tokio.p11.dto.DataUtils;
import com.tokio.p11.dto.DataUtils.TIPO_VALID;
import com.tokio.p11.dto.Identificacion;
import com.tokio.p11.dto.Identificacion.TIPO;
import com.tokio.p11.dto.Persona;

public class P11_Main {

	public static void main(String[] args) {
		List<Persona> lPer = new ArrayList<>();

		lPer.add(new Persona("Andres", new Identificacion(TIPO.DNI, "28977854A"), "an dres.rpenuela@gmail.com",
				"+3468985569"));
		lPer.add(new Persona("Juan", new Identificacion(TIPO.DNI, "28973554aA"), "juanan@hotmail.org", "+34 987585532"));
		lPer.add(new Persona("Ana", new Identificacion(TIPO.NIE, "E28977134"), "ana-miss93@ter@ra.es", "+34624652236"));
		lPer.add(new Persona("Laura", new Identificacion(TIPO.NIE, "B24977854"), "laura1992@gmail.c", "+3468985561"));
		lPer.add(new Persona("María", new Identificacion(TIPO.DNI, "22345683V"), "ma2@ira@gmail.com", "+34999552546"));

		/**
		 * VALIDNADO DOCUMENTO DE IDENTIFICACION
		 */
		System.out.println("Personas con el documento de identificacion valido");
		lPer.stream().filter(p -> {
			try {
				return DataUtils.validadorGenerico.validar(p.getDocIdentificacion().getTipo().toString(),
						p.getDocIdentificacion().getNumIdentificacion());
			} catch (IllegalArgumentException e) {
				System.err.println(e.getCause().getMessage());
				return false;
			}
		}).forEach(p -> {
			System.out.println("\t " + p.toString());
		});

		System.out.println("Personas con el documento de identificacion NO valido");
		lPer.stream().filter(p -> {
			try {
				return !DataUtils.validadorGenerico.validar(p.getDocIdentificacion().getTipo().toString(),
						p.getDocIdentificacion().getNumIdentificacion());
			} catch (IllegalArgumentException e) {
				System.err.println(e.getCause().getMessage());
				return false;
			}
		}).forEach(p -> {
			System.out.println("\t " + p.toString());
		});

		/**
		 * VALIDNADO DOCUMENTO DE EMAIL
		 */

		System.out.println("Personas con el email valido");
		lPer.stream().filter(p -> {
			try {
				try {
					return DataUtils.validadorGenerico.validar(TIPO_VALID.EMAIL.toString(), p.getEmail());
				} catch (IllegalArgumentException e) {
					System.err.println(e.getCause().getMessage());
					return false;
				}
			} catch (IllegalArgumentException e) {
				System.err.println(e.getCause().getMessage());
				return false;
			}
		}).forEach(p -> {
			System.out.println("\t " + p.toString());
		});
		
		System.out.println("Personas con el email NO valido");
		lPer.stream().filter(p -> {
			try {
				return !DataUtils.validadorGenerico.validar(TIPO_VALID.EMAIL.toString(), p.getEmail());
			} catch (IllegalArgumentException e) {
				System.err.println(e.getCause().getMessage());
				return false;
			}
		}).forEach(p -> {
			System.out.println("\t " + p.toString());
		});

		/**
		 * VALIDNADO DOCUMENTO DE TELEFONO
		 */

		System.out.println("Personas con el telefono valido");
		lPer.stream().filter(p -> {
			try {
				return DataUtils.validadorGenerico.validar(TIPO_VALID.PHONE.toString(), p.getTelefono());
			} catch (IllegalArgumentException e) {
				System.err.println(e.getCause().getMessage());
				return false;
			}
		}).forEach(p -> {
			System.out.println("\t " + p.toString());
		});

		System.out.println("Personas con el telefono NO valido");
		lPer.stream().filter(p -> {
			try {
				return !DataUtils.validadorGenerico.validar(TIPO_VALID.PHONE.toString(), p.getTelefono());
			} catch (IllegalArgumentException e) {
				System.err.println(e.getCause().getMessage());
				return false;
			}
		}).forEach(p -> {
			System.out.println("\t " + p.toString());
		});
	}

}

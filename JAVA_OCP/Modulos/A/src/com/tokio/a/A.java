package com.tokio.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.tokio.b.User;
import com.tokio.b.UserService;
import com.tokio.c.C;

public class A {
	public static void main(String[] args) {
			List<User> lUser = new ArrayList<>();
			
			lUser.add(new User(0, "Ramon"));
			lUser.add(new User(1, "Andres"));
			lUser.add(new User(2, "Zarya"));
			lUser.add(new User(3, "Barbara"));
			
			
			System.out.println("Lista de usuarios ordenado or inserccion");
			lUser.forEach(System.out::println);
			
			
			System.out.println("Lista de usuarios ordenado");
			UserService.orderNameNatural(lUser);
			lUser.forEach(System.out::println);
			
			// No neceista de 
			// "requiers C" en la definición del modula A
			// o bien "requiers transitive C" en la definición del modulo B
			System.out.println("Lista de usuarios Invertido");
			List<String> lNames1 = UserService.orderNameInv(lUser);
			lNames1.forEach(System.out::println);
			
			// Neceista:
			// "requiers C" en la definición del modula A
			// o bien "requiers transitive C" en la definición del modulo B
			// En ambos casos, se ha de espceficiar la en el modulepath el modulo C
			List<String> lNames2 = lUser.stream().map(User::getName).collect(Collectors.toList());
			System.out.println("Lista de nombres");
			lNames2.forEach(System.out::println);
			C com = new C();
			System.out.println("Lista de nombres orde invertido");
			Collections.sort(lNames2,com);
			lNames2.forEach(System.out::println);
	}
}

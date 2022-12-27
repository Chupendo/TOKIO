package com.tokio.b;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.tokio.c.C;

public class UserService {

	public static void orderNameNatural(List<User> lUser) {
		System.out.println("[UserService] orderNameNatural");
		Collections.sort(lUser);
	}

	public static List<String> orderNameInv(List<User> lUser) {
		System.out.println("[UserService] orderNameInv");
		List<String> lNames = lUser.stream().map(User::getName).collect(Collectors.toList());
		C com = new C();
		Collections.sort(lNames,com);
		return lNames;

	}
}

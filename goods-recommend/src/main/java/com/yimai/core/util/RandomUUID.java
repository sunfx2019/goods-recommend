package com.yimai.core.util;

import java.util.UUID;

public class RandomUUID {

	private RandomUUID() {

	}

	public synchronized static String randomUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public synchronized static String randomUUIDUp() {
		return randomUUID().toUpperCase();
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString().length());
		System.out.println(randomUUID().length());
		System.out.println(randomUUID());
		System.out.println(randomUUIDUp());
	}
}
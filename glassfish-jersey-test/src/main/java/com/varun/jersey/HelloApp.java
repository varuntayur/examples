package com.varun.jersey;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class HelloApp extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(Hello.class);

		System.err.println("**** Registered Hello.class ****");
		return s;
	}

}
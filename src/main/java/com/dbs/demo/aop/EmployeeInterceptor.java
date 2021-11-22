package com.dbs.demo.aop;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// https://medium.com/javarevisited/spring-core-including-aspect-oriented-programming-in-your-skills-2c37eaa75c2a

@Aspect
@Configuration
public class EmployeeInterceptor {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

//	@Before("com.dbs.demo.controller")
//	public void someMethod(JoinPoint jp) {
//
//		String methodName = jp.getSignature().toString();
//		String arguments = jp.getArgs().toString();
//
//		LOG.info(methodName + " " + arguments + " log for this method with these arguments was created");
//	}

	@Before("execution(* com.dbs.demo.controller.EmployeeController.*(..))")
	public void beforeEmployeeControllerMethods(JoinPoint joinPoint) {

		String methodName = joinPoint.getSignature().getName();

		String args = Arrays.asList(joinPoint.getArgs()).stream().map(object -> object.toString())
				.collect(Collectors.joining(","));

		LOG.info("Executing before method Name => " + methodName + " arguments =>" + args);
	}

}
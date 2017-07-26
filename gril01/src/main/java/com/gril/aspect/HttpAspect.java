package com.gril.aspect;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class HttpAspect {
	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	@Pointcut("execution(public * com.gril.controller.GrilCon.*(..))")
	public void qq(){
		
	}
	@Before("qq()")
	public void log(JoinPoint join){
		//ss
		//获得request对象 org.springframework.web.context.request.RequestContextHolder;
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		//获取访问地址
		logger.info("url={}",request.getRequestURL());
		//获取ip
		logger.info("ip={}",request.getRemoteAddr());
		//获取访问方法
		logger.info("method={}",request.getMethod());
		//获取类方法
		logger.info("class={}",join.getSignature().getDeclaringTypeName() + "." + join.getSignature().getName());
		//获取参数
		logger.info("args={}",join.getArgs());
	}
	@After("qq()")
	public void log1(){
		System.out.println("3333333333");
	}
	@AfterReturning(returning = "obj", pointcut = "qq()")
	public void doReturning(Object obj){
		logger.info("obj={}",obj);
	}
}

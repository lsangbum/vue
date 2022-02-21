package com.example.demo.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

;

public class ClientTest {
    public static void main(String[] args) {

        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("sayH*");

        pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new Advice()));

        Hello proxiedHello = (Hello) pfBean.getObject();

        System.out.println(proxiedHello.sayHello("sayHello"));
        System.out.println(proxiedHello.sayHi("Hi"));
        System.out.println(proxiedHello.sayBye("Bye"));
        System.out.println(proxiedHello.sayHello("sayHello"));
    }//main

    static class Advice implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            if (invocation.getMethod().getName().equals("sayHi")) {
                String plus2 = (String) invocation.proceed();
                return plus2 + " 2";
            }
            if (invocation.getMethod().getName().startsWith("sayHello")) {
                String plus5 = (String) invocation.proceed();
                return plus5 + " 5";
            }

            String others = (String) invocation.proceed();
            return others + " other methods";
        }
    }


}//class

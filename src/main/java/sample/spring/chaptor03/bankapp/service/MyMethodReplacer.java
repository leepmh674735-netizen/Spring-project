package sample.spring.chaptor03.bankapp.service;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyMethodReplacer implements MethodReplacer, ApplicationContextAware {
	private ApplicationContext applicationContext;
	
	@Override
	public object reimplemets(Object odj, Method, Object[] args)
	    return applicationContext.getBean((String) args[0]);
    }
	
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
         throws BeansException {
    	      this.applicationContext = applicationContext;
    	
}

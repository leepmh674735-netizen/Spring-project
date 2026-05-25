package sample.spring.chaptor06.bankapp.domain;

import javax.inject.Named;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Value;

@Named(value="customerRequestDetails")
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerRequestDetails {

}

@Lazy(value=true)
@Component
public class Sample {  }

@DependsOn(value = {"beanA","beanB"})
@Component
public class Sample { }

@Primary
@Component
public class Sample {  }

package sample.spring.chapter06.beans.factory.annotation.Value;

import org.springframework.beans.factory.annotation.Value;

@Component(value="sample")
public class sample {
	@Value("Some currency")
	private String currecy;
	
}
}
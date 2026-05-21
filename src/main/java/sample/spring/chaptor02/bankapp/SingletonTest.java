package sample.spring.chaptor02.bankapp;

import static org.junit.Assert.assertSame;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonTest {
	private static ApplicationContext context;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring/applicationContext.xml");
	}
	
	@Test
	public void testInstances() {
		FixedDepositController controller1 = (FixedDepositController) context.getBean("controller");
		
		FixedDepositDao fixedDepositDao1 = 
				controller1.getFixedDepositService().getFixedDepositDao();
		FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("dao");
		assertSame("Different FixedDepositDao instances", fixedDepositDao1, fixedDepositDao2);
		
		FixedDepositController controller2 = (FixedDepositController) context.getBean("controller");
		assertSame("Different FixedDepositController instances", controller1, controller2);
	}
}
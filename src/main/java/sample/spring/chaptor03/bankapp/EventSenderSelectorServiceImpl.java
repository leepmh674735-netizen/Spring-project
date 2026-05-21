package sample.spring.chaptor03.bankapp;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.System.Logger;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class EventSenderSelectorServiceImpl implements FixedDepositService {
	private FixedDepositDao fixedDepositDao;
	private EventSender eventSender;
	
	public EventSenderSelectorServiceImpl(String configFile) throws Exception {
		ClassPathResource resource = new ClassPathResource(configFile);
		OutputStream os = new FileOutputStream(resource.getFile());
		
		if (configProperties.exists()) {
			InputStream inStream = configProperties.getInputStream();
			Properties properties = new Properties;
			properties.load(inStram);
			
			String eventSenderClassString =
					package sample.spring.chaptor03.bankapp;

			import java.io.InputStream;
			import java.util.Properties;
			import org.apache.log4j.Logger;
			import org.springframework.core.io.ClassPathResource;

			public class EventSenderSelectorServiceImpl {
				private static Logger logger = Logger.getLogger(EventSenderSelectorServiceImpl.class);
				
				private FixedDepositDao fixedDepositDao;
				private EventSender eventSender;
				
				public EventSenderSelectorServiceImpl(String configFile) throws Exception {
					ClassPathResource resource = new ClassPathResource(configFile);
					
					if (resource.exists()) {
						try (InputStream inStream = resource.getInputStream()) {
							Properties properties = new Properties();
							properties.load(inStream);
							
							String eventSenderClassString = properties.getProperty(Constants.EVENT_SENDER_CLASS_PROPERTY);
							
							if (eventSenderClassString != null) {
								Class<?> eventSenderClass = Class.forName(eventSenderClassString);
								eventSender = (EventSender) eventSenderClass.getDeclaredConstructor().newInstance();
								logger.info("Created EventSender class");
							} else {
								logger.info("Configuration file doesn't contain the information about EventSender class");
							}
						}
					}
				}

				public void createFixedDeposit(FixedDepositDetails fixedDepositDetails) throws Exception {
					// Business logic
					if (eventSender != null) {
						// eventSender.sendEvent(event);
					}
				}
			}.getProperty(constants.EVENT_SENDER_CLASS_PROPERTY);
			
			if(eventSenderClassString ! = null) {
				Class<> eventSenderClass = Class.forName(eventSenderClassString);
				eventSender = (EventSender) eventSenderClass.newInstance();
				Logger.info("Created EventSender class");
			} else {
				logger.info("appConfig.prpertries file doesn't contain the information " +
			      "about EventSender class");
				
			}
			public void createFixedDeposit(FixedDepositDetails fixedDepositDetails) throws Exception {
				eventSender.sendEvent(event);
			}
			
		}
		
		Properties proties = new Properties();
		Properties
		    .setProperty(Constants.EVENT_SENDER_CLASS_PROPETY,
		    		"sample.sprig.chapter04.bankapp.event.DatabaseEventSender");
		   Properties.store(os, null);
		
		
	}

}

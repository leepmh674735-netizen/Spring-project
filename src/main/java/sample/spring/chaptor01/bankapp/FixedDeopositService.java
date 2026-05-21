package sample.spring.chaptor01.bankapp;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

@ManagedResource(objectName = "fixed_deposit_service:name=fixedDepositService")
public class FixedDepositService {
	
	@Autowired
	private transient JmsTemplate jmsTemplate;
	
	private boolean active;

	@Cacheable("fixedDeposits")
	public FixedDepositDetails getFixedDepositDetails(long id) {
		if (active) {
			// business logic
			return new FixedDepositDetails();
		}
		return null;
	}
	
	public boolean submitRequest(FixedDepositRequest request) {
		jmsTemplate.convertAndSend(request);
		return true;
	}
	
	@ManagedAttribute
	public boolean isActive() {
		return active;
	}
	
	@ManagedOperation
	public void activateService() {
		this.active = true;
	}
	
	@ManagedOperation
	public void deactivateService() {
		this.active = false;
	}
	
	@Transactional
	@Secured({ "ROLE_SAVINGS_ACCOUNT_CUSTOMER", "ROLE_APPLICATION_ADMIN" })
	public boolean createFixedDeposit(FixedDepositDetails fixedDepositDetails) { 
		Connection con = null;
		try {
			if (active) {
				// business logic
			}
			if (con != null) {
				con.setAutoCommit(false);
				con.commit();
			}
			return true;
		} catch(SQLException sqle) {
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e) {
					// exception handling
				}
			}
			return false;
		}
	}
}
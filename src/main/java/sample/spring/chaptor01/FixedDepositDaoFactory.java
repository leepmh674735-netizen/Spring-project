package sample.spring.chaptor01;

public class FixedDepositDaoFactory {
	private FixedDepositDaoFactory() {}
	
	public static FixedDepositDao getFixedDepositDao(String daoType) {
		FixedDepositDao fixedDepositDao = null;
		
		if("jdbc" .equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositJdbcDao();
			
		}
		if ("hibernate".equalsIgnoreCase(daoType)) {
			fixedDepositDao = new FixedDepositHibernateDao();
		}
		
		return fixedDepositDao;
	}

}

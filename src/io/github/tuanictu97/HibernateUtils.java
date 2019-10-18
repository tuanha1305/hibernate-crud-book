package io.github.tuanictu97;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionfactory=null;
		try {
		Configuration configuration=new Configuration();
		sessionfactory=configuration.configure().buildSessionFactory();
		}catch(Throwable ex) {
			ex.printStackTrace();
		}
		return sessionfactory;
	}
}

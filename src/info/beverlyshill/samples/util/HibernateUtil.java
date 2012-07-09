package info.beverlyshill.samples.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import info.beverlyshill.samples.controller.PagesController;

/**
 * Taken from the Hibernate 3.1 reference manual.
 * 
 * @author bhill2
 */
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Log log = LogFactory.getLog(PagesController.class);

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			// Log exception
			log.error("Initial SessionFactory creation failed." + ex.getMessage());
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

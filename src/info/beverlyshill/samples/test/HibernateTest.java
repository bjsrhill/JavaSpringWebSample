package com.beverlyshill.samples.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.beverlyshill.samples.model.Pages;

/**
 * Tests that Hibernate is configured properly by selecting the records from the
 * Pages table.
 * 
 * @author bhill2
 */
public class HibernateTest {
	public static void main(String args[]) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();
		Pages pages;
		// Get all Pages records
		List pagesList = session.createQuery("from Pages").list();
		for (int i = 0; i < pagesList.size(); i++) {
			pages = (Pages) pagesList.get(i);
			System.out.println("Row " + (i + 1) + "> " + pages.getName() + " ("
					+ pages.getPageId() + ")");
		}
		tran.commit();
		session.close();
		sessionFactory.close();
	}
}

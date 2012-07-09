package info.beverlyshill.samples.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import info.beverlyshill.samples.util.HibernateUtil;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.LockMode;

import info.beverlyshill.samples.controller.PagesController;
import info.beverlyshill.samples.model.Pages;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Manages database operations for the Pages table.
 * 
 * @author bhill2
 */
public class PagesManager {

	private static Log log = LogFactory.getLog(PagesController.class);

	/**
	 * Returns list of all Pages records
	 */
	public List getPages() {
		List PagesList = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			PagesList = session.createQuery("from Pages ORDER BY pageId")
					.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		}

		return PagesList;
	}

	/**
	 * Gets Pages record with matching pageId
	 * 
	 * @param pageId
	 *            is the page Id to search for
	 * 
	 * @return a Page object
	 */
	public Pages getPage(int pageId) {
		Pages page = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			page = (Pages) session
					.createQuery("from Pages" + " where pageId = ?")
					.setInteger(0, pageId).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		} finally {
			session.close();
		}
		return page;
	}

	/**
	 * Saves a Pages object to the database.
	 * 
	 * @param page
	 *            is the Page object to save
	 */
	public void savePages(Pages page) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.saveOrUpdate(page);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		} finally {
			session.close();
		}
	}

	/**
	 * Deletes a Pages record with matching pageId
	 * 
	 * @param pageId
	 *            is the Id of the Page record to delete
	 */
	public void deletePage(int pageId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.delete(session.load(Pages.class, new Integer(pageId)));
			session.flush();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			log.error(e.getMessage());
			throw e;
		} finally {
			session.close();
		}
	}
}

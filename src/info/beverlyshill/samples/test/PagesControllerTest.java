package info.beverlyshill.samples.test;

import info.beverlyshill.samples.controller.PagesController;
import info.beverlyshill.samples.model.Pages;
import info.beverlyshill.samples.model.PagesManager;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Test class for PagesController
 * 
 * @author bhill
 */
public class PagesControllerTest extends TestCase {
	private MockHttpServletRequest mockHttpServletRequest = null;
	private PagesController pagesController = null;
	private PagesManager pagesManager = new PagesManager();
	private Pages page = null;
	private String desc = "This is a sample web application built with the Spring framework.";
	private boolean match = false;
	private int pageId = 0;
	private static Log log = LogFactory.getLog(PagesControllerTest.class);

	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(PagesControllerTest.class);
	}
	
	/**
	 * Tests getting and setting the PagesManager on the
	 * PagesController
	 */
	public void testGetPagesManager() {
		PagesController newPagesController = new PagesController();
		PagesManager newPagesManager = new PagesManager();
		newPagesController.setPagesManager(newPagesManager);
		PagesManager secondPagesManager = null;
		secondPagesManager = newPagesController.getPagesManager();
		assertNotNull(secondPagesManager);
	}

	/**
	 * Tests returning a list of Pages database objects 
	 * from a ModelAndView request.
	 */
	public void testHandleRequest() throws Exception {
		mockHttpServletRequest = new MockHttpServletRequest("GET",
				"/index.html");
		try {
			pagesController = new PagesController();
			pagesController.setPagesManager(pagesManager);
			ModelAndView modelAndView = pagesController.handleRequest(
					mockHttpServletRequest, null);
			assertNotNull(modelAndView);
			assertNotNull(modelAndView.getModel());
			List pagesList = (List) modelAndView.getModel().get(
					PagesController.MAP_KEY);
			assertNotNull(pagesList);
			for (int i = 0; i < pagesList.size(); i++) {
				page = (Pages) pagesList.get(i);
				if (desc.equals(page.getTextDesc())) {
					match = true;
					pageId = page.getPageId();
				}
			}
			assertTrue(match == true);
			System.out.println(page.getTextDesc() + " passed!");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Create test Pages objects in database. This is called before each test.
	 */
	protected void setUp() throws Exception {
		
	}

	/**
	 * Delete test Pages objects from the database. This is called after each
	 * test.
	 */
	protected void tearDown() throws Exception {
		
	}
}

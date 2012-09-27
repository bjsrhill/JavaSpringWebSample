package info.beverlyshill.samples.test;

import info.beverlyshill.samples.controller.PagesMobileDevelopmentController;
import info.beverlyshill.samples.model.Pages;
import info.beverlyshill.samples.model.PagesMobileManager;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Test for PagesMobileDevelopmentController.java
 * 
 * @author bhill2
 * 
 */
public class PagesMobileDevelopmentControllerTest extends TestCase {
	private MockHttpServletRequest mockHttpServletRequest = null;
	private PagesMobileDevelopmentController pagesMobileDevelopmentController = new PagesMobileDevelopmentController();
	private PagesMobileManager pagesMobileManager = new PagesMobileManager();
	private Pages page = null;
	private String name = "Heading";
	private String desc = "description controller";
	private boolean match = false;
	private int pageId = 0;
	private static Log log = LogFactory
			.getLog(PagesMobileDevelopmentControllerTest.class);

	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(PagesMobileDevelopmentControllerTest.class);
	}

	/**
	 * Tests getting a particular Pages record
	 */
	public void testShowForm() throws Exception {
		mockHttpServletRequest = new MockHttpServletRequest("GET",
				"/index.html");

		try {
			Pages pages = new Pages();
			pagesMobileDevelopmentController = new PagesMobileDevelopmentController();
			pagesMobileDevelopmentController
					.setPagesMobileManager(pagesMobileManager);
			ModelAndView modelAndView = pagesMobileDevelopmentController
					.handleRequest(mockHttpServletRequest, null);
			assertNotNull(modelAndView);
			assertNotNull(modelAndView.getModel());
			List pagesList = (List) modelAndView.getModel().get(
					PagesMobileDevelopmentController.MAP_KEY);
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
			log.error("From PagesMobileDevelopmentControllerTest :"
					+ e.getMessage());
			throw e;
		}
	}

	/**
	 * Create test Pages objects in database. This is called before each test.
	 */
	protected void setUp() throws Exception {
		try {
			Pages page = null;
			page = new Pages();
			page.setName(name);
			page.setTextDesc(desc);
			pagesMobileDevelopmentController.getPagesMobileManager().savePages(
					page);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * Delete test Pages objects from the database. This is called after each
	 * test.
	 */
	protected void tearDown() throws Exception {
		pagesMobileDevelopmentController.getPagesMobileManager().deletePage(
				pageId);
	}
}

package info.beverlyshill.samples.test;

import info.beverlyshill.samples.controller.PagesMobileController;
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
 * Test for PagesMobileController.java
 * 
 * @author bhill2
 */
public class PagesMobileControllerTest extends TestCase {
	private MockHttpServletRequest mockHttpServletRequest = null;
	private PagesMobileController pagesMobileController = null;
	private PagesMobileManager pagesMobileManager = new PagesMobileManager();
	private Pages page = null;
	private String name = "Heading";
	private String desc = "description controller";
	private boolean match = false;
	private int pageId = 0;
	private static Log log = LogFactory.getLog(PagesMobileControllerTest.class);

	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(PagesMobileControllerTest.class);
	}

	/**
	 * Tests getting a particular Pages record
	 */
	public void testShowForm() throws Exception {
		mockHttpServletRequest = new MockHttpServletRequest("GET",
				"/index.html");

		try {
			Pages pages = new Pages();
			pagesMobileController = new PagesMobileController();
			pagesMobileController.setPagesMobileManager(pagesMobileManager);
			ModelAndView modelAndView = pagesMobileController.handleRequest(
					mockHttpServletRequest, null);
			assertNotNull(modelAndView);
			assertNotNull(modelAndView.getModel());
			List pagesList = (List) modelAndView.getModel().get(
					PagesMobileController.MAP_KEY);
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
			log.error("From PagesMobileControllerTest :" + e.getMessage());
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
			pagesMobileManager.savePages(page);
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
		pagesMobileManager.deletePage(pageId);
	}
}

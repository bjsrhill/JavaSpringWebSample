package info.beverlyshill.samples.test;

import junit.framework.TestCase;
import info.beverlyshill.samples.controller.PagesMobileDataMgtSAXController;
import info.beverlyshill.samples.model.Pages;
import info.beverlyshill.samples.model.PagesMobileManager;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Tests for PagesMobileDataMgtSAXController
 * 
 * @author bhill2
 *
 */
public class PagesMobileDataMgtSAXControllerTest extends TestCase {
	private MockHttpServletRequest mockHttpServletRequest = null;
	private PagesMobileDataMgtSAXController pagesMobileDataMgtSAXController = new PagesMobileDataMgtSAXController();
	private PagesMobileManager pagesMobileManager = new PagesMobileManager();
	private Pages page = null;
	private String name = "Index";
	private String desc = "description controller";
	private boolean match = false;
	private int pageId = 0;
	private static Log log = LogFactory
			.getLog(PagesMobileDataMgtSAXControllerTest.class);
	
	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(PagesMobileDataMgtSAXControllerTest.class);
	}

	/**
	 * Tests returning a List of all of the rows in the Pages table with a name
	 * value of 'Heading' and iterating through the list getting each page with
	 * the pageId
	 */
	public void testGetAllPages() {
		pagesMobileDataMgtSAXController.setPagesMobileManager(pagesMobileManager);
		List pagesList = pagesMobileManager.getPages();
		assertNotNull(pagesList);
		assertTrue(pagesList.size() > 0);
		pagesList = pagesMobileDataMgtSAXController.getPagesMobileManager().getPages();
		assertNotNull(pagesList);
		for (int i = 0; i < pagesList.size(); i++) {
			page = (Pages) pagesList.get(i);
			assertNotNull(pagesMobileDataMgtSAXController.getPagesMobileManager().getPage(page.getPageId()));
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

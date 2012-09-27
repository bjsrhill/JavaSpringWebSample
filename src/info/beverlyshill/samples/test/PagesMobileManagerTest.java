package info.beverlyshill.samples.test;

import info.beverlyshill.samples.model.PagesMobileManager;
import info.beverlyshill.samples.model.Pages;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.List;

/**
 * Test class for PagesMobileManager
 * 
 * @author bhill2
 */
public class PagesMobileManagerTest extends TestCase {
	PagesMobileManager pagesMobileManager = new PagesMobileManager();
	private Pages page = null;
	private String NAME = "Heading";
	private String DESC = "description manager";

	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(PagesManagerTest.class);
	}

	/**
	 * Tests returning a List of all of the rows in the Pages table with a name
	 * value of 'Heading' and iterating through the list getting each page with
	 * the pageId
	 */
	public void testGetAllPages() {
		List pagesList = pagesMobileManager.getPages();
		assertNotNull(pagesList);
		assertTrue(pagesList.size() > 0);
		pagesList = pagesMobileManager.getPages();
		assertNotNull(pagesList);
		for (int i = 0; i < pagesList.size(); i++) {
			page = (Pages) pagesList.get(i);
			assertNotNull(pagesMobileManager.getPage(page.getPageId()));
			System.out.println("Pages name = " + page.getPageId());
		}
	}

	/**
	 * Create test Pages objects in database. This is called before each test.
	 */
	protected void setUp() throws Exception {
		Pages page = null;
		page = new Pages();
		page.setName(NAME);
		page.setTextDesc(DESC);
		pagesMobileManager.savePages(page);
	}

	/**
	 * Delete test Pages objects from the database. This is called after each
	 * test.
	 */
	protected void tearDown() throws Exception {
		pagesMobileManager.deletePage(page.getPageId());
	}
}

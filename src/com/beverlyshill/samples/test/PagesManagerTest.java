package com.beverlyshill.samples.test;

import com.beverlyshill.samples.model.PagesManager;
import com.beverlyshill.samples.model.Pages;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.List;

/**
 * Test class for PagesManager
 * 
 * @author bhill2
 */
public class PagesManagerTest extends TestCase {
	PagesManager pagesManager = new PagesManager();
	private Pages page = null;
	private String NAME = "test name manager";
	private String DESC = "description manager";

	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}

	public static Test suite() {
		return new TestSuite(PagesManagerTest.class);
	}

	/**
	 * Tests returning a List of all of the rows in the Pages table Tests
	 * returning a single page object by pageId
	 */
	public void testGetAllPages() {
		List pagesList = pagesManager.getPages();
		assertNotNull(pagesList);
		assertTrue(pagesList.size() > 0);
		pagesList = pagesManager.getPages();
		assertNotNull(pagesList);
		for (int i = 0; i < pagesList.size(); i++) {
			page = (Pages) pagesList.get(i);
			assertNotNull(pagesManager.getPage(page.getPageId()));
			System.out.println("Pages name = " + page.getPageId());
		}
	}

	/**
	 * Create test Pages objects in database. The is called before each test.
	 */
	protected void setUp() throws Exception {
		Pages page = null;
		page = new Pages();
		page.setName(NAME);
		page.setTextDesc(DESC);
		pagesManager.savePages(page);
	}

	/**
	 * Delete test Pages objects from the database. This is called after each
	 * test.
	 */
	protected void tearDown() throws Exception {
		pagesManager.deletePage(page.getPageId());
	}
}

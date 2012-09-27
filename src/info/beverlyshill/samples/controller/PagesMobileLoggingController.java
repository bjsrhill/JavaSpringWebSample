package info.beverlyshill.samples.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import info.beverlyshill.samples.model.PagesMobileManager;
import info.beverlyshill.samples.model.Pages;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Controller class for the mobile logging detail page
 * 
 * @author bhill2
 * 
 */
public class PagesMobileLoggingController implements Controller {
	private PagesMobileManager pagesMobileManager;
	public static final String MAP_KEY = "pages";
	Log log = LogFactory.getLog(PagesMobileLoggingController.class);
	private String successView;

	/**
	 * Returns a Pages database object in ModelAndView which is for use on the
	 * logging detail page
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Pages pages = pagesMobileManager.getPage(4);
		// Log Pages data retrieved
		log.info("Retrieved " + pages.getTextDesc() + " from Pages table.");
		return new ModelAndView(getSuccessView(), MAP_KEY, pages);
	}

	/**
	 * Forwards to success view
	 */
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response, BindException errors, Map controlModel)
			throws Exception {
		try {
			return new ModelAndView(getSuccessView());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public PagesMobileManager getPagesMobileManager() {
		return this.pagesMobileManager;
	}

	public void setPagesMobileManager(PagesMobileManager pagesMobileManager) {
		this.pagesMobileManager = pagesMobileManager;
	}

	public String getSuccessView() {
		return this.successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

}

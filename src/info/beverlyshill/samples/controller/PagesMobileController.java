package info.beverlyshill.samples.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import info.beverlyshill.samples.model.PagesMobileManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Controller class for the mobile home page
 * 
 * @author bhill2
 */
public class PagesMobileController implements Controller {
	private PagesMobileManager pagesMobileManager;
	public static final String MAP_KEY = "pages";
	Log log = LogFactory.getLog(PagesMobileController.class);
	private String successView;

	/**
	 * Returns a list of Pages database objects in ModelAndView.
	 */
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List pages = pagesMobileManager.getPages();
		// Log number of Pages records retrieved
		log.info("Retrieved " + pages.size() + " records from Pages table.");
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

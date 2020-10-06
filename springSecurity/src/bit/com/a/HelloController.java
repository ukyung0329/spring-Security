package bit.com.a;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
								
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeMethod(Model model) {
		logger.info("homeMethod() " + new Date());
						
		return "home";		// home.jsp 
	}
	
	
}









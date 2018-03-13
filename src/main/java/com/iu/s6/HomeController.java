package com.iu.s6;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/fileTest",method=RequestMethod.POST)
	public void fileTest(FileDTO fileDTO){
		System.out.println(fileDTO.getF1().getName());
		System.out.println(fileDTO.getF1().getOriginalFilename());
	}
	
	
	@RequestMapping(value="/fileTest2",method=RequestMethod.POST)
	public void fileTest(MultipartFile f1){
		System.out.println(f1.getName());
		System.out.println(f1.getOriginalFilename());
	}
	
	
	@RequestMapping(value="/fileTest1",method=RequestMethod.POST)
	public void fileTest(MultipartHttpServletRequest request){
		MultipartFile f=request.getFile("f1");
		//파라미터 이름
		System.out.println(f.getName());
		//원본파일이름
		System.out.println(f.getOriginalFilename());
		//파일의크기
		System.out.println(f.getSize());
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}

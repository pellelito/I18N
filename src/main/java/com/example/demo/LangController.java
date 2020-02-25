package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

@Configuration
//Controller
@RestController
public class LangController {
	@Autowired
	private MessageSource messageSource;

//I18N 
	// Tests the different strings i different languages
	@GetMapping(path = "/I18N")
	public String getTest(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale, String var) {
		return messageSource.getMessage(var + ".message", null, locale);
	}
	
	// This adds new words and phrases for I18, also gets the locale to edit correct prop-file, default is en
	@GetMapping(path = "/add")	
	public void addI18n(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale, String var) {	
		
		// set default to en if locale is missing 
		if(locale == null) {locale = new Locale("en");}
		AppendToFile.appendToFile(var + "\n", locale);	
	}
	
	//This lets us to use user name in in different phrases, perhaps should be stored in a cookie?
	@GetMapping(path = "/user")	
	public String user(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale, String var, String name) {
		if(name==null) {name ="";};
		Object[] user = new Object[]{
                name
       };
		return messageSource.getMessage(var + ".message", user, locale);
	}
}

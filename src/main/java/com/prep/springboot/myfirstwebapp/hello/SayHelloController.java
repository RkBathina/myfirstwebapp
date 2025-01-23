package com.prep.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller //this @RestController annot is qualified component of @Componenet annot which elps to create spring bean then spring IOC container can handle this bean
public class SayHelloController {
	
	//"say-hello" => "Hello! What are you learning today?"
	
	@RequestMapping("/say-hello")
	@ResponseBody  //if we use @controller then we need this @Responsebody annot
	public String sayHello() {
		return "Hello! What are you learning today?";
		
	}
	
	
	@RequestMapping("/say-hello-html")
	@ResponseBody           //it's hard to write html code as below, so we have great view technology- JSP(java serverpages)
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body");
		sb.append("</body>");
		sb.append("</html>");
				
		return sb.toString();
		
	}
	
	//\src\main\resources\META-INF\resources\WEB-INF\jsp\sayHello.jsp
	//\src\main\resources\META-INF\resources\WEB-INF\jsp\welcome.jsp
	//\src\main\resources\META-INF\resources\WEB-INF\jsp\login.jsp
	//\src\main\resources\META-INF\resources\WEB-INF\jsp\todos.jsp
	//@ResponseBody  if we have response body then MVC returns sthe content in the method, it doesnot go to .jsp page
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
		
	}

}

package cn.gz.xchao.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	// @Bean
	// public ServletRegistrationBean dispatcherRegistration(
	// DispatcherServlet dispatcherServlet) {
	// ServletRegistrationBean reg = new ServletRegistrationBean(
	// dispatcherServlet);
	// reg.getUrlMappings().clear();
	// // reg.addUrlMappings("/");
	// reg.addUrlMappings("*.html");
	// // reg.addUrlMappings("*.do");
	// Collection<String> con = reg.getUrlMappings();
	// for (String s : con) {
	// System.out.println(s);
	// }
	// return reg;
	// }
}

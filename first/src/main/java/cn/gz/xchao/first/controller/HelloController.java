package cn.gz.xchao.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/1")
public class HelloController {
	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}
}

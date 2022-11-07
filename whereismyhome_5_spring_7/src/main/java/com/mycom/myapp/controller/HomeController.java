package com.mycom.myapp.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mycom.myapp.city.dto.CityCodeDto;

// @RestController 아님. 비동기 요청에 대한 처리 controller 가 아님. 페이지 이동에 대한 역할 수행 
@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String home() {
		return "/html/index.html"; // static folder 의 index.html 로 이동
	}

	@GetMapping(value = "/user")
	public String login() {
		return "/html/user/login.html";
	}

	@GetMapping(value = "/register")
	public String register() {
		return "/html/user/register.html";
	}

	@GetMapping(value = "/house")
	public String house() {		
		return "/html/house/houseMain.html";
	}

	@GetMapping(value = "/favorite")
	public String favorite() {
		return "/html/house/houseFavorite.html";
	}

	@GetMapping(value = "/board")
	public String board() {
		return "/html/boardMain.html";
	}

	@GetMapping(value = "/event")
	public String event() {
		return "/html/eventMain.html";
	}

	@GetMapping(value = "/arround")
	public String arround() {
		return "/html/arroundMain.html";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/html/login.html";
	}

}

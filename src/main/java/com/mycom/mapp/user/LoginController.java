package com.mycom.mapp.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	UserServiceImpl Service;
	
	//로그인 login.jsp 파일 화면에 나타냄
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginCheck(HttpSession session, UserVO vo) {
		String returnURL = "";
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}

		UserVO loginvo = Service.getUser(vo);
		if (loginvo != null) {
			System.out.println("로그인 성공!");
			session.setAttribute("login", loginvo);
			returnURL = "redirect:/board/list";
		} else {
			System.out.println("로그인 실패!");
			returnURL = "redirect:/login/login";
		}
		return returnURL;

	}
	
	//로그아웃 하는 부분
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/login";
	}
	

}

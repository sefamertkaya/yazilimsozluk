package com.sefamertkaya.yazilimsozluk;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sefamertkaya.entity.User;
import com.sefamertkaya.service.MailService;
import com.sefamertkaya.service.UserService;

@Controller
public class LoginController {

	public static String url = "http://localhost:8080/yazilimsozluk";

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@RequestMapping(value = "/uyeol", method = RequestMethod.GET)
	public String uyeol(Model model) {

		return "register";

	}

	@RequestMapping(value = "/girisyap", method = RequestMethod.GET)
	public String girisyap(Model model, HttpServletRequest request) {

		return "login";

	}

	@RequestMapping(value = "/sifremiunuttum", method = RequestMethod.POST)
	public ResponseEntity<String> sifrehatirlat(@RequestBody String username, HttpServletRequest request) {

		User user = userService.getUserNameForPass(username, request);

		if (user != null) {
			mailService.registerMail(user.getEmail(), user.getKeyreg());
			return new ResponseEntity<>("OK", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("e", HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/sifrehatirlat", method = RequestMethod.GET)
	public String sifremiunuttum(Model model, HttpServletRequest request) {

		return "password";

	}

	@RequestMapping(value = "/cikis", method = RequestMethod.GET)
	public String cikis(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/anasayfa";

	}

	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public ResponseEntity<String> loginControl(@RequestBody User user, HttpServletRequest request) {

		User userM = userService.getFindByEmail(user);

		if (userM != null) {

			User userN = userService.getFindByEmailAndPass(user);

			if (userN != null) {
				request.getSession().setAttribute("user", userN);
				return new ResponseEntity<>("OK", HttpStatus.OK);

			}
			return new ResponseEntity<>("ERROR", HttpStatus.OK);

		} else {
			return new ResponseEntity<>("ERROR404", HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/pss/{key}", method = RequestMethod.GET)
	public String ekle(@PathVariable("key") String key, Model model) {

		if (userService.getFindBykey(key) == true) {

			User user = userService.getFindBykeyUser(key);

			model.addAttribute("useridsi", user.getUserId());

			return "yenisifre";

		}
		return "redirect:/anasayfa";
	}

}
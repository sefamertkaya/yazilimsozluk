package com.sefamertkaya.yazilimsozluk;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sefamertkaya.entity.Comment;
import com.sefamertkaya.entity.Complaint;
import com.sefamertkaya.entity.Entry;
import com.sefamertkaya.entity.Message;
import com.sefamertkaya.entity.User;
import com.sefamertkaya.service.CommentService;
import com.sefamertkaya.service.ComplaintService;
import com.sefamertkaya.service.EntryService;
import com.sefamertkaya.service.MessageService;
import com.sefamertkaya.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private EntryService entryService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private ComplaintService complaintService;

	public int sayi = 0;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home1(Locale locale, Model model) {

		return "redirect:/anasayfa";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {

		return "redirect:/anasayfa";
	}

	@RequestMapping(value = "/anasayfa", method = RequestMethod.GET)
	public String home3(HttpServletRequest request, Model model) {

		if (request.getSession().getAttribute("user") != null) {
			return "redirect:/indexoturum";
		}

		return "home";

	}

	@RequestMapping(value = "/indexoturum", method = RequestMethod.GET)
	public String homeSession(HttpServletRequest request, Model model) {

		model.addAttribute("user", request.getSession().getAttribute("user"));

		model.addAttribute("entryler", entryService.getAll());
		return "Sessionhome";
	}

	@RequestMapping(value = "/baslikac", method = RequestMethod.GET)
	public String baslikAc(Locale locale, Model model, HttpServletRequest request) {

		model.addAttribute("user", request.getSession().getAttribute("user"));

		return "baslikAc";
	}

	@RequestMapping(value = "/ben", method = RequestMethod.GET)
	public String profil2(HttpServletRequest request, Model model) {
		model.addAttribute("user", request.getSession().getAttribute("user"));
		return "profil";
	}

	@RequestMapping(value = "/profil/{userId}", method = RequestMethod.GET)
	public String profil(@PathVariable("userId") Long userId, Model model, HttpServletRequest request) {

		int useraddentry = entryService.CountUserEntry(userId);
		Long ucursayi = userService.getFindByUserId(userId).getGood();
		Long devirsayi = userService.getFindByUserId(userId).getBad();
		model.addAttribute("ucursayi", ucursayi);
		model.addAttribute("devirsayi", devirsayi);
		model.addAttribute("entrysayi", useraddentry);

		model.addAttribute("userId", userId);

		if (request.getSession().getAttribute("user") != null) {
			return "redirect:/Sprofil/{userId}";
		}

		return "profil";
	}

	@RequestMapping(value = "/Sprofil/{userId}", method = RequestMethod.GET)
	public String profilSession(@PathVariable("userId") Long userId, Model model, HttpServletRequest request) {

		int useraddentry = entryService.CountUserEntry(userId);
		Long ucursayi = userService.getFindByUserId(userId).getGood();
		Long devirsayi = userService.getFindByUserId(userId).getBad();
		model.addAttribute("ucursayi", ucursayi);
		model.addAttribute("devirsayi", devirsayi);
		model.addAttribute("entrysayi", useraddentry);

		model.addAttribute("user", request.getSession().getAttribute("user"));
		model.addAttribute("userId", userId);

		return "profilSession";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody User user, HttpServletRequest request) {

		User userD = userService.getFindByUsername(user, request);

		if (userD != null) {

			return new ResponseEntity<>("ERROR", HttpStatus.OK);
		} else {

			System.out.println(user.toString());
			userService.createUser(user, request);
			return new ResponseEntity<>("OK", HttpStatus.CREATED);
		}
	}

	@RequestMapping(value = "/addEntry", method = RequestMethod.POST)
	public ResponseEntity<String> addEntry(@RequestBody Entry entry, HttpServletRequest request) {

		Entry entryC = entryService.controlTitle(entry);

		if (entryC == null) {

			entryService.createEntry(entry, request);

			return new ResponseEntity<>("ok", HttpStatus.CREATED);

		} else {

			return new ResponseEntity<>("baslikhata", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/getEntry", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Entry>> getEntry(HttpServletRequest request) {

		return new ResponseEntity<>(entryService.getAll(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/baslik/{entryId}/{pageId}", method = RequestMethod.GET)
	public String baslikSayfa(@PathVariable("entryId") Long entryId, @PathVariable("pageId") int pageId, Model model,
			HttpServletRequest request) {

		model.addAttribute("user", request.getSession().getAttribute("user"));

		if (request.getSession().getAttribute("user") != null) {

			return "redirect:/basliks/{entryId}/{pageId}";
		}
		int sayi = commentService.getAllEntryIdSayfaSAYI(entryId);

		float sonuc = (float) (sayi / 10.0);
		model.addAttribute("yorumsayi", sonuc);
		model.addAttribute("pageId", pageId);
		model.addAttribute("entryId", entryId);
		return "entryic";

	}

	@RequestMapping(value = "/basliks/{entryId}/{pageId}", method = RequestMethod.GET)
	public String SessionbaslikSayfa(@PathVariable("entryId") Long entryId, @PathVariable("pageId") int pageId,
			Model model, HttpServletRequest request) {

		model.addAttribute("user", request.getSession().getAttribute("user"));

		int sayi = commentService.getAllEntryIdSayfaSAYI(entryId);

		float sonuc = (float) (sayi / 10.0);
		model.addAttribute("yorumsayi", sonuc);
		model.addAttribute("pageId", pageId);

		model.addAttribute("entryId", entryId);

		return "SessionEntryic";
	}

	@RequestMapping(value = "/getEntryIn", method = RequestMethod.POST)
	public ResponseEntity<Entry> getEntryId(@RequestBody String entryId, HttpServletRequest request) {

		return new ResponseEntity<>(entryService.getFindByIdEntry(Long.parseLong(entryId)), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public ResponseEntity<String> addComment(@RequestBody Comment comment, HttpServletRequest request) {

		commentService.createComment(comment, request);
		return new ResponseEntity<>("OK", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getComment", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Comment>> getcomment(@RequestBody String entryId, HttpServletRequest request) {

		return new ResponseEntity<>(commentService.getAllEntryIdSayfa((Long.parseLong(entryId)), sayi),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getPage", method = RequestMethod.POST)
	public void getPage(@RequestBody String pageId, HttpServletRequest request) {

		sayi = Integer.parseInt(pageId) * 10;

	}

	@RequestMapping(value = "/getPopular", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Entry>> getPopular(HttpServletRequest request) {

		System.out.println(entryService.getPopular());
		return new ResponseEntity<>(entryService.getPopular(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getUserData", method = RequestMethod.POST)
	public ResponseEntity<User> getUserData(@RequestBody String userId, HttpServletRequest request) {

		return new ResponseEntity<>(userService.getFindByUserId(Long.parseLong(userId)), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/getEntryUserId", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Entry>> getEntryUserId(@RequestBody String userId, HttpServletRequest request) {

		return new ResponseEntity<>(entryService.getAlluserId(Long.parseLong(userId)), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/getCommentUserId", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Comment>> getCommentUserId(@RequestBody String userId, HttpServletRequest request) {

		return new ResponseEntity<>(commentService.getAllUserId(Long.parseLong(userId)), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/getentrytitleforid", method = RequestMethod.POST)
	public ResponseEntity<Entry> getCommentUserIdentry(@RequestBody String userId, HttpServletRequest request) {

		System.out.println("---------------------------------" + userId);
		return new ResponseEntity<>(entryService.getFindByIdEntry(Long.parseLong(userId)), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/mesaj/{userId}", method = RequestMethod.GET)
	public String message(@PathVariable("userId") Long userId, Model model, HttpServletRequest request) {

		model.addAttribute("user", request.getSession().getAttribute("user"));
		model.addAttribute("userId", userId);
		User us = userService.getFindByUserId(userId);
		model.addAttribute("us", us);

		return "message";
	}

	@RequestMapping(value = "/getMesaj", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Message>> getmessage(@RequestBody String userId, Model model,
			HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		return new ResponseEntity<>(messageService.getAll(user.getUserId(), Long.parseLong(userId)),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/addMessage", method = RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody Message message, HttpServletRequest request) {

		messageService.createMessage(message, request);

		return new ResponseEntity<>("ok", HttpStatus.CREATED);

	}

	@RequestMapping(value = "/ucur/{userId}", method = RequestMethod.GET)
	public String ucur(@PathVariable("userId") String userId, HttpServletRequest request) {

		User user = userService.getFindByUserId(Long.parseLong(userId));
		Long temp = user.getGood();
		temp++;
		user.setGood(temp);
		userService.updateUser(user, request);

		return "redirect:/anasayfa";
	}

	@RequestMapping(value = "/devir/{userId}", method = RequestMethod.GET)
	public String devir(@PathVariable("userId") String userId, HttpServletRequest request) {

		User user = userService.getFindByUserId(Long.parseLong(userId));
		Long temp = user.getBad();
		temp++;
		user.setBad(temp);
		userService.updateUser(user, request);

		return "redirect:/anasayfa";
	}

	@RequestMapping(value = "/sikayet/{userId}", method = RequestMethod.GET)
	public String sikayet(@PathVariable("userId") String userId, HttpServletRequest request, Model model) {

		User user = userService.getFindByUserId(Long.parseLong(userId));
		model.addAttribute("user", user);
		if (request.getSession().getAttribute("user") != null) {

			User userm = (User) request.getSession().getAttribute("user");
			model.addAttribute("userSession", userm.getUserId());
			return "sikayet";
		}

		model.addAttribute("userSession", 0);
		return "sikayet";
	}

	@RequestMapping(value = "/sikayetvar", method = RequestMethod.POST)
	public ResponseEntity<String> sikayetvar(@RequestBody Complaint complaint, HttpServletRequest request,
			Model model) {

		complaintService.createComplaint(complaint);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);

	}

	@RequestMapping(value = "/ucur/{entryId}/{userId}", method = RequestMethod.GET)
	public String ucur(@PathVariable("entryId") String entryId, @PathVariable("userId") String userId,
			HttpServletRequest request) {

		User user = userService.getFindByUserId(Long.parseLong(userId));
		Long temp = user.getGood();
		temp++;
		user.setGood(temp);
		userService.updateUser(user, request);

		return "redirect:/baslik/{entryId}";
	}

	@RequestMapping(value = "/devir/{entryId}/{userId}", method = RequestMethod.GET)
	public String devir(@PathVariable("entryId") String entryId, @PathVariable("userId") String userId,
			HttpServletRequest request) {

		User user = userService.getFindByUserId(Long.parseLong(userId));
		Long temp = user.getBad();
		temp++;
		user.setBad(temp);
		userService.updateUser(user, request);

		return "redirect:/baslik/{entryId}";
	}

	@RequestMapping(value = "/sifreDegis", method = RequestMethod.POST)
	public ResponseEntity<String> sifreDegis(@RequestBody User user, HttpServletRequest request) {
		System.out.println(
				"BURADA USER IDSÝ VAR MAÞALLAH" + user.getUserId() + "BURDADA SEÇTÝÐÝ PAROLA VAR" + user.getPassword());
		User userD = userService.getFindByUserId(user.getUserId());
		userD.setPassword(user.getPassword());

		userService.updateUser(userD, request);

		return new ResponseEntity<>("OK", HttpStatus.CREATED);

	}

	@RequestMapping(value = "/ara", method = RequestMethod.POST)
	public ResponseEntity<Entry> ara(@RequestBody String title, Model model, HttpServletRequest request) {

		Entry entry = entryService.controlTitle(title);

		return new ResponseEntity<>(entry, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/mesajkutusu/{userId}", method = RequestMethod.GET)
	public String mesajKutusu(@PathVariable("userId") Long userId, Model model, HttpServletRequest request) {

		model.addAttribute("user", request.getSession().getAttribute("user"));

		User user = (User) request.getSession().getAttribute("user");

		if (user.getUserId() == userId) {
			return "mesajkutusu";

		}

		return "redirect:/anasayfa";

	}

	@RequestMapping(value = "/messagebox", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Message>> messagebox(@RequestBody String recipientId, HttpServletRequest request) {

		User user = (User) request.getSession().getAttribute("user");

		return new ResponseEntity<>(messageService.recipientMessage(Long.parseLong(recipientId)), HttpStatus.CREATED);

	}

}

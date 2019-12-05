package com.won.project.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.won.project.model.User;
import com.won.project.repository.UserRepository;
import com.won.project.utils.Script;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository mRepo;

	@PostMapping("/join")
	public @ResponseBody String join(User user) {
		int result = mRepo.join(user);
		System.out.println(user);
		if (result == 1) {
			return Script.href("/user/loginForm");
		} else {
			return Script.back("가입 실패");
		}
	}

	@GetMapping("/profileForm")
	public String profileForm() {
		return "profileForm";
	}

	@PostMapping("/login")
	public @ResponseBody String login(User user, HttpSession session) {
		User u = mRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		System.out.println(u);
		session.setAttribute("user", u);
		if (u != null) {
			return Script.href("/board/list");
		} else {
			return Script.back("로그인 실패");
		}
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}

	@Value("${file.path}")
	private String resourcePath;

	@PostMapping("/profile/{id}")
	public @ResponseBody String imageUpload(@PathVariable int id, @RequestParam("file") MultipartFile file) {
		
		UUID uuid = UUID.randomUUID();
		String uuidFileName = uuid + "_" + file.getOriginalFilename();
		Path filePath = Paths.get(resourcePath + uuidFileName);
		System.out.println("filePath : " + filePath);
		try {
			Files.write(filePath, file.getBytes());
			mRepo.update(id, filePath.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Script.href("/board/list");

	}
}

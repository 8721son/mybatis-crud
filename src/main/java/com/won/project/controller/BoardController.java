package com.won.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.won.project.model.Board;
import com.won.project.repository.BoardRepository;
import com.won.project.utils.Script;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardRepository mRepo;

	@GetMapping("/list")
	public String boardList(Model model) {
		List<Board> boards = mRepo.findAll();
		model.addAttribute("boards", boards);
		return "list";
	}

	@PostMapping("/update")
	public @ResponseBody String update(Board board) {

		int result = mRepo.update(board);
		if (result == 1) {
			return Script.href("/board/list");
		} else {
			return Script.back("수정 실패");
		}
	}

	// GET => http://localhost:8080/post/writeForm
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	

	// delete -> form, get방식 id=1 @RequestParam("id")
	@GetMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		int result = mRepo.delete(id);
		if (result == 1) {
			return Script.href("/board/list");
		} else {
			return Script.back("삭제 실패");
		}
	}

	@PostMapping("/save")
	public @ResponseBody String save(Board board,HttpSession session) {
		System.out.println(board);
		int result = mRepo.save(board);
		if(result==1) {
			return Script.href("/board/list");
		}else {
			return Script.back("저장 실패");
		}
	}
	
	@GetMapping("/detail/{id}")
	   public String detail(@PathVariable int id , Model model) {
	      Board board = mRepo.findById(id);
	      model.addAttribute("board", board);
	      return "detail";
	  }

	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {

		Board board = mRepo.findById(id);
		model.addAttribute("board", board);
		return "updateForm";
	}
}

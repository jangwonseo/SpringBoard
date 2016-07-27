package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	private BoardService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get..................................");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("regist post...................................");
		logger.info(board.toString());

		service.regist(board);

		// model.addAttribute("result","success");
		rttr.addFlashAttribute("msg", "success");
		// return "/board/success";
		return "redirect:/board/listAll";
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list");
		model.addAttribute("list",service.listAll());
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		//addAttribute에 아무런 이름없이 데이터를 넣으면 자동으로 들어가는 값 클래스 이름을 소문자로 시작해서 사요하게됨
		//여기서는 boardVO
		model.addAttribute(service.read(bno));
	}
	
	
}

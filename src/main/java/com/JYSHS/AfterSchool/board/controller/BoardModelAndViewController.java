package com.JYSHS.AfterSchool.board.controller;

import com.JYSHS.AfterSchool.board.BoardVO;
import com.JYSHS.AfterSchool.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("board")
@AllArgsConstructor
public class BoardModelAndViewController {
    @Autowired
    private BoardService boardService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping({"","/list"})
    public String boardMain(Model model){
        List<BoardVO> boardList= boardService.boardListForAdmin();
        model.addAttribute("data", boardList);
        return "board/boardMain";
    }

    @GetMapping("/create")
    public String freeBoardCreate(Model model){
        BoardVO boardVo = new BoardVO();
        boardVo.setBoardType("자유");
        model.addAttribute("BoardVO",boardVo);
        return "board/boardCreate";
    }
    @PostMapping(value = "/create")
    public String boardCreate(Model model, BoardVO boardJSON){
        String id = boardService.registBoard(boardJSON);
        System.out.println(id);
        return "redirect:/board/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        BoardVO boardVo = boardService.boardDetail(id);
        model.addAttribute("data",boardVo);
        return "board/boardDetail";
    }
    @GetMapping("/search")
    public String searchBoard(Model model,BoardVO boardJSON){
        String paramType = "";
        List<BoardVO> boardList= boardService.boardList(boardJSON,paramType);
        model.addAttribute("data", boardList);
        model.addAttribute("type","자유");
        return "board/boardMain";
    }

}

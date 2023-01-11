package com.JYSHS.AfterSchool.board.controller;

import com.JYSHS.AfterSchool.board.BoardVO;
import com.JYSHS.AfterSchool.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("board")
public class BoardAjaxController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/list.do")
    public List<BoardVO> boardList(Model model, BoardVO boardJSON, String paramType){
        List<BoardVO> boardList= boardService.boardListForAdmin();
        return boardList;
    }


}

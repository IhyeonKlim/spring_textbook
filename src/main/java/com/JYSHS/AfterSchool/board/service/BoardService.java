package com.JYSHS.AfterSchool.board.service;

import com.JYSHS.AfterSchool.aggregate.user.UserVO;
import com.JYSHS.AfterSchool.board.BoardVO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    String registBoard(BoardVO board);
    BoardVO boardDetail(String id);
    List<BoardVO> boardListForAdmin();

    List<BoardVO> boardList(BoardVO board, String paramType);
    void modify(BoardVO boardVO);
    void remove(String userId);

}

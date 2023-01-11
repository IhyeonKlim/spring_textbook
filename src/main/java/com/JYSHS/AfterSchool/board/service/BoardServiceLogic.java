package com.JYSHS.AfterSchool.board.service;

import com.JYSHS.AfterSchool.aggregate.user.UserVO;
import com.JYSHS.AfterSchool.board.BoardVO;
import com.JYSHS.AfterSchool.board.store.BoardStoreInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceLogic implements BoardService {


    private BoardStoreInterface boardMapStore;

    public BoardServiceLogic(BoardStoreInterface boardStore){
        this.boardMapStore = boardStore;
    }
    @Override
    public String registBoard(BoardVO board) {
        return boardMapStore.create(board);
    }

    @Override
    public BoardVO boardDetail(String boardId) {
        return boardMapStore.retrieveById(boardId);
    }

    @Override
    public List<BoardVO> boardListForAdmin() {
        return boardMapStore.retrieveAllForAdmin();
    }

    @Override
    public List<BoardVO> boardList(BoardVO boardVo, String paramType) {
        return boardMapStore.retrieveAllForParam(boardVo, paramType);
    }

    @Override
    public void modify(BoardVO boardVO) {
        boardMapStore.update(boardVO);
    }

    @Override
    public void remove(String userId) {
        boardMapStore.delete(userId);
    }
}

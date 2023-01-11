package com.JYSHS.AfterSchool.board;

import com.JYSHS.AfterSchool.aggregate.Entity;
import com.JYSHS.AfterSchool.aggregate.club.TravelClub;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BoardVO{

    public String id; //게시판 고유id
    public String boardType; //게시판 종류 (input)
    public int boardNo; //게시판 넘버링
    private String title; //제목 (input)
    private String contents; //내용 (input)
    private String register; //작성자(별명) (input)
    private String userId; //작성자 userId;
    private String regDt; //작성일
    private String upDt; //수정일 (input)
    private int viewCnt; //조회수
    private String auth; //비밀글여부 (input)

    @Override
    public String toString() {
        //데이터 확인을 위한 간단 확인
        StringBuilder builder = new StringBuilder();

        builder.append("  board Id:").append(id);
        builder.append(", boardType:").append(boardType);
        builder.append(", boardNo:").append(boardNo);
        builder.append(", title:").append(title);
        builder.append(", contents:").append(contents);
        builder.append(", register:").append(register);
        builder.append(", userId:").append(userId);
        builder.append(", viewCnt:").append(viewCnt);
        builder.append(", regDt:").append(regDt);
        builder.append(", upDt:").append(upDt);
        builder.append(", auth:").append(auth);

        return builder.toString();
    }

    //validation 영역
    private static final int MINIMUM_TITLE_LENGTH =  4; //제목 최소값
    private static final int MAXIMUM_TITLE_LENGTH =  20; //제목 최대값
    public void checkValidation() {
        checkTitleValidation(title);
    }
    private void checkTitleValidation(String title) {
        //제목길이 체크
        if (title.length() < BoardVO.MINIMUM_TITLE_LENGTH) {
            throw new IllegalArgumentException("\t > title should be longer than " + BoardVO.MINIMUM_TITLE_LENGTH);
        }else if (title.length() > BoardVO.MAXIMUM_TITLE_LENGTH) {
            throw new IllegalArgumentException("\t > title should be shorter than " + BoardVO.MAXIMUM_TITLE_LENGTH);
        }
    }

}

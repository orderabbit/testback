package com.korea.test.dto.response.board;

import com.korea.test.common.ResponseCode;
import com.korea.test.common.ResponseMessage;
import com.korea.test.dto.response.ResponseDto;
import com.korea.test.repository.resultSet.GetBoardResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetBoardResponseDto extends ResponseDto {

    private int boardNumber;
    private String title;
    private String content;

    public GetBoardResponseDto(GetBoardResultSet resultSet){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        this.boardNumber = resultSet.getItemNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
    }

    public static ResponseEntity<GetBoardResponseDto> success(GetBoardResultSet resultSet){
        GetBoardResponseDto responseBody = new GetBoardResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistBoard(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}

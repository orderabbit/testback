package com.korea.test.dto.response.board;

import com.korea.test.common.ResponseCode;
import com.korea.test.common.ResponseMessage;
import com.korea.test.dto.response.ResponseDto;
import com.korea.test.entity.BoardEntity;
import com.korea.test.repository.resultSet.GetBoardResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetAllBoardsResponseDto extends ResponseDto {
    private List<BoardEntity> boards;

    public GetAllBoardsResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<GetAllBoardsResponseDto> success(){
        GetAllBoardsResponseDto responseBody = new GetAllBoardsResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}

package com.korea.test.service;

import com.korea.test.dto.request.board.PatchBoardRequestDto;
import com.korea.test.dto.request.board.PostBoardRequestDto;
import com.korea.test.dto.response.board.*;
import org.springframework.http.ResponseEntity;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber);
    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer itemNumber);
    ResponseEntity<? super GetAllBoardsResponseDto> getAllBoards();
}

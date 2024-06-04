package com.korea.test.controller;

import com.korea.test.dto.request.board.PatchBoardRequestDto;
import com.korea.test.dto.request.board.PostBoardRequestDto;
import com.korea.test.dto.response.board.*;
import com.korea.test.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<? super PostBoardResponseDto> postBoard(
            @RequestBody @Valid PostBoardRequestDto requestBody
    ) {
        ResponseEntity<? super PostBoardResponseDto> response = boardService.postBoard(requestBody);
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity<? super GetAllBoardsResponseDto> getAllBoards() {
        ResponseEntity<? super GetAllBoardsResponseDto> response = boardService.getAllBoards();
        return response;
    }

    @GetMapping("/detail/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber
    ) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    @PatchMapping("/{boardNumber}")
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(
            @RequestBody @Valid PatchBoardRequestDto requestBody,
            @PathVariable("boardNumber") Integer boardNumber
    ){
        ResponseEntity<? super PatchBoardResponseDto> response = boardService.patchBoard(requestBody, boardNumber);
        return response;
    }

    @DeleteMapping("/delete/{itemNumber}")
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(
            @PathVariable("itemNumber") Integer itemNumber,
            @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<? super DeleteBoardResponseDto> response = boardService.deleteBoard(itemNumber);
        return response;
    }
}

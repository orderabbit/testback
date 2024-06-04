package com.korea.test.service.serviceImplement;

import com.korea.test.dto.request.board.PatchBoardRequestDto;
import com.korea.test.dto.request.board.PostBoardRequestDto;
import com.korea.test.dto.response.ResponseDto;
import com.korea.test.dto.response.board.*;
import com.korea.test.entity.BoardEntity;
import com.korea.test.repository.BoardRepository;
import com.korea.test.repository.resultSet.GetBoardResultSet;
import com.korea.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class boardServiceImplement implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer itemNumber) {
        GetBoardResultSet resultSet = null;
        try {
            resultSet = boardRepository.getBoard(itemNumber);

            if (resultSet == null) return GetBoardResponseDto.notExistBoard();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetBoardResponseDto.success(resultSet);
    }

    @Override
    public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto) {

        try {
            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber) {

        try{
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return PatchBoardResponseDto.notExistBoard();

            boardEntity.patchBoard(dto);
            boardRepository.save(boardEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber) {
        try{
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if(boardEntity == null) return DeleteBoardResponseDto.notExistedBoard();

            boardRepository.delete(boardEntity);

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteBoardResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAllBoardsResponseDto> getAllBoards() {
        try{

            List<BoardEntity> boards = boardRepository.findAll();

        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetAllBoardsResponseDto.success();
    }
}

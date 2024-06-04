package com.korea.test.entity;

import com.korea.test.dto.request.board.PatchBoardRequestDto;
import com.korea.test.dto.request.board.PostBoardRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boardNumber;
    private String title;
    private String content;


    public BoardEntity(PostBoardRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

    public void patchBoard(PatchBoardRequestDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }
}

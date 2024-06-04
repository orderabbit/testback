package com.korea.test.repository;

import com.korea.test.entity.BoardEntity;
import com.korea.test.repository.resultSet.GetBoardResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    BoardEntity findByBoardNumber(Integer boardNumber);

    @Query(
            value=
                    "SELECT " +
                            "B.board_number AS boardNumber, " +
                            "B.title AS title, " +
                            "B.content AS content, " +
                            "FROM board_list AS B " +
                            "WHERE board_number = ?1 ",
            nativeQuery = true
    )
    GetBoardResultSet getBoard(Integer itemNumber);
}

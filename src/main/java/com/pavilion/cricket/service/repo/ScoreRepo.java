package com.pavilion.cricket.service.repo;

import com.pavilion.cricket.model.GameScore;
import com.pavilion.cricket.model.UserPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Map;

public interface ScoreRepo extends JpaRepository<GameScore, Long> {

    @Query("SELECT g FROM GameScore g WHERE g.userID = :#{#id}")
    GameScore findByUserID(@Param("id") long id);

    @Query("SELECT g FROM GameScore g ORDER BY g.score DESC")
    List<GameScore> getAll(Pageable pageable);


    @Query(value = "SELECT s.*\n" +
            "FROM (SELECT t.*,\n" +
            "             ROW_NUMBER() OVER(ORDER BY t.score DESC ) AS position" +
            "      FROM game_score t) s\n" +
            "WHERE s.id = :#{#id}",
            nativeQuery = true
    )
    Map<String,Object> getPosition(@Param("id") long id);

}

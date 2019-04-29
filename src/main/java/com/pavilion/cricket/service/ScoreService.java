package com.pavilion.cricket.service;

import com.pavilion.cricket.model.GameScore;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ScoreService {

    GameScore addOrUpdate(GameScore score);
    List<GameScore> getAll(Pageable pageable);
    GameScore findByUserId(long id);

}

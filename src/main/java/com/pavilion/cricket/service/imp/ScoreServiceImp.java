package com.pavilion.cricket.service.imp;

import com.pavilion.cricket.model.GameScore;
import com.pavilion.cricket.model.UserPosition;
import com.pavilion.cricket.service.ScoreService;
import com.pavilion.cricket.service.repo.ScoreRepo;
import com.pavilion.cricket.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ScoreServiceImp implements ScoreService {

    @Autowired
    ScoreRepo repo;

    @Override
    public GameScore addOrUpdate(GameScore score) {
        GameScore prevScore = repo.findByUserID(score.getUserID());
        if (prevScore == null){
            return repo.save(score);
        }else {
            boolean isLarge = Utils.compareWithExistingData(prevScore , score);
            if (!isLarge){
                score.setId(prevScore.getId());
                return repo.save(score);
            }else {
                return prevScore;
            }
        }
    }

    @Override
    public List<GameScore> getAll(Pageable pageable) {
        return repo.getAll(pageable);
    }

    @Override
    public GameScore findByUserId(long id) {

        GameScore score = repo.findByUserID(id);
        Map<String,Object> map = repo.getPosition(score.getId());
        int position = Integer.parseInt(map.get("position").toString());
        score.setId(position);
        return score;
    }
}

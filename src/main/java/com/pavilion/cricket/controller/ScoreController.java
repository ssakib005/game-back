package com.pavilion.cricket.controller;


import com.pavilion.cricket.model.GameScore;
import com.pavilion.cricket.service.imp.ScoreServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreController {

    private static final String PATH = "score";
    private static final String PATH_ADD = PATH + "/add";
    private static final String PATH_GET_ALL = PATH + "/all";
    private static final String PATH_FIND_BY_ID = PATH + "/find/{id}";

    @Autowired
    ScoreServiceImp imp;

    @PostMapping(value = PATH_ADD, consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<GameScore> saveOrUpdate(@RequestBody @Validated GameScore score){
        GameScore score1 = imp.addOrUpdate(score);
        return ResponseEntity.ok(score1);
    }

    @GetMapping(value = PATH_GET_ALL)
    private ResponseEntity<List<GameScore>> getAll(@PageableDefault(page = 0, size = 5)Pageable pageable){
        List<GameScore> gameScores = imp.getAll(pageable);
        return ResponseEntity.ok(gameScores);
    }

    @GetMapping(value = PATH_FIND_BY_ID)
    private ResponseEntity<GameScore> findByUserId(@PathVariable("id") long id){
        return ResponseEntity.ok(imp.findByUserId(id));
    }
    


}

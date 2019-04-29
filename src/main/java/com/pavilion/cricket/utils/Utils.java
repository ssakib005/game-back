package com.pavilion.cricket.utils;

import com.pavilion.cricket.model.GameScore;

public class Utils {


    public static boolean compareWithExistingData(GameScore existingScore, GameScore newScore){

        if (existingScore != null){

            if (existingScore.getScore() >= newScore.getScore()){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }



}

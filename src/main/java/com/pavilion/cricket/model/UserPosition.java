package com.pavilion.cricket.model;

import javax.persistence.Column;

public class UserPosition extends GameScore {

    @Column(name = "position")
    private int position;

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public int getScore() {
        return super.getScore();
    }

    @Override
    public void setScore(int score) {
        super.setScore(score);
    }

    @Override
    public long getUserID() {
        return super.getUserID();
    }

    @Override
    public void setUserID(long userID) {
        super.setUserID(userID);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

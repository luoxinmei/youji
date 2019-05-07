package com.youji.pojo;

public class Elf {
    private Integer elfId;

    private Integer userId;

    private String nickname;

    private Integer experienceValue;

    public Integer getElfId() {
        return elfId;
    }

    public void setElfId(Integer elfId) {
        this.elfId = elfId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getExperienceValue() {
        return experienceValue;
    }

    public void setExperienceValue(Integer experienceValue) {
        this.experienceValue = experienceValue;
    }
}
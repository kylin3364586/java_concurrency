package com.example.mybatis.bean;

import java.time.LocalDateTime;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-06- 15:16:00
 */
public class Person {
    private int id;
    private String name;
    private int score;
    private LocalDateTime createTime;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", createTime=" + createTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}

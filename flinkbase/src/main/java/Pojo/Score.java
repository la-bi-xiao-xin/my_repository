package Pojo;

import lombok.Data;


public class Score {
    int id;
    String name;
    int subjectId;
    Double score;

    public Score(int id, String name, int subjectId, Double score) {
        this.id = id;
        this.name = name;
        this.subjectId = subjectId;
        this.score = score;
    }

    public Score() {}

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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectId=" + subjectId +
                ", score=" + score +
                '}';
    }
}

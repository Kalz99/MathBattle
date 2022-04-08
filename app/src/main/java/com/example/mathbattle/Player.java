package com.example.mathbattle;

public class Player {

    private String name,pmail,ppw;
    private int score,level;
    public Player(String a ,String b,String c,int score,int level){
        this.name=a;
        this.pmail=b;
        this.ppw=c;
        this.score=score;
        this.level=level;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getPmail() {
        return pmail;
    }

    public void setPmail(String pmail) {
        this.pmail = pmail;
    }

    public String getPpw() {
        return ppw;
    }

    public void setPpw(String ppw) {
        this.ppw = ppw;
    }
}

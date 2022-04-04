package com.example.mathbattle;

public class Player {

    private String pname,pmail,ppw;
    private int score,level;
    public Player(String a ,String b,String c,int score,int level){
        this.pname=a;
        this.pmail=b;
        this.ppw=c;
        this.score=score;
        this.level=level;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

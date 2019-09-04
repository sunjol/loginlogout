package com.example.loginlogout;

public class userinform {
    private String name;
    private String password;
    private String uname;
    private Integer score1;
    private Integer score2;
    private Integer score3;

    public userinform() {
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public void setScore3(Integer score3) {
        this.score3 = score3;
    }

    public Integer getScore1() {
        return score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public Integer getScore3() {
        return score3;
    }

    public userinform(String name, String password, String uname, Integer score1, Integer score2, Integer score3) {
        this.name = name;
        this.password = password;
        this.uname = uname;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public String getUname() {
        return uname;
    }

    public String getName() {
        return name;
    }

    public userinform(String name, String password, String uname) {
        this.name = name;
        this.password = password;
        this.uname = uname;
    }
}

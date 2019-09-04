package com.example.loginlogout;

public class ques {
    String qname;
    String op1;
    String op2;
    String op3;
    int ans;
    int qno;

    public ques() {
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public String getQname() {
        return qname;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public int getAns() {
        return ans;
    }
}

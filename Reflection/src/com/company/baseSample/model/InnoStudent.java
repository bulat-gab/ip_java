package com.company.baseSample.model;

public class InnoStudent extends Student {
    public String hymn = "in god we trust";
    protected Integer grade;
    private double scholarship;

    public InnoStudent(String secret,
                       int course,
                       char prefix,
                       String hymn,
                       Integer grade,
                       double scholarship) {
        super(secret, course, prefix);
        this.hymn = hymn;
        this.grade = grade;
        this.scholarship = scholarship;
    }

    public void setScholarship(double newSumm){
        this.scholarship = newSumm;
    }

    protected void updateGrade(int newGrade){
        this.grade = newGrade;
    }

    private void sayScholarship(){
        System.out.println(scholarship);
    }
}

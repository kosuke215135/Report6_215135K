package jp.ac.uryukyu.ie.e215135;

public class Card {
    private int num;
    private String mark;

    public Card(int num, String mark){
        this.num = num;
        this.mark = mark;
    }
    
    public int getNum(){
        return this.num;
    }

    public String getMark(){
        return this.mark;
    }
}
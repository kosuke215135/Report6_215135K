package jp.ac.uryukyu.ie.e215135;

/**
* トランプのカード
*/
public class Card {
    private int num;
    private String mark;

    /**
    * コンストラクタ
    * 数字とマークの情報を得てカードを作成する
    * @param num カードの数字
    * @param mark カードの記号("♡", "♢", "♤", "♧")
    */
    public Card(int num, String mark){
        this.num = num;
        this.mark = mark;
    }

    /**
    * getterメソッド
    * @return カードの数字
    */
    public int getNum(){
        return this.num;
    }

    /**
    * getterメソッド
    * @return カードのマーク
    */
    public String getMark(){
        return this.mark;
    }
}
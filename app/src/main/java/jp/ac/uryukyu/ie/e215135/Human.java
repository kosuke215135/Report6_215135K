package jp.ac.uryukyu.ie.e215135;

import java.util.ArrayList;
/**
* DealerクラスとPlayerクラスに継承させるためのクラス
* 自分の手札を持つことができる
*/
public class Human {
    private ArrayList<Card> cards = new ArrayList<>();

    /**
    * 手札に加える
    * @param card 手札に加えたいカード
    */
    public void setCard(Card card){
        cards.add(card);
    }

    /**
    * 手札の情報を返す
    * @return 手札
    */
    public ArrayList<Card> getCards(){
        return cards;
    }

    
}
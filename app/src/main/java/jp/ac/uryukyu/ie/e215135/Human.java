package jp.ac.uryukyu.ie.e215135;

import java.util.ArrayList;

public class Human {
    private ArrayList<Card> cards = new ArrayList<>();

    public void setCard(Card card){
        cards.add(card);
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    
}
package jp.ac.uryukyu.ie.e215135;
import java.util.ArrayList;
import java.util.Random;

public class Dealer extends Human{
    ArrayList<Card> deck = new ArrayList<>();

    public Dealer(){
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        String[] marks = {"♡", "♢", "♤", "♧"};
        for (int i=0; i < numbers.length; i++){
            for (int j=0; j < marks.length; j++){
                Card card = new Card(numbers[i], marks[j]);
                deck.add(card);
            }
        }
    }

    public void dealCard(Human human){
        Random rand = new Random();
        int randNum = rand.nextInt(deck.size());
        Card handOutCard = deck.get(randNum);
        human.setCard(handOutCard);
        deck.remove(randNum);
    }
}
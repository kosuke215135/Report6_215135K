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

    public int calcOptimumNum(){
        int sum = 0;
        int oneCount = 0;
        for (int i=0; i < this.getCards().size(); i++){
            int cardNum = this.getCards().get(i).getNum();
            if (cardNum == 1){
                oneCount += 1;
            }else if (cardNum > 10){
                sum += 10;
            }else{
                sum += cardNum;
            }
        }
        // Aが出たときの処理(1か11のより良い方をsumとする)
        for (int i=0; i < oneCount; i++){
            int plusOne = sum + 1; 
            int plusEleven = sum + 11;
            int diffPlusOne = 21-plusOne;
            int diffPlusEleven = 21-plusEleven;
            if (diffPlusOne >= 0 && diffPlusEleven >= 0){
                sum = Math.max(plusOne,plusEleven);
            }else if(diffPlusOne < 0 && diffPlusEleven >= 0){
                sum = plusEleven;
            }else if(diffPlusOne >= 0 && diffPlusEleven < 0){
                sum = plusOne;
            }else{
                sum = plusOne;
            }
        }
        return sum;
    }
}
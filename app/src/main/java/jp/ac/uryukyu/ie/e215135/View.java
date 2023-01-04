package jp.ac.uryukyu.ie.e215135;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    public void fieldDisplay(String playerDisplay, String dealerDisplay){
        System.out.println("Dealerの手札");
        System.out.println(dealerDisplay);
        System.out.println("あなたの手札");
        System.out.println(playerDisplay);
    }
    public int questionHitOrStay(){
        System.out.println("番号を選択してください");
        System.out.println("0: カードを1枚引く");
        System.out.println("1: 勝負する");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        if (input == "0"){
            return 0;
        }else if (input == "1"){
            return 1;
        }else{
            System.out.println("入力が間違っています");
            return -100;
        }
    }
    public List<Integer> questionOneOrEleven(Player player){
        List<Integer> ajustA= new ArrayList<Integer>();
        ArrayList<Card> playerCards = player.getCards();
        for (int i=0; i < playerCards.size(); i++){
            Card playerCard = playerCards.get(i); 
            int cardNum = playerCard.getNum();
            if (cardNum == 1){
                System.out.println(i+"番目のAは1と11のどちらとして計算しますか？");
                System.out.println("1: 1として計算する");
                System.out.println("11: 11として計算する");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();
                scanner.close();
                if (input == "11"){
                    ajustA.add(i);
                }
            }
        }
        return ajustA;
    }
    public void winnerDisplay(String winner){
        if (winner == "Player"){
            System.out.println("あなたの勝利です!! おめでとうございます!!");
        }else {
            System.out.println("Dealer側の勝利です。残念でした。。。");
        }
        
    }
}
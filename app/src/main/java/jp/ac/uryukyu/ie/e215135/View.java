package jp.ac.uryukyu.ie.e215135;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* ターミナルに表示し、入力を受け付けるためのクラス
*/
public class View {
    Scanner scanner;

    /**
    * PlayerとDealerの手札を表示する
    * @param playerDisplay 表示させたいPlayerの手札
    * @param dealerDisplay 表示させたいDealerの手札
    */
    public void fieldDisplay(String playerDisplay, String dealerDisplay){
        System.out.println("Dealerの手札");
        System.out.println(dealerDisplay);
        System.out.println("あなたの手札");
        System.out.println(playerDisplay);
    }

    /**
    * Playerの行動を選択させる
    * カードを1枚引くか勝負するかを選択することが可能
    * @return 選択番号(1,2,-100) -100は入力が間違っている場合
    */
    public int questionHitOrStay(){
        System.out.println("番号を選択してください");
        System.out.println("1: カードを1枚引く");
        System.out.println("2: 勝負する");
        scanner = new Scanner(System.in);
        try{
            int input = scanner.nextInt();
            if (!(input == 1 || input == 2)){
                System.out.println("入力が間違っています");
                return -100;
            }else {
                return input;
            }
        } catch(Exception e) {
            System.out.println("数字で入力してください");
            return -100;
        }
    }

    /**
    * Aを1として計算するか,11として計算するか決める
    * @param player Player
    * @return 11として扱うカードのカード番号が入った配列
    */
    public List<Integer> questionOneOrEleven(Player player){
        List<Integer> ajustA= new ArrayList<Integer>();
        ArrayList<Card> playerCards = player.getCards();
        for (int i=0; i < playerCards.size(); i++){
            Card playerCard = playerCards.get(i); 
            int cardNum = playerCard.getNum();
            if (cardNum == 1){
                int cardIndex = i+1;
                System.out.println("左から"+cardIndex+"番目のAは1と11のどちらとして計算しますか？");
                System.out.println("1: 1として計算する");
                System.out.println("11: 11として計算する");
                scanner = new Scanner(System.in);
                try{
                    int input = scanner.nextInt();
                    if (input == 11){
                        ajustA.add(i);
                    }
                    if (input == 11 || input == 1){
                        break;
                    } else {
                        System.out.println("入力が正しくありません");
                        ajustA.add(-100);
                    }
                }catch(Exception e){
                    System.out.println("数字で入力してください");
                    ajustA.add(-100);
                }
            }
        }
        return ajustA;
    }

    /**
    * 勝敗がついたときのコメントを表示する
    * @param winner 勝者
    */
    public void winnerDisplay(String winner){
        if (winner == "Player"){
            System.out.println("あなたの勝利です!! おめでとうございます!!");
        }else {
            System.out.println("Dealer側の勝利です。残念でした。。。");
        }
        
    }
}
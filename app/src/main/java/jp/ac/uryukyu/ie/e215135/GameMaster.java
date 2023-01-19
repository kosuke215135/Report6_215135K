package jp.ac.uryukyu.ie.e215135;
import java.util.List;
import java.util.ArrayList;

public class GameMaster {
    private Player player;
    private Dealer dealer;
    private View view;
    private boolean continueGame = true;

    public GameMaster(Player player, Dealer dealer, View view){
        this.player = player;
        this.dealer = dealer;
        this.view = view;
        //最初のカードを配る
        for (int i=0; i < 2; i++){
            this.dealer.dealCard(player);
        }
        for (int i=0; i < 2; i++){
            this.dealer.dealCard(dealer);
        }
    }
    //test用のコンストラクタ(カードをtest側で指定できるようにするため)
    public GameMaster(Player player, Dealer dealer, View view, boolean test){
        this.player = player;
        this.dealer = dealer;
        this.view = view;
        //最初のカードを配る
        // for (int i=0; i < 2; i++){
        //     this.dealer.dealCard(player);
        // }
        // for (int i=0; i < 2; i++){
        //     this.dealer.dealCard(dealer);
        // }
    }

    //カードを引いて,21を越えたら終わり
    public void checkNumOver(){
        int playerNum = player.calcMinNum();
        if (playerNum > 21){
            System.out.println("21を超えてしまいました");
            view.winnerDisplay("Dealer");
            String playerDisplay = getCardInformation(player);
            String dealerDisplay = getCardInformation(dealer);
            this.view.fieldDisplay(playerDisplay, dealerDisplay);
            continueGame = false;
        }
    }
    // playerとdealerの数字を比較する
    public void checkMatch(List<Integer> chooseOneToEleven){
        int playerNum = player.calcNum(chooseOneToEleven);
        int dealerNum = dealer.calcOptimumNum();
        if (playerNum > 21){
            view.winnerDisplay("Dealer");
        }else{
            int diffplayer = 21 - playerNum;
            int diffdealer = 21 - dealerNum;
            if (diffplayer <= diffdealer){
                view.winnerDisplay("Player");
            }else{
                view.winnerDisplay("Dealer");
            }
        }
        String playerDisplay = getCardInformation(player);
        String dealerDisplay = getCardInformation(dealer);
        this.view.fieldDisplay(playerDisplay, dealerDisplay);
        continueGame = false;
    }
    public String getCardInformation(Human human){
        ArrayList<Card> humanCards = human.getCards();
        String humanCardsDisplay = ""; 
        for (int i=0; i < humanCards.size(); i++){
            Card card = humanCards.get(i);
            int cardNum = card.getNum();
            Integer cardNumInteger = Integer.valueOf(cardNum);
            String cardNumString;
            if (cardNumInteger == 1) {
                cardNumString = "A";
            } else if (cardNumInteger == 11) {
                cardNumString = "J";
            } else if (cardNumInteger == 12) {
                cardNumString = "Q";
            } else if (cardNumInteger == 13) {
                cardNumString = "K";
            }else{
                cardNumString = cardNumInteger.toString();
            }
            String cardMark = card.getMark();
            humanCardsDisplay += cardNumString+cardMark+" ";
        }
        return humanCardsDisplay;
    }
    public String getDealerCardInformation(Dealer dealer){
        ArrayList<Card> dealerCards = dealer.getCards();
        String dealerDisplay = "?? "; 
        Card card = dealerCards.get(1);
        int cardNum = card.getNum();
        Integer cardNumInteger = Integer.valueOf(cardNum);
        String cardNumString = cardNumInteger.toString();
        String cardMark = card.getMark();
        dealerDisplay += cardNumString+cardMark+" ";
        return dealerDisplay;
    }

    public void gameProgress(){
        while (continueGame){
            String playerDisplay = getCardInformation(player);
            String dealerDisplay = getDealerCardInformation(dealer);
            this.view.fieldDisplay(playerDisplay, dealerDisplay);
            int HitOrStay;
            //questionHitOrStay()で正しい入力があったか確認する
            do {
                HitOrStay = this.view.questionHitOrStay();
            }while(HitOrStay == -100);
            if (HitOrStay == 0){
                this.dealer.dealCard(this.player);
                checkNumOver();
            }else{
                List<Integer> chooseOneToEleven;
                int countNotCorrectInput;
                //questionOneOrEleven(this.player)で正しい入力があったか確認する
                do{
                    countNotCorrectInput = 0;
                    chooseOneToEleven = view.questionOneOrEleven(this.player);
                    for (int i=0; i < chooseOneToEleven.size(); i++){
                        int checkNegative = chooseOneToEleven.get(i);
                        if (checkNegative == -100){
                            countNotCorrectInput += 1;
                        }
                    }
                }while(countNotCorrectInput > 0);

                checkMatch(chooseOneToEleven);
            }
        }
    }
    //テスト用
    public boolean getContinueGame(){
        return this.continueGame;
    }
}
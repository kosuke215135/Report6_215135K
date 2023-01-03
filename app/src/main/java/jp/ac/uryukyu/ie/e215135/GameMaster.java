package jp.ac.uryukyu.ie.e215135;
import java.util.List;


public class GameMaster {
    private Player player;
    private Dealer dealer;
    private View view;
    private boolean continueGame = true;

    public GameMaster(Player player, Dealer dealer){
        this.player = player;
        this.dealer = dealer;
    }
    //カードを引いて,21を越えたら終わり
    public void checkMatch(){
        int playerNum = player.calcMinNum();
        if (playerNum > 21){
            view.winnerDisplay("Dealer");
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
            if (diffplayer >= diffdealer){
                view.winnerDisplay("Player");
            }else{
                view.winnerDisplay("Dealer");
            }
        }
    }
    public void gameProgress(){
        while (continueGame){
            this.view.fieldDisplay();
            int HitOrStay = this.view.questionHitOrStay();
            if (HitOrStay == 0){
                this.dealer.dealCard(this.player);
                checkMatch();
            }else{
                List<Integer> chooseOneToEleven = view.questionOneOrEleven();
                checkMatch(chooseOneToEleven);
                continueGame = false;
            }
        }

    }
}
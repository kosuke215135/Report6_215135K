package jp.ac.uryukyu.ie.e215135;
import java.util.List;

/**
* Playerのクラス
*/
public class Player extends Human{

    /**
    * カードの合計数値を計算する
    * Aは1か11かどちらかを選ばせて計算する
    * @param chooseOneToEleven 11として扱うカードのカード番号が入った配列
    * @return Playerの点数
    */
    public int calcNum(List<Integer> chooseOneToEleven){
        int sum = 0;
        for (int i=0; i < this.getCards().size(); i++){
            int cardNum = this.getCards().get(i).getNum();
            if (chooseOneToEleven.contains(i)){
                sum += 11;
            }else if (cardNum > 10){
                sum += 10;
            }else{
                sum += cardNum;
            }
        }
        return sum;
    }
    
    /**
    * カードの合計値の最小を求める
    * カードを引いたときに21を越えたらNGなため
    * @return Playerの点数の最小値
    */
    public int calcMinNum(){
        int sum = 0;
        for (int i=0; i < this.getCards().size(); i++){
            int cardNum = this.getCards().get(i).getNum();
            if (cardNum > 10){
                sum += 10;
            }else{
                sum += cardNum;
            }
        }
        return sum;
    }
}
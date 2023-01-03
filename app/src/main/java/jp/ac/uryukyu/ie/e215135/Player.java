package jp.ac.uryukyu.ie.e215135;
import java.util.List;

public class Player extends Human{

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
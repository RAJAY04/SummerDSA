package Greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,5,10,5,10,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
    public static boolean lemonadeChange(int[] bills) {
        int[] change = {0,0};//0th index holds 5, 1st index holds 10
        for(int num : bills){
            if(num == 5){
                change[0]++;
            }else{
                if(num == 10){
                    if(change[0] == 0){
                        return false;
                    }else{
                        change[0]--;
                        change[1]++;
                    }
                }else{
                    if(change[0] == 0)return false;
                    else if(change[1] > 0 && change[0] > 0){
                        change[1]--;
                        change[0]--;
                    }else if(change[1] == 0 && change[0] > 2){
                        change[0] -=3;
                    }else return false;
                }
            }

        }
        return true;
    }
}

package karate.chops.general;
import java.util.*;
public class MinNumberOfCoins {
	public static void main(String[] args) {
		System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));
	}
	public static int coinChange(int[] coins, int amount) {
        int noOfCoins = 0;
        int i = 0;
        Integer[] myCoins = new Integer[coins.length];
        for(int coin : coins)
            myCoins[i++] = coin;
        Arrays.sort(myCoins,Collections.reverseOrder());
        for(int coin : myCoins) {
            while(amount >= coin) {
                amount-=coin;
                noOfCoins++;
            }
        }
        if(amount == 0)
            return noOfCoins;
        else
            return -1;
    }
}

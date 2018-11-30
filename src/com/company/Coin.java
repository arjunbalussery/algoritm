package com.company;

public class Coin {
    private static int[] change = {2,5};
    public static int coinChange(int n) {
        if(n < 0) {
            return 0;
        }
        if(n==0) {
            return 1;
        }
        return coinChange(n-2)+coinChange(n-5);
    }

    public  static int coinCh(int n,int index) {
        int nCoins = 0;
        if(n < 0) {
            return 0;
        }
        if(n==0) {
            return 1;
        }
        for(int coin=index; coin<change.length; coin++)
        {
            nCoins += coinCh(n-change[coin],coin);
        }
        return nCoins;
    }

    public  static int coinChDP(int n) {
        int [] result = new int[n+1];
        result[0]=1;
        return coinChDP(n,0,result);
    }
    public  static int coinChDP(int n,int index,int[] result) {
        int nCoins = 0;
        if(n < 0) {
            return 0;
        }
        if(result[n] > 0) {
            return result[n];
        }
        for(int coin=index; coin<change.length; coin++)
        {
            nCoins += coinChDP(n-change[coin],coin,result);
        }
        return nCoins;
    }

    public  static int pureDP(int n){
        int[] amount = new int[n+1];
        amount[0]=1;
        for(int i=0;i<change.length;i++) {
            for (int j=1;j<n+1;j++) {
                if(j>= change[i]) {
                    amount[j]=amount[j]+amount[j-change[i]];
                }
            }
        }
        return amount[n];

    }
}

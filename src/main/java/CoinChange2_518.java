import java.util.HashMap;
import java.util.Map;

public class CoinChange2_518 {


    public int change(int amount, int[] coins) {
        Map<Integer, Integer> mem = new HashMap<>();

        return recurChange(amount, coins.length, coins, mem);

    }

    public int recurChange(int amount, int n, int[] coins, Map<Integer, Integer> mem) {
        if(amount ==0) return 1;
        if(amount<0 || n == 0) return 0;
        int val;
        if(mem.containsKey(amount)){
            val=mem.get(amount);
        }else{
            int val1, val2;
            val1=recurChange(amount-coins[n-1],n,coins,mem);
            val2=recurChange(amount, n-1, coins, mem);
            val=val1+val2;
            mem.put(amount,val);
        }

        return  val;
    }


    public static void main(String[] args) {
        CoinChange2_518 coin = new CoinChange2_518();
        System.out.println(coin.change(5, new int[]{1, 2, 5}));
    }
}

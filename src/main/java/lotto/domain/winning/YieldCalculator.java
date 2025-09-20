package lotto.domain.winning;

import java.util.EnumMap;

public class YieldCalculator {

    private final EnumMap<Rank,Integer> rankGroup;
    private final int quantity;

    public YieldCalculator(EnumMap<Rank, Integer> rankGroup,int quantity) {
        this.rankGroup = rankGroup;
        this.quantity = quantity;
    }

    public double calculate(){
        long sum = rankGroup.entrySet().stream()
                .mapToLong(e -> (long) e.getKey().getPrize() * e.getValue())
                .sum();
        return divideSum(sum,quantity);
    }

    private double divideSum(long sum,int quantity){
        return (double) sum /(quantity*1000)*100;
    }

}

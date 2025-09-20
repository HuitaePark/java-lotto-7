package lotto.domain.winning;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import lotto.application.dto.LottoWinningResult;

public class WinningReport {

    private final List<Rank> winningList;
    private final EnumMap<Rank,Integer> rankGroup;

    private WinningReport(List<Rank> winningList,EnumMap<Rank,Integer> rankGroup) {
        this.winningList = winningList;
        this.rankGroup = rankGroup;
    }

    public static WinningReport of(List<Rank> winningList){
        EnumMap<Rank,Integer> rankGroup = Rank.initialize();

        for(Rank rank : winningList){
            rankGroup.put(rank,rankGroup.getOrDefault(rank,0)+1);
        }

        return new WinningReport(winningList,rankGroup);
    }


    public LottoWinningResult summarize(int quantity) {
        StringBuilder rankResult = printResult();
        removeLineBreak(rankResult);

        YieldCalculator calculator = new YieldCalculator(rankGroup, quantity);
        double percent = calculator.calculate();

        return new LottoWinningResult(rankResult, percent);
    }

    private List<Rank> getOutputList(){
        return rankGroup.keySet().stream().sorted(Comparator.reverseOrder()).toList();
    }

    private StringBuilder printResult(){
        List<Rank> rankList = getOutputList();
        StringBuilder rankResult = new StringBuilder();

        rankList.forEach(rank -> {
            if (rank != Rank.MISS) {
                rankResult.append(rank.getMessage(Math.toIntExact(rankGroup.get(rank)))).append(System.lineSeparator());
            }
        });

        return rankResult;
    }

    private void removeLineBreak(StringBuilder rankResult){
        if (!rankResult.isEmpty()) {
            rankResult.delete(rankResult.length() - System.lineSeparator().length(), rankResult.length());
        }
    }
}

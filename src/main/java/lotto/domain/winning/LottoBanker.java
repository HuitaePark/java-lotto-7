package lotto.domain.winning;

import java.util.List;
import lotto.application.dto.LottoWinningResult;
import lotto.application.dto.SubmittedEntries;
import lotto.domain.purchase.Lotto;
import lotto.domain.purchase.Lottos;

public class LottoBanker {

    private final List<Lotto> lottos;
    private final int quantity;
    private final Winners winners;

    public LottoBanker(Lottos lottos, SubmittedEntries submittedEntries) {
        this.lottos = lottos.getLottos();
        this.winners = new Winners(submittedEntries,lottos.getLottos());
        this.quantity = this. lottos.size();
    }

    public LottoWinningResult settlingWinnings(){
        List<Rank> winningList = extractingRank(winners);
        return calculateRank(winningList);
    }

    private  LottoWinningResult calculateRank(List<Rank> winningList){
        WinningReport report = WinningReport.of(winningList);
        return report.summarize(quantity);
    }

    private List<Rank> extractingRank(Winners winners){
        return winners.getWinningList().stream().map(Winner::getRank).toList();
    }

}

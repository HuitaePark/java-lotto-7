package lotto.domain.winning;


import static lotto.domain.common.LottoConstant.SECOND_RANK_NUMBER;
import static lotto.domain.common.LottoConstant.ZERO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.application.dto.SubmittedEntries;
import lotto.domain.entry.BonusNumber;
import lotto.domain.entry.EntryNumber;
import lotto.domain.purchase.Lotto;
import lotto.domain.purchase.Lottos;

public class LottoBanker {

    private final List<Lotto> lottos;
    private final List<EntryNumber> entryNumbers;
    private final BonusNumber bonusNumber;
    private final int quantity;

    public LottoBanker(Lottos lottos, SubmittedEntries submittedEntries) {
        this.lottos = lottos.getLottos();
        this.entryNumbers = submittedEntries.entryNumbers();
        this.bonusNumber = submittedEntries.bonusNumber();
        this.quantity = this.lottos.size();
    }

    public StringBuilder settlingWinnings(){
        List<Rank> winningList = new ArrayList<>();

        for(Lotto lotto : lottos){
            int count = ZERO;
            for(Integer i : lotto.getNumbers()){
                if(entryNumbers.stream().map(EntryNumber::getEntryNumber).toList().contains(i)){
                    count++;
                }
            }

            if(count==SECOND_RANK_NUMBER && lotto.getNumbers().contains(bonusNumber.getBonusNumber())){
                winningList.add(Rank.of(count,true));
                continue;
            }

            winningList.add(Rank.of(count,false));
        }


        return calculateRank(winningList);
    }

    private StringBuilder calculateRank(List<Rank> winningList){
        StringBuilder rankResult = new StringBuilder();
        EnumMap<Rank,Integer> rankGroup = Rank.initialize();

        for(Rank rank : winningList){
            rankGroup.put(rank,rankGroup.getOrDefault(rank,0)+1);
        }

        List<Rank> reversedRanks = new ArrayList<>(rankGroup.keySet());
        Collections.reverse(reversedRanks); // enum 선언 순서 역순
        reversedRanks.forEach(rank -> {
            if (rank != Rank.MISS) {
                rankResult.append(rank.getMessage(Math.toIntExact(rankGroup.get(rank)))).append(System.lineSeparator());
            }
        });

        return rankResult;
    }
}

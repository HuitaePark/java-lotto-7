package lotto.domain.winning;

import static lotto.domain.common.LottoConstant.SECOND_RANK_NUMBER;

import java.util.ArrayList;
import java.util.List;
import lotto.application.dto.SubmittedEntries;
import lotto.domain.entry.BonusNumber;
import lotto.domain.entry.EntryNumber;
import lotto.domain.purchase.Lotto;

public class Winners {

    private final List<Winner> winningList;
    private final List<Integer> entryNumbers;
    private final BonusNumber bonusNumber;

    public Winners(SubmittedEntries submittedEntries, List<Lotto> lottos) {
        this.entryNumbers = dismantle(submittedEntries.entryNumbers());
        this.bonusNumber = submittedEntries.bonusNumber();
        this.winningList = settlingWinnings(lottos);
    }

    public List<Winner> getWinningList() {
        return winningList;
    }

    private List<Winner> settlingWinnings(List<Lotto> lottos) {
        List<Winner> resolvedWinners = new ArrayList<>();

        for (Lotto lotto : lottos) {
            int count = findEntryNumber(lotto);

            if (isSecondRank(lotto, count)) {
                resolvedWinners.add(new Winner(count, true));
                continue;
            }
            resolvedWinners.add(new Winner(count, false));
        }
        return resolvedWinners;
    }

    private int findEntryNumber(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this::isEqualsEntryNumber)
                .count();
    }

    private List<Integer> dismantle(List<EntryNumber> entryNumbers){
        return entryNumbers.stream().map(EntryNumber::getEntryNumber).toList();
    }

    private boolean isEqualsEntryNumber(int number) {
        return entryNumbers.contains(number);
    }

    private boolean isSecondRank(Lotto lotto, int count) {
        return count == SECOND_RANK_NUMBER && lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}

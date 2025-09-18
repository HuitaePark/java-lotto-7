package lotto.application.service;

import lotto.application.dto.LottoWinningResult;
import lotto.application.dto.SubmittedEntries;
import lotto.domain.entry.EntryNumbers;
import lotto.domain.purchase.LottoCashier;
import lotto.domain.purchase.Lottos;
import lotto.domain.purchase.PurchaseAmount;
import lotto.application.dto.LottoPurchaseResult;
import lotto.domain.winning.LottoBanker;

public class LottoService {

    public LottoPurchaseResult purchaseLottos(String input){
        PurchaseAmount purchaseAmount = PurchaseAmount.forInputElement(input);
        LottoCashier lottoCashier = LottoCashier.forPurchaseAmount(purchaseAmount);

        return new LottoPurchaseResult(lottoCashier.provideLottos(),lottoCashier.getTicketCount());
    }

    public SubmittedEntries submitEntryNumbers(String[] entryInput, String bonusInput){
        EntryNumbers entryNumbers = EntryNumbers.entry(entryInput,bonusInput);
        return new SubmittedEntries(entryNumbers.getEntryNumbers(),entryNumbers.getBonusNumber());
    }

    public LottoWinningResult getWinningResult(Lottos lottos, SubmittedEntries submittedEntries) {
        LottoBanker lottoBanker = new LottoBanker(lottos,submittedEntries);
        return lottoBanker.settlingWinnings();
    }
}

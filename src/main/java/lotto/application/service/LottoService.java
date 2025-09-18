package lotto.application.service;

import lotto.application.dto.SubmittedEntries;
import lotto.domain.entry.EntryNumbers;
import lotto.domain.purchase.LottoCashier;
import lotto.domain.purchase.PurchaseAmount;
import lotto.application.dto.LottoPurchaseResult;

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

}

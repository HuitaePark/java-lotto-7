package lotto.service;

import lotto.domain.LottoCashier;
import lotto.ui.LottoPrinter;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.dto.LottoPurchaseResult;

public class LottoService {

    public LottoPurchaseResult purchaseLottos(String input){
        PurchaseAmount purchaseAmount = PurchaseAmount.forInputElement(input);
        LottoCashier lottoCashier = LottoCashier.forPurchaseAmount(purchaseAmount);

        return new LottoPurchaseResult(lottoCashier.provideLottos(),lottoCashier.getTicketCount());
    }
}

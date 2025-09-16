package lotto.controller;

import lotto.domain.LottoCashier;
import lotto.domain.PurchaseAmount;
import lotto.ui.InputHandler;
import lotto.ui.OutputView;

public class LottoController {

    private final InputHandler inputHandler;

    public LottoController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void startLottery(){
        String input = inputHandler.inputText();
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);
        giveLottoCashier(purchaseAmount);
    }
    private void giveLottoCashier(PurchaseAmount purchaseAmount){
        LottoCashier lottoCashier = new LottoCashier(purchaseAmount);
        int lottoCount = lottoCashier.calculateLottoCount();
        reportLottoCount(lottoCount);
    }
    private void reportLottoCount(int lottoCount){
        OutputView.printLottoCount(lottoCount);
    }
}

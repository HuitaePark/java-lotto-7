package lotto.controller;

import lotto.domain.LottoCashier;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.ui.InputHandler;
import lotto.ui.OutputView;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputView outputView;

    public LottoController(InputHandler inputHandler, OutputView outputView) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
    }

    public void startLottery(){
        String input = inputHandler.inputText();
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);

        giveToLottoCashier(purchaseAmount);
    }
    private void giveToLottoCashier(LottoMachine lottoMachine,PurchaseAmount purchaseAmount){
        LottoCashier lottoCashier = new LottoCashier(lottoMachine,purchaseAmount);
    }
    private void reportLottoCount(int lottoCount){
        outputView.printLottoCount(lottoCount);
    }
}

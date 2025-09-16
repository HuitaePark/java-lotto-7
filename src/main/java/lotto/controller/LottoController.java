package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.global.util.InputPaser;
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
        PurchaseAmount purchaseAmount = InputPaser.toPurchaseAmount(input);
    }
}

package lotto.controller;

import lotto.domain.LottoCashier;
import lotto.domain.LottoPrinter;
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

    public Lottos startLottery(){
        outputView.printStartMessage();

        String input = inputHandler.inputText();
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);
        LottoCashier lottoCashier = LottoCashier.forPurchaseAmount(purchaseAmount);
        reportLottoCount(lottoCashier.getTicketCount());

        Lottos lottos = lottoCashier.provideLottos();

        String printList = LottoPrinter.printLottoList(lottos);
        outputView.printLottoList(printList);

        return lottos;
    }

    private void reportLottoCount(int lottoCount){
        outputView.printLottoCount(lottoCount);
    }
}

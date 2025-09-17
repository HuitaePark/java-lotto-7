package lotto.controller;

import lotto.domain.LottoCashier;
import lotto.domain.LottoPrinter;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.ui.InputHandler;
import lotto.ui.OutputView;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputView outputView;
    private final LottoService lottoService;

    private LottoController(InputHandler inputHandler, OutputView outputView,LottoService lottoService) {
        this.inputHandler = inputHandler;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public static LottoController initializeController(){
        InputHandler inputHandler = new InputHandler();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        return new LottoController(inputHandler,outputView,lottoService);
    }

    public Lottos buyLotteryTicket(){
        outputView.printStartMessage();

        String input = inputHandler.inputText();
        PurchaseAmount purchaseAmount = PurchaseAmount.forInputElement(input);
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

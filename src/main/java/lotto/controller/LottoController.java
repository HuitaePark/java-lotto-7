package lotto.controller;

import lotto.domain.Lottos;
import lotto.dto.LottoPurchaseResult;
import lotto.service.LottoService;
import lotto.ui.InputHandler;
import lotto.ui.LottoPrinter;
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

    public static LottoController createController(){
        InputHandler inputHandler = new InputHandler();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();
        return new LottoController(inputHandler,outputView,lottoService);
    }

    public Lottos buyLotteryTicket(){
        outputView.printStartMessage();

        String input = inputHandler.inputText();
        LottoPurchaseResult result = lottoService.purchaseLottos(input);
        reportLottoCount(result.count());

        Lottos lottos = result.lottos();
        String printList = LottoPrinter.printLottoList(lottos);
        outputView.printLottoList(printList);

        return lottos;
    }

    private void reportLottoCount(int lottoCount){
        outputView.printLottoCount(lottoCount);
    }
}

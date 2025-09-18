package lotto.presentation.controller;

import static lotto.presentation.adapter.StringConverter.convertStringArray;

import lotto.application.dto.SubmittedEntries;
import lotto.domain.purchase.Lottos;
import lotto.application.dto.LottoPurchaseResult;
import lotto.application.service.LottoService;
import lotto.presentation.adapter.LottoPrinter;
import lotto.presentation.ui.InputHandler;

import lotto.presentation.ui.OutputView;

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

    public SubmittedEntries enterTheLottery(){
        outputView.printEntryMessage();
        String[] entryInput = convertStringArray(inputHandler.inputText());

        outputView.printBonusMessage();
        String bonusInput = inputHandler.inputText();

        return lottoService.submitEntryNumbers(entryInput,bonusInput);
    }

    public void viewWinningResult(Lottos lottos, SubmittedEntries submittedEntries){
        outputView.printResultMessage();
        StringBuilder statics = lottoService.getWinningResult(lottos,submittedEntries);
        outputView.printWinningMessage(statics);

        calculateYield();
    }

    private void calculateYield(){

    }

    private void reportLottoCount(int lottoCount){
        outputView.printLottoCount(lottoCount);
    }
}

package lotto.presentation.controller;

import static lotto.presentation.adapter.StringConverter.convertStringArray;

import lotto.application.dto.LottoWinningResult;
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
        LottoPurchaseResult result = inputPurchaseLottos();
        reportLottoCount(result.count());

        Lottos lottos = result.lottos();
        String printList = LottoPrinter.printLottoList(lottos);
        outputView.printLottoList(printList);

        return lottos;
    }

    private LottoPurchaseResult inputPurchaseLottos(){
        while(true) {
            try {
                outputView.printStartMessage();
                String input = inputHandler.inputText();
                return lottoService.purchaseLottos(input);
            }catch (IllegalArgumentException exception){
                outputView.printErrorMessage(exception);
            }
        }
    }

    public SubmittedEntries enterTheLottery(){
        String[] entryInput = inputEntrys();
        SubmittedEntries submittedEntries = inputBonus(entryInput);

        return submittedEntries;
    }

    private String[] inputEntrys(){
        while(true) {
            try {
                outputView.printEntryMessage();
                String input = inputHandler.inputText();
                return convertStringArray(input);
            }catch (IllegalArgumentException exception){
                outputView.printErrorMessage(exception);
            }
        }
    }

    private SubmittedEntries inputBonus(String[] entryInput){
        while(true) {
            try {
                outputView.printBonusMessage();
                String bonusInput = inputHandler.inputText();
                return lottoService.submitEntryNumbers(entryInput,bonusInput);
            }catch (IllegalArgumentException exception){
                outputView.printErrorMessage(exception);
            }
        }
    }

    public void viewWinningResult(Lottos lottos, SubmittedEntries submittedEntries){
        outputView.printResultMessage();
        LottoWinningResult statics = lottoService.getWinningResult(lottos,submittedEntries);
        outputView.printWinningMessage(statics.resultText());

        calculateYield(statics.percent());
        inputHandler.inputClose();
    }

    private void calculateYield(double percent){
        outputView.printCalculateMessage(percent);
    }

    private void reportLottoCount(int lottoCount){
        outputView.printLottoCount(lottoCount);
    }
}

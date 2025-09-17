package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.ui.InputHandler;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputView outputView = new OutputView();

        LottoController lottoController = new LottoController(inputHandler,outputView);
        Lottos lottos = lottoController.buyLotteryTicket();

    }
}
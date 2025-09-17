package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottos;
import lotto.ui.InputHandler;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.createController();
        Lottos lottos = lottoController.buyLotteryTicket();


    }
}
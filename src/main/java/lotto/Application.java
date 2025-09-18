package lotto;

import lotto.application.dto.SubmittedEntries;
import lotto.domain.purchase.Lottos;
import lotto.presentation.controller.LottoController;


public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.createController();

        Lottos lottos = lottoController.buyLotteryTicket();

        SubmittedEntries submittedEntries = lottoController.enterTheLottery();

        lottoController.viewWinningResult(lottos,submittedEntries);
    }
}
package lotto.ui;

import lotto.global.constant.LottoInfoMessage;

public class OutputView {

    public void printStartMessage(){
        System.out.println(LottoInfoMessage.LOTTO_START_MESSAGE);
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(LottoInfoMessage.LOTTO_PURCHASED_MESSAGE.getMessage(lottoCount));
    }

}

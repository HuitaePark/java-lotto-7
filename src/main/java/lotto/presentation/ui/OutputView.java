package lotto.presentation.ui;

import lotto.domain.winning.Rank;

public class OutputView {

    public void printStartMessage(){
        System.out.println(LottoInfoMessage.LOTTO_START_MESSAGE);
    }

    public void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(LottoInfoMessage.LOTTO_PURCHASED_MESSAGE.getMessage(lottoCount));
    }

    public void printLottoList(String printList){
        System.out.println(printList);
    }

    public void printEntryMessage(){
        System.out.println();
        System.out.println(LottoInfoMessage.LOTTO_ENTRY_MESSAGE);
    }

    public void printBonusMessage(){
        System.out.println();
        System.out.println(LottoInfoMessage.LOTTO_BONUS_MESSAGE);
    }

    public void printResultMessage(){
        System.out.println();
        System.out.println(LottoInfoMessage.LOTTO_RESULT_MESSAGE);
    }

    public void printWinningMessage(StringBuilder statics){
        System.out.println(statics);
    }

    public void printCalculateMessage(double percent){
        System.out.print(LottoInfoMessage.LOTTO_CALCULATE_MESSAGE.getMessage(percent));
    }

    public void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
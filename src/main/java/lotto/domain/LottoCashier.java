package lotto.domain;

import lotto.global.error.ErrorCode;
import lotto.global.error.exception.PurchaseIllegalArgumentException;

public class LottoCashier {

    private final PurchaseAmount purchaseAmount;
    private int ticketCount = 0;

    private LottoCashier(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.ticketCount = calculateLottoCount();
    }

    public static LottoCashier forPurchaseAmount(PurchaseAmount purchaseAmount){
        validateDivisibleBy(purchaseAmount.getAmount());
        return new LottoCashier(purchaseAmount);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public Lottos provideLottos(){
        return getLotto();
    }

    private int calculateLottoCount(){
        return purchaseAmount.getAmount()/1000;
    }

    private Lottos getLotto(){
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.collectLotto(calculateLottoCount());
    }

    private static void validateDivisibleBy(int amount){
        if(0 != amount%1000){
            throw new PurchaseIllegalArgumentException(ErrorCode.INVALID_UNIT);
        }
    }

}

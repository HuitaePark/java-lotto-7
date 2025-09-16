package lotto.domain;

public class LottoCashier {

    private final PurchaseAmount purchaseAmount;
    private int ticketCount = 0;

    private LottoCashier(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.ticketCount = calculateLottoCount();
    }

    public static LottoCashier forPurchaseAmount(PurchaseAmount purchaseAmount){
        return new LottoCashier(purchaseAmount);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public Lottos provideLottos(){
        return getLotto();
    }

    private int calculateLottoCount(){
        int amount = countPurchaseAmount(this.purchaseAmount);
        return amount/1000;
    }

    private Lottos getLotto(){
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.collectLotto(calculateLottoCount());
    }

    private int countPurchaseAmount(PurchaseAmount purchaseAmount){
        return purchaseAmount.getAmount();
    }

}

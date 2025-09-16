package lotto.domain;

public class LottoCashier {

    private final PurchaseAmount purchaseAmount;

    public LottoCashier(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int calculateLottoCount(){
        int amount = countPurchaseAmount(this.purchaseAmount);
        return amount/1000;
    }

    private int countPurchaseAmount(PurchaseAmount purchaseAmount){
        return purchaseAmount.getAmount();
    }
}

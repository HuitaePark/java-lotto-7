package lotto.domain;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(String element) {
        int amount = parseToInt(element);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private int parseToInt(String element){
        return Integer.parseInt(element);
    }
}

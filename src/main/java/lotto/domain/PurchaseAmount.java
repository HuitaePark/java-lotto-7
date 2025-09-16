package lotto.domain;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmount forInputElement(String element){
        int amount = parseToInt(element);
        return new PurchaseAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    private static int parseToInt(String element){
        return Integer.parseInt(element);
    }
}

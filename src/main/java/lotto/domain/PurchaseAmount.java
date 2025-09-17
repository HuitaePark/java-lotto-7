package lotto.domain;

import lotto.global.error.ErrorCode;
import lotto.global.error.exception.PurchaseIllegalArgumentException;

public class PurchaseAmount {

    private final int amount;

    public PurchaseAmount(int amount) {
        this.amount = amount;
    }

    public static PurchaseAmount forInputElement(String element){
        validateNumberFomat(element);
        int amount = parseToInt(element);
        return new PurchaseAmount(amount);
    }

    public int getAmount() {
        return amount;
    }
    private static void validateNumberFomat(String element){
        if(!element.matches("\\d+")){
            throw new PurchaseIllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT);
        }
    }

    private static int parseToInt(String element){
        return Integer.parseInt(element);
    }
}

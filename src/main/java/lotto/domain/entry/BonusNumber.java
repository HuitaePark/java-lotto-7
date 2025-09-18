package lotto.domain.entry;

import lotto.domain.common.EntryValidator;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(String entryBonusNumber) {
        this.bonusNumber = mapToInteger(entryBonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static BonusNumber bonusEntry(String entry){
        EntryValidator.validate(entry);
        return new BonusNumber(entry);
    }

    private int mapToInteger(String element){
        return Integer.parseInt(element);
    }
}

package lotto.domain.entry;

import lotto.domain.common.EntryValidator;

public class EntryNumber {
    private final int entryNumber;

    private EntryNumber(String entry) {
        this.entryNumber = mapToInteger(entry);
    }

    public static EntryNumber entry(String entry){
        EntryValidator.validate(entry);
        return new EntryNumber(entry);
    }

    public int getEntryNumber() {
        return entryNumber;
    }

    private int mapToInteger(String element){
        return Integer.parseInt(element);
    }

}

package lotto.domain.entry;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.common.EntryValidator;

public class EntryNumbers {

    private final List<EntryNumber> entryNumbers;
    private final BonusNumber bonusNumber;

    private EntryNumbers(List<EntryNumber> entryNumber,BonusNumber bonusNumber) {
        this.entryNumbers = entryNumber;
        this.bonusNumber = bonusNumber;
    }

    public static EntryNumbers entry(String[] numberArr,String entryBonusNumber){
        EntryValidator.validate(numberArr);
        List<EntryNumber> entryNumbers = new ArrayList<>();

        for(String entry : numberArr){
            entryNumbers.add(EntryNumber.entry(entry));
        }

        BonusNumber bonusNumber = BonusNumber.bonusEntry(entryBonusNumber);

        return new EntryNumbers(entryNumbers,bonusNumber);
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }

    public List<EntryNumber> getEntryNumbers() {
        return unmodifiableList(entryNumbers);
    }

}

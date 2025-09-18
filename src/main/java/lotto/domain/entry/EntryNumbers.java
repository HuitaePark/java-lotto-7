package lotto.domain.entry;

import static lotto.domain.common.LottoConstant.LOTTO_COUNT_NUMBER;
import static lotto.domain.common.error.ErrorCode.INVALID_LOTTO_SIZE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.common.error.exception.LottoIllegalArgumentException;

public class EntryNumbers {

    private final List<EntryNumber> entryNumbers;
    private final BonusNumber bonusNumber;

    private EntryNumbers(List<EntryNumber> entryNumber,BonusNumber bonusNumber) {
        this.entryNumbers = entryNumber;
        this.bonusNumber = bonusNumber;
    }

    public static EntryNumbers entry(String[] numberArr,String entryBonusNumber){
        validate(numberArr);
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
        return entryNumbers;
    }

    private static void validate(String[] numberArr){
        validateLottoDistinct(numberArr);
        validateEntrySize(numberArr);
    }

    private static void validateLottoDistinct(String[] numberArr){
        String[] mapArr = distinctArr(numberArr);
        if(mapArr.length!=LOTTO_COUNT_NUMBER){
            throw new LottoIllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private static void validateEntrySize(String[] numberArr) {
        if(numberArr.length!=LOTTO_COUNT_NUMBER){
            throw new LottoIllegalArgumentException(INVALID_LOTTO_SIZE);
        }
    }

    private static String[] distinctArr(String[] strArr){
        return Arrays.stream(strArr).distinct().toArray(String[]::new);
    }
}

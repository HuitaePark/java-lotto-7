package lotto.domain;

import static lotto.global.constant.LottoConstant.LOTTO_COUNT_NUMBER;
import static lotto.global.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.global.constant.LottoConstant.LOTTO_START_NUMBER;

import java.util.List;
import lotto.global.error.ErrorCode;
import lotto.global.error.exception.LottoIllegalArgumentException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoDistict(numbers);
        validateLottoRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers){
        if (numbers.size() != LOTTO_COUNT_NUMBER) {
            throw new LottoIllegalArgumentException(ErrorCode.INVALID_LOTTO_SIZE);
        }
    }

    private void validateLottoDistict(List<Integer> numbers){
        List<Integer> valid = numbers.stream().distinct().toList();
        if(valid.size() != LOTTO_COUNT_NUMBER){
            throw new LottoIllegalArgumentException(ErrorCode.DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateLottoRange(List<Integer> numbers){
        for(Integer i : numbers){
            if(isInLottoRange(i)){
                throw new LottoIllegalArgumentException(ErrorCode. INVALID_LOTTO_RANGE);
            }
        }
    }

    private boolean isInLottoRange(Integer i){
        return i >= LOTTO_START_NUMBER && i<= LOTTO_END_NUMBER;
    }
}

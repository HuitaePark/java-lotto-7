package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.entry.BonusNumber;
import lotto.domain.entry.EntryNumber;
import lotto.domain.entry.EntryNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EntryTest {

    @DisplayName("당첨 번호에 1부터 45 사이를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_1부터_45_사이를_넘어간_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> EntryNumber.entry("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌걸 입력하면 예외가 발생한다.")
    @Test
    void 숫자가아니면예외발생() {
        assertThatThrownBy(() -> EntryNumber.entry("테스트"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열 입력시 예외가 발생한다.")
    @Test
    void 빈문자열예외발생() {
        assertThatThrownBy(() -> EntryNumber.entry(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 엔트리넘버성공테스트() {
        EntryNumber entryNumber = EntryNumber.entry("5");
        assertThat(entryNumber.getEntryNumber()).isEqualTo(5);
    }

    @Test
    void 보너스넘버성공테스트() {
        BonusNumber bonusNumber = BonusNumber.bonusEntry("5");
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(5);
    }

    @DisplayName("보너스 넘버에 빈문자열 입력시 예외가 발생한다.")
    @Test
    void 보너스넘버빈문자열예외발생() {
        assertThatThrownBy(() -> BonusNumber.bonusEntry(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버에 1부터 45 사이를 넘어간 숫자가 있으면 예외가 발생한다.")
    @Test
    void 보너스넘버범위초과예외발생() {
        assertThatThrownBy(() -> BonusNumber.bonusEntry("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버에 숫자가 아닌걸 입력하면 예외가 발생한다.")
    @Test
    void 보너스넘버숫자가아니면예외발생() {
        assertThatThrownBy(() -> BonusNumber.bonusEntry("테스트"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 숫자 모음 사이즈가 6이 아니면 에러가 발생한다.")
    @Test
    void 당첨숫자길이예외발생() {
        assertThatThrownBy(() -> {
            BonusNumber bonusNumber = BonusNumber.bonusEntry("5");
            String[] entry = new String[6];
            EntryNumbers.entry(entry,"5");
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}


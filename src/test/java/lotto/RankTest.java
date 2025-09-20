package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.winning.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("6개 번호가 일치하면 1등이다.")
    void of_6_matches_should_return_FIRST_PLACE() {
        // when
        Rank rank = Rank.of(6, false);
        // then
        assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치하면 2등이다.")
    void of_5_matches_and_bonus_should_return_SECOND_PLACE() {
        // when
        Rank rank = Rank.of(5, true);
        // then
        assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
    }

    @Test
    @DisplayName("5개 번호가 일치하고 보너스 번호가 불일치하면 3등이다.")
    void of_5_matches_without_bonus_should_return_THIRD_PLACE() {
        // when
        Rank rank = Rank.of(5, false);
        // then
        assertThat(rank).isEqualTo(Rank.THIRD_PLACE);
    }

    @Test
    @DisplayName("4개 번호가 일치하면 4등이다.")
    void of_4_matches_should_return_FOURTH_PLACE() {
        // when
        Rank rank = Rank.of(4, false);
        // then
        assertThat(rank).isEqualTo(Rank.FOURTH_PLACE);
    }

    @Test
    @DisplayName("3개 번호가 일치하면 5등이다.")
    void of_3_matches_should_return_FIFTH_PLACE() {
        // when
        Rank rank = Rank.of(3, false);
        // then
        assertThat(rank).isEqualTo(Rank.FIFTH_PLACE);
    }

    @Test
    @DisplayName("2개 이하의 번호가 일치하면 꽝(MISS)이다.")
    void of_2_or_less_matches_should_return_MISS() {
        // when
        Rank rank2 = Rank.of(2, false);
        Rank rank1 = Rank.of(1, true);
        Rank rank0 = Rank.of(0, false);
        // then
        assertThat(rank2).isEqualTo(Rank.MISS);
        assertThat(rank1).isEqualTo(Rank.MISS);
        assertThat(rank0).isEqualTo(Rank.MISS);
    }
}

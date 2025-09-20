package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.dto.LottoWinningResult;
import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningReport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningReportTest {

    @Test
    @DisplayName("당첨 등수 목록을 바탕으로 최종 당첨 통계와 수익률을 정확히 계산한다.")
    void summarize_should_calculate_stats_and_yield_correctly() {
        // given
        List<Rank> winningList = List.of(
                Rank.FIFTH_PLACE, Rank.MISS, Rank.MISS, Rank.MISS,
                Rank.MISS, Rank.MISS, Rank.MISS, Rank.MISS
        );
        int purchaseQuantity = 8;

        WinningReport report = WinningReport.of(winningList);

        // when
        LottoWinningResult result = report.summarize(purchaseQuantity);

        // then
        assertThat(result.percent()).isEqualTo(62.5);


        String expectedMessage = "3개 일치 (5,000원) - 1개\n" +
                                 "4개 일치 (50,000원) - 0개\n" +
                                 "5개 일치 (1,500,000원) - 0개\n" +
                                 "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                                 "6개 일치 (2,000,000,000원) - 0개";

        assertThat(result.resultText().toString()).isEqualTo(expectedMessage);
    }
}

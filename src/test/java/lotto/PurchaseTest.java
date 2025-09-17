package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoCashier;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.Test;

public class PurchaseTest {
    @Test
    void 구입금액_에러발생_테스트() {
        assertThatThrownBy(
                () -> {
                    PurchaseAmount purchaseAmount = PurchaseAmount.forInputElement("테스트");
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액_성공_테스트() {
        PurchaseAmount purchaseAmount = PurchaseAmount.forInputElement("12000");
        assertThat(purchaseAmount.getAmount()).isEqualTo(12000);
    }

    @Test
    void 구입단위_에러발생_테스트() {
        assertThatThrownBy(
                () -> {
                    LottoCashier lottoCashier = LottoCashier.forPurchaseAmount(PurchaseAmount.forInputElement("1211"));
                })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또발급_성공_테스트() {
        PurchaseAmount purchaseAmount = PurchaseAmount.forInputElement("12000");
        LottoCashier lottoCashier = LottoCashier.forPurchaseAmount(purchaseAmount);

        assertThat(lottoCashier.getTicketCount()).isEqualTo(12);
        assertThat(lottoCashier.provideLottos()).isInstanceOf(Lottos.class);
    }
}

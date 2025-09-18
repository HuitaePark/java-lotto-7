package lotto.application.dto;

import lotto.domain.purchase.Lottos;

public record LottoPurchaseResult(
        Lottos lottos,
        int count) {
}

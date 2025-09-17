package lotto.dto;

import lotto.domain.Lottos;

public record LottoPurchaseResult(
        Lottos lottos,
        int count) {
}

package lotto.application.dto;

import java.util.List;
import lotto.domain.entry.BonusNumber;
import lotto.domain.entry.EntryNumber;

public record SubmittedEntries(
        List<EntryNumber> entryNumbers,
        BonusNumber bonusNumber
) {
}

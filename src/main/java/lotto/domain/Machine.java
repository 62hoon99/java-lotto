package lotto.domain;

import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Machine {

    public void start() {
        try {
            int quantity = Convertor.getQuantity(InputView.amount());
            List<Lotto> lottos = LottoGenerator.getLottos(quantity);
            OutputView.showLottoNumber(lottos);

            List<Integer> winningNumbers = Convertor.getNumbers(InputView.winningNumbers());
            int bonusNumber = Convertor.getNumber(InputView.bonusNumber());
            LottoException.validDuplication(winningNumbers, bonusNumber);

            List<Rank> ranks = RankGenerator.getRanks();
            CompareLotto.compare(ranks, lottos, winningNumbers, bonusNumber);
            double yield = Calculator.getYield(ranks, quantity);
            OutputView.result(ranks, yield);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}

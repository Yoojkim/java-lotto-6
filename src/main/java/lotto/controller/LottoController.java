package lotto.controller;

import lotto.domain.*;
import lotto.service.*;
import lotto.view.GameView;

public class LottoController {
    private final BudgetService budgetService;
    private final LottoService lottoService;
    private final WinningNumbersService winningNumbersService;
    private final WinningService winningService;
    private final BonusNumberService bonusNumberService;
    private final GameView gameView;

    public LottoController() {
        budgetService = new BudgetService();
        lottoService = new LottoService();
        winningNumbersService = new WinningNumbersService();
        winningService = new WinningService();
        bonusNumberService = new BonusNumberService();

        gameView = new GameView();
    }

    public void start() {
        gameView.printInputBudgetMessage();
        Budget budget = budgetService.createBudget();

        Lottos lottos = lottoService.createLottos(budget);
        //todo: 해당 과정이 controller에 들어있는 것이 적합한지 고려
        int lottosSize = lottoService.getLottosSize(lottos);
        gameView.printLottosSize(lottosSize);

        String lottosNumbers = lottoService.getLottosNumbers(lottos);
        gameView.printLottosNumbers(lottosNumbers);

        gameView.printInputWinningNumbersMessage();
        WinningNumbers winningNumbers = winningNumbersService.createWinningNumbers();

        gameView.printInputBonusNumberMessage();
        //todo: winningNumbers와 중복 검사 필요
        WinningNumber bonusNumber = bonusNumberService.createBonusNumber();

        //todo: 이 클래스의 존재가 올바른지?
        WinningManager winningManager = new WinningManager(winningNumbers, bonusNumber);

        WinningScores winningScores = winningService.calWinningScores(lottos, winningManager);
        String winningStatisticOutput = winningService.getWinningScoresResult(winningScores);
        gameView.printWinningStatistic(winningStatisticOutput);

        double profit = lottoService.getReturnOfLottos(winningScores, budget);
        //todo: ROI명 수정
        gameView.printROI(profit);
    }
}

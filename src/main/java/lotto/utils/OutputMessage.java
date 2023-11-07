package lotto.utils;

//todo: 이게 최선인지 고민
public enum OutputMessage {

    INPUT_BUDGET("구입금액을 입력해 주세요.\n"),
    OUTPUT_LOTTOS_SIZE("\n%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),
    OUTPUT_WINNING_STATISTIC("\n당첨 통계\n---\n");

    String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package org.docksidestage.bizfw.basic.buyticket;

// done umeyan [いいね] チケットの種類という概念がオブジェクトになっているというのがキーポイントですね by jflute (2024/07/31)
// done umeyan JavaDoc, 列挙説明のところ、"e.g." か "など" を使って断定しないようにしましょう by jflute (2024/07/31)
/**
 * チケットの種類を持つ。e.g. 1day, 2day, 4day, night only
 * @author umeda-yusuke
 */
public enum TicketType {

    ONE_DAY(1, 7400, false, 8),
    TWO_DAY(2, 13200, false, 8),
    FOUR_DAY(4, 22400, false, 8),
    NIGHT_ONLY_TWO_DAY(2, 7400, true, 18);

    // done umeyan [思考課題] もし仮に、仕様追加で "xxxな日数、xxxDays" という別の意味の日数が追加となったら... by jflute (2024/07/31)
    // この元々のdays変数名はどうします？ daysのまま？それとも変数名を変える？
    // done umeyan 修正すると言ってくれたので期待しています by jflute (2024/07/31)
    private final int enterableDays; // 入れる日数
    private final int displayPrice;
    private final boolean isNightOnly;
    private final int enterableHour;  // 何時から入場可能か

    // done umeyan [よもやま補足] enumのコンストラクターは絶対にprivateなので、省略してもパッケージスコープにならずにprivateなのですが... by jflute (2024/07/31)
    // 結構わかってない人も多いので、わりと明示的にprivateを付ける人は多いです。(お任せします)
    private TicketType(int enterableDays, int displayPrice, boolean isNightOnly, int enterableHour) {
        this.enterableDays = enterableDays;
        this.displayPrice = displayPrice;
        this.isNightOnly = isNightOnly;
        this.enterableHour = enterableHour;
    }

    // done umeyan [いいね] 完璧なtoString() by jflute (2024/08/15)
    // done jflute value的enumの場合のtoString()のお話をちょこっと (2024/08/15)
    public String toString() {
        return "TicketType: " + name() + " {enterableDays: " + enterableDays + ", displayPrice: " + displayPrice + ", isNightOnly: " + isNightOnly + "}";
    }
    
    public int geteEnterableDays() {
        return enterableDays;
    }

    // done umeyan [思考課題] 表示価格と名付けていますが、これは実際の販売価格と必ず一致しますか？ by jflute (2024/07/31)
    public int getDisplayPrice() {
        return displayPrice;
    }

    public boolean isNightOnly() {
        return isNightOnly;
    }

    // done umeyan 突然の一行スタイル by jflute (2024/08/22)
    public int getEnterableHour() {
        return enterableHour;
    }
}

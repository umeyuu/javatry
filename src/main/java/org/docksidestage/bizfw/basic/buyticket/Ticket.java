/*
 * Copyright 2019-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

// done umeyan ↑一度指摘されたら、他にも似たところがないか確認する習慣を by jflute (2024/07/26)

// done umeyan こちらもTicketBoothのJavaDocでの指摘と同じようにauthorお願いします by jflute (2024/07/25)
// (一つ指摘されたら、似たような箇所が他にないか？確認する習慣を付けましょう)
/**
 * @author jflute
 * @author umeda-yusuke
 */
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // done umeyan [いいね] 横のスラスラコメント(//コメント) がとても良いですね！ by jflute (2024/07/25)
    // done jflute 1on1にてコメントのe.g.技の話を (2024/07/25)
    // [memo] チケットの種類 e.g. 1day ticket
    // done umeyan [思考課題] インスタンス変数の定義順序って、どうしたらいいか？ってアイディアありますか？ by jflute (2024/07/31)
    // 重要な物順とかですかね？何を持って重要かは分からないですが、雰囲気で並び変えてみます by umeyan (2024/07/31)
    private final TicketType ticketType; // チケットの種類
    private int availableEnterCount; // 入園できる回数
    private boolean alreadyIn = false; // true means this ticket is unavailable

    // done umeyan この変数はpublicで公開する必要はないと思うのでprivateにしましょう by jflute (2024/07/11)
    // インスタンス変数をpublicにすることはめったにないです。(publicフィールドスタイルの場合は別ですが)
    // done umeyan HashMapを扱う時は、Mapインターフェースで受け取るのが慣習です by jflute (2024/07/11)
    // step6のオブジェクト指向のところでポリモーフィズムで詳しくやるのですが...
    // このMapを利用する側は、「Hashで実現したMap」であることを意識する必要はないので、それをMapで隠蔽します。
    // new ArrayList()をListインターフェース受け取るのと同じです。

    // 日付は使わない方針にしたので、Hashmapを使わない方針に変更
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
        this.availableEnterCount = ticketType.geteEnterableDays();
    }
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    // done umeyan インスタンス変数の順番に合わせましょう by jflute (2024/07/31)
    public TicketType getTicketType() {
        return ticketType;
    }

    public int getDisplayPrice() { // ちょいFacade的なメソッド
        return ticketType.getDisplayPrice();
    }

    public int getAvailableEnterCount() {
        return availableEnterCount;
    }

    public boolean isAlreadyIn() {
        return alreadyIn;
    }

    // TODO umeyan [提案] Ticketに問答無用で何でもcountをいじれるメソッドを作るよりも... by jflute (2024/09/03)
    // 業務的なメソッドとして例えば decrementEnterCount() とか markAsOneEnter() とかで、
    // 「1減らす」というメソッドを提供して、TicketReaderはそれを呼ぶようにするとか。
    // 業務的な振る舞いを無くしてReaderに移動したわけですが、最低限のチケットとしての振る舞いという感じで、
    // チケットが持つ属性(インスタンス変数)を守る振る舞い(メソッド)があった方が良いと思いました。
    // ただ、設計思想としてTicketは単なる入れ物に徹するとかであればこのままでOKです。
    public void setAvailableEnterCount(int availableEnterCount) {
        if (availableEnterCount < 0) {
            throw new IllegalArgumentException("availableEnterCount should not be minus: " + availableEnterCount);
        }
        this.availableEnterCount = availableEnterCount;
    }

    public void setAlreadyIn(boolean alreadyIn) {
        this.alreadyIn = alreadyIn;
    }
}

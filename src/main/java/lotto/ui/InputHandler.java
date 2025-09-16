package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String inputText() {
        return Console.readLine();
    }
    public void inputClose() {
        Console.close();
    }
}

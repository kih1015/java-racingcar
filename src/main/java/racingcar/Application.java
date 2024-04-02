package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
    }
    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("5자 이하만 가능합니다.");
            }
        }
        return names;
    }
}

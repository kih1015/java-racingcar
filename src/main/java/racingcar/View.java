package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class View {
    public String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public int readTry() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printWinners(List<String> winnersNames) {
        String winners = String.join(", ", winnersNames);
        System.out.println("최종 우승자 : " + winners);
    }

    public void printState(List<String> state) {
        for (String carState : state) {
            System.out.println(carState);
        }
        System.out.println();
    }
}

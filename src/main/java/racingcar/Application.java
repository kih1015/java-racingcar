package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Racing race = new Racing(readNames(), readTry());
        race.run();
        printWinners(race);
    }

    private static String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private static int readTry() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static void printWinners(Racing race) {
        String winners = String.join(", ", race.getWinnerNames());
        System.out.println("최종 우승자 : " + winners);
    }
}

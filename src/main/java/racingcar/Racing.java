package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> raceables;

    public void run() {
        String[] names = readNames();
        int tries = readTries();

        raceables = new ArrayList<>(names.length);
        for (String carName : names) {
            raceables.add(new Car(carName));
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < tries; i++) {
            advanceAll();
            System.out.println();
        }
        printWinners();
    }

    private String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private int readTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void advanceAll() {
        for (Car raceable : raceables) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                raceable.advance();
            }
            System.out.println(raceable);
        }
    }

    private void printWinners() {
        int maxPosition = 0;
        for (Car raceable : raceables) {
            maxPosition = Math.max(maxPosition, raceable.getPosition());
        }

        List<String> winnerCarNames = new ArrayList<>();
        for (Car raceable : raceables) {
            if (raceable.getPosition() == maxPosition) {
                winnerCarNames.add(raceable.getName());
            }
        }

        String winners = String.join(", ", winnerCarNames);
        System.out.println("최종 우승자 : " + winners);
    }
}
package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public void run() {
        String[] carNames = readCarNames();
        int tries = readTries();

        List<Car> cars = new ArrayList<>(carNames.length);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < tries; i++) {
            advanceCars(cars);
            System.out.println();
        }

        printWinners(cars);
    }

    private String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    private int readTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void advanceCars(List<Car> cars) {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.advance();
            }
            System.out.println(car);
        }
    }

    private void printWinners(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winnerCarNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerCarNames.add(car.getName());
            }
        }

        String winners = String.join(", ", winnerCarNames);
        System.out.println("최종 우승자 : " + winners);
    }
}

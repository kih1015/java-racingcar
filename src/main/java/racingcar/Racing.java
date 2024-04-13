package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    final private List<Car> cars = new ArrayList<>();
    final private int totalTry;

    public Racing(String[] carNames, int totalTry) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.totalTry = totalTry;
    }

    public void run() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < totalTry; i++) {
            advanceAll();
            System.out.println();
        }
        printWinners();
    }


    private void advanceAll() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.advance();
            }
            System.out.println(car);
        }
    }

    private void printWinners() {
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
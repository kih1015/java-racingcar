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
            TryAdvanceAll();
            printState();
        }
    }

    public List<String> getWinnerNames() {
        int maxPosition = 0;

        // 가장 높은 위치 찾기
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        // 가장 높은 위치에 있는 차량 찾기
        List<String> winnerCarNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerCarNames.add(car.getName());
            }
        }

        return winnerCarNames;
    }

    private void TryAdvanceAll() {
        for (Car car : cars) {
            car.TryAdvance();
        }
    }

    private void printState() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
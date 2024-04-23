package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final View view;
    private final List<Car> cars;

    public Racing(List<Car> cars, View view) {
        this.view = view;
        this.cars = cars;
    }

    public void run() {
        for (String carName : view.readNames()) {
            cars.add(new Car(carName));
        }
        int totalTry = view.readTry();
        view.printIntroForResult();
        for (int i = 0; i < totalTry; i++) {
            TryAdvanceAll();
            view.printState(cars.stream().map(Car::toString).toList());
        }
        view.printWinners(getWinnerNames());
    }

    private List<String> getWinnerNames() {
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
}
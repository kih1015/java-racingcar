package racingcar;

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
        // try 횟수만큼 반복
        for (int i = 0; i < totalTry; i++) {
            TryAdvanceAll();
            view.printState(cars.stream()
                    .map(Car::toString)
                    .toList());
        }
        view.printWinners(getWinnerNames());
    }

    private List<String> getWinnerNames() {
        // 가장 높은 위치를 구함
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        // 가장 높은 위치에 있는 차량의 이름을 가져옴
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private void TryAdvanceAll() {
        for (Car car : cars) {
            car.TryAdvance();
        }
    }
}
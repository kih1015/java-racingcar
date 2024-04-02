package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        String[] carNames = readCarNames();
        int tries = readTries();

        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        System.out.println("\n실행 결과");
        for (int i = 0; i < tries; i++) {
            advanceCars(cars);
            System.out.println();
        }

        printWinners(cars);
    }
    private static String[] readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }
    private static int readTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
    private static void advanceCars(Car[] cars){
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.advance();
            }
            System.out.println(car);
        }
    }
    private static void printWinners(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (!winners.isEmpty()) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + winners);
    }
}

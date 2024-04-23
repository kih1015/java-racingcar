package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Racing race = new Racing(new ArrayList<>(), new View());
        race.run();
    }
}

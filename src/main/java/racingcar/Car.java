package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    private RandomNumberGenerator randomNumberGenerator;

    public Car(String name) {
        this(name, new Generator0to9());
    }

    public Car(String name, RandomNumberGenerator randomNumberGenerator) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void TryAdvance() {
        if (randomNumberGenerator.pickNumber() >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
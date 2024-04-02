package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        this.name = name;
    }
    public void advance() {
        this.position++;
    }
    public String getName() {
        return this.name;
    }
    public int getPosition() {
        return this.position;
    }
    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Generator0to9 implements RandomNumberGenerator{
    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

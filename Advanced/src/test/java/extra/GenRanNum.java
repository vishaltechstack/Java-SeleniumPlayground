package extra;

import java.util.Random;

public class GenRanNum {
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }
}

import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        GameRunner runner = new GameRunner();

        for (int i = 0; i < 10; i++) {
            runner.playGame();
        }
    }
}

import io.cucumber.java.ru.Дано;

public class ConsoleStepdefs {
    @Дано("и написать в консоль тест")
    public void printTest() {
        System.out.println("TEst");
    }
}

import io.cucumber.java.After;

public class Hooks {
    private final DriverService driverService;

    public Hooks(DriverService service) {
        driverService = service;
    }

    @After
    public void after() {
        this.driverService.closeDriver();
    }
}

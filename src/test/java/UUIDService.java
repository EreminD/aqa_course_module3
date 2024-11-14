import java.util.UUID;

public class UUIDService {

    private final UUID uuid;

    public UUIDService() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid(){
        return uuid;
    }
}

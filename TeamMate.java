import java.util.UUID;

public class TeamMate {
    private String userId;
    private String name;
    private Boolean online;

    TeamMate(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.online = false;
    }

    TeamMate(String name) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.online = false;
    }

    public void setUserId(String userId) { this.userId = userId; }
    public String getUserId() { return this.userId; }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public void setOnline(Boolean online) { this.online = online; }
    public Boolean getOnline() { return this.online; }

}
package TeamworkProjectsMoreEx;

import java.util.List;

public class Team {

    private String name;
    private String creatorName;
    private List<String> members;

    public Team(String name, String creatorName, List<String> members) {
        this.name = name;
        this.creatorName = creatorName;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}

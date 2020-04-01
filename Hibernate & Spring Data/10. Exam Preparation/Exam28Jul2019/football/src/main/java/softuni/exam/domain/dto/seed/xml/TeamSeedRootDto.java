package softuni.exam.domain.dto.seed.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


@XmlRootElement(name = "teams")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedRootDto implements Serializable {

    @XmlElement(name = "team")
    List<TeamSeedDto> teams;

    public TeamSeedRootDto() {
    }

    public List<TeamSeedDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamSeedDto> teams) {
        this.teams = teams;
    }
}

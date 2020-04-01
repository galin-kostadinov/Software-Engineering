package softuni.exam.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.seed.xml.TeamSeedDto;
import softuni.exam.domain.dto.seed.xml.TeamSeedRootDto;
import softuni.exam.domain.entity.Team;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;


import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

import static softuni.exam.constant.GlobalConstant.*;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final PictureService pictureService;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileIOUtil fileIOUtil;
    private final XmlParser xmlParser;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, PictureService pictureService, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileIOUtil fileIOUtil, XmlParser xmlParser) {
        this.teamRepository = teamRepository;
        this.pictureService = pictureService;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileIOUtil = fileIOUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        TeamSeedRootDto teamSeedRootDto =
                this.xmlParser.objectFromFile(TeamSeedRootDto.class, TEAMS_SEED_PATH);

        StringBuilder stringBuilder = new StringBuilder();

        for (TeamSeedDto dtoTeam : teamSeedRootDto.getTeams()) {
            if (!this.validatorUtil.isValid(dtoTeam)) {
                stringBuilder.append("Invalid team").append(System.lineSeparator());
                continue;
            }

            Team team = this.modelMapper.map(dtoTeam, Team.class);

            Long picId = this.pictureService.getPictureIdByUrl(team.getPicture().getUrl());

            if (picId == null) {
                stringBuilder.append("Invalid team").append(System.lineSeparator());
                continue;
            }

            team.getPicture().setId(picId);

            this.teamRepository.saveAndFlush(team);
            stringBuilder.append(String.format("Successfully imported team - %s", team.getName()))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return this.fileIOUtil.readFileContent(TEAMS_SEED_PATH);
    }

    @Override
    public Long getTeamIdByName(String name) {
        Team team = this.teamRepository.findByName(name).orElse(null);
        return team == null ? null : team.getId();
    }
}

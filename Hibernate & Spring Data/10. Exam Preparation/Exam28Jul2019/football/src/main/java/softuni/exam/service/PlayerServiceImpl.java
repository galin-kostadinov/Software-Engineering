package softuni.exam.service;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dto.seed.json.PlayerSeedDto;
import softuni.exam.domain.entity.Player;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.util.FileIOUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;


import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static softuni.exam.constant.GlobalConstant.*;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final PictureService pictureService;
    private final TeamService teamService;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final FileIOUtil fileIOUtil;
    private final Gson gson;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, PictureService pictureService, TeamService teamService, ModelMapper modelMapper, ValidatorUtil validatorUtil, FileIOUtil fileIOUtil, XmlParser xmlParser, Gson gson) {
        this.playerRepository = playerRepository;
        this.pictureService = pictureService;
        this.teamService = teamService;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.fileIOUtil = fileIOUtil;
        this.gson = gson;
    }


    @Override
    public String importPlayers() throws FileNotFoundException {
        PlayerSeedDto[] playerSeedDtos =
                this.gson.fromJson(new FileReader(PLAYERES_SEED_PATH), PlayerSeedDto[].class);

        StringBuilder stringBuilder = new StringBuilder();

        for (PlayerSeedDto dtoPlayer : playerSeedDtos) {
            if (!this.validatorUtil.isValid(dtoPlayer)) {
                stringBuilder.append("Invalid player").append(System.lineSeparator());
                continue;
            }

            Player player = this.modelMapper.map(dtoPlayer, Player.class);

            Long playerPicId = this.pictureService.getPictureIdByUrl(player.getPicture().getUrl());

            if (playerPicId == null) {
                stringBuilder.append("Invalid player").append(System.lineSeparator());
                continue;
            }

            Long teamPicId = this.pictureService.getPictureIdByUrl(player.getTeam().getPicture().getUrl());

            if (teamPicId == null) {
                stringBuilder.append("Invalid player").append(System.lineSeparator());
                continue;
            }

            Long teamId = this.teamService.getTeamIdByName(player.getTeam().getName());

            if (teamId == null) {
                stringBuilder.append("Invalid player").append(System.lineSeparator());
                continue;
            }

            player.getPicture().setId(playerPicId);
            player.getTeam().getPicture().setId(teamPicId);
            player.getTeam().setId(teamId);

            this.playerRepository.save(player);
            stringBuilder.append(
                    String.format("Successfully imported player: %s %s", player.getFirstName(), player.getLastName()))
                    .append(System.lineSeparator());
        }

        return stringBuilder.toString().trim();
    }

    @Override
    public boolean areImported() {
        return this.playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return this.fileIOUtil.readFileContent(PLAYERES_SEED_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        List<Player> players = this.playerRepository
                .findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000));

        StringBuilder stringBuilder = new StringBuilder();

        players.forEach(p -> {
            stringBuilder.append(String.format("Player name: %s %s",
                    p.getFirstName(), p.getLastName()));

            stringBuilder.append(System.lineSeparator());

            stringBuilder.append(String.format("\tNumber: %d", p.getNumber())).append(System.lineSeparator());
            stringBuilder.append(String.format("\tSalary: %.2f", p.getSalary())).append(System.lineSeparator());
            stringBuilder.append(String.format("\tTeam: %s", p.getTeam().getName())).append(System.lineSeparator());
        });

        return stringBuilder.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        List<Player> players = this.playerRepository.findAllByTeamNameOrderById("North Hub");

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Team: North Hub").append(System.lineSeparator());

        players.forEach(p -> {
            stringBuilder.append(String.format("\tPlayer name: %s %s - %s",
                    p.getFirstName(), p.getLastName(), p.getPosition()));

            stringBuilder.append(System.lineSeparator());

            stringBuilder.append(String.format("\tNumber: %d", p.getNumber()));

            stringBuilder.append(System.lineSeparator());
        });

        return stringBuilder.toString().trim();
    }
}

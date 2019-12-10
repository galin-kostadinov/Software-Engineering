package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    List<Player> civilPlayers;
    ArrayDeque<Gun> guns;
    Player mainPlayer;
    Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayDeque<>();
        this.mainPlayer = new MainPlayer();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        civilPlayers.add(new CivilPlayer(name));
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;

        switch (type) {
            case "Pistol":
                gun = new Pistol(name);
                break;
            case "Rifle":
                gun = new Rifle(name);
                break;
            default:
                break;
        }

        if (gun == null) {
            return ConstantMessages.GUN_TYPE_INVALID;
        } else {
            guns.offer(gun);
            return String.format(ConstantMessages.GUN_ADDED, name, type);
        }
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }

        if (name.equals("Vercetti")) {
            Gun gun = guns.poll();
            mainPlayer.getGunRepository().add(gun);

            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }

        Player p = null;
        for (Player player : civilPlayers) {
            if (player.getName().equals(name)) {
                p = player;
                break;
            }
        }

        if (p != null) {
            Gun gun = guns.poll();
            p.getGunRepository().add(gun);

            return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), p.getName());
        } else {
            return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
    }

    @Override
    public String fight() {
        int mainPlayerStartHealth = this.mainPlayer.getLifePoints();
        int startCivilPlayersCount = this.civilPlayers.size();
        int startCivilPlayersHealth = this.civilPlayers.stream().mapToInt(Player::getLifePoints).sum();

        this.neighbourhood.action(mainPlayer, civilPlayers);

        int mainPlayerFinalHealth = this.mainPlayer.getLifePoints();

        this.civilPlayers = this.civilPlayers.stream().filter(Player::isAlive).collect(Collectors.toList());

        int leftCivilPlayersCount = this.civilPlayers.size();
        int leftCivilPlayersHealth = this.civilPlayers.stream().mapToInt(Player::getLifePoints).sum();

        if (mainPlayerStartHealth == mainPlayerFinalHealth &&
                startCivilPlayersCount == leftCivilPlayersCount &&
                startCivilPlayersHealth == leftCivilPlayersHealth) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder sb = new StringBuilder();

            sb.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());

            sb.append(String.format(
                    ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayerFinalHealth));
            sb.append(System.lineSeparator());

            sb.append(String.format(
                    ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, startCivilPlayersCount - leftCivilPlayersCount));
            sb.append(System.lineSeparator());

            sb.append(String.format(
                    ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, leftCivilPlayersCount));

            return sb.toString();
        }
    }
}

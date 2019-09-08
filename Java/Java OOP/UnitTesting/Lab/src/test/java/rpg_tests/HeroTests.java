package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Dummy;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTests {
    private static final int DEFAULT_XP = 10;
    private static final int DEFAULT_TARGET_HEALTH = 0;
    private static final int DEFAULT_WEAPON_POINTS = 10;
    private static final int DEFAULT_WEAPON_DURABILITY_POINTS = 0;
    private static final boolean DEFAULT_IS_TARGET_DEAD = Boolean.TRUE;
    private static final String HERO_NAME = "Ivan";

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Target target = new Target() {
            @Override
            public int getHealth() {
                return DEFAULT_TARGET_HEALTH;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return DEFAULT_XP;
            }

            @Override
            public boolean isDead() {
                return DEFAULT_IS_TARGET_DEAD;
            }
        };

        Weapon weapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return DEFAULT_WEAPON_POINTS;
            }

            @Override
            public int getDurabilityPoints() {
                return DEFAULT_WEAPON_DURABILITY_POINTS;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Hero hero = new Hero(weapon, HERO_NAME);
        hero.attack(target);

        Assert.assertEquals(DEFAULT_XP, hero.getExperience());
    }
}

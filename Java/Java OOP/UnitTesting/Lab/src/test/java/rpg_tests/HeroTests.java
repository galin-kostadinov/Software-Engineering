package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
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
        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.giveExperience()).thenReturn(DEFAULT_XP);
        Mockito.when(mockTarget.isDead()).thenReturn(DEFAULT_IS_TARGET_DEAD);

        Weapon mockWeapon = Mockito.mock(Weapon.class);
        Mockito.when(mockWeapon.getAttackPoints()).thenReturn(DEFAULT_WEAPON_POINTS);
        Mockito.when(mockWeapon.getDurabilityPoints()).thenReturn(DEFAULT_WEAPON_DURABILITY_POINTS);


        Hero hero = new Hero(mockWeapon, HERO_NAME);
        hero.attack(mockTarget);

        Assert.assertEquals("Wrong experience",DEFAULT_XP, hero.getExperience());
    }
}

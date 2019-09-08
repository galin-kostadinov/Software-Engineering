package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;

    private Axe axe;
    private Dummy target;

    @Before
    public void initValues() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.target = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void weaponAttacksLosesDurability() {
        axe.attack(target);

        Assert.assertEquals("Wrong Durability", 9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        axe.attack(target);
        axe.attack(target);
        axe.attack(target);
    }
}

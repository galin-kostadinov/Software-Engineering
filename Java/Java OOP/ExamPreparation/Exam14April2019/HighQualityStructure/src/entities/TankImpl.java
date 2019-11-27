package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {

    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double ATTACK_POINTS_MODIFIER = 40;
    private static final double DEFFENCE_POINTS_MODIFIER = 30;

    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.toggleDefenseMode();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode) {
            this.defenseMode = false;
            super.setAttackPoints(+ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(-DEFFENCE_POINTS_MODIFIER);
        } else {
            this.defenseMode = true;
            super.setAttackPoints(-ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(+DEFFENCE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        String mode = this.getDefenseMode() ? "ON" : "OFF";
        return super.toString() + System.lineSeparator() + " *Defense Mode(" + mode + ")";
    }
}

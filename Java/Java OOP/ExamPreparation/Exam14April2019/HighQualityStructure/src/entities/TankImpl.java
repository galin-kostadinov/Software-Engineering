package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {

    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double ATTACK_POINTS_MODIFIER = 40;
    private static final double DEFENSE_POINTS_MODIFIER = 30;

    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.setDefenseModeTrue();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    private void setDefenseModeTrue() {
        this.defenseMode = true;
        super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
        super.setDefensePoints(super.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
    }

    private void setDefenseModeFalse() {
        this.defenseMode = false;
        super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
        super.setDefensePoints(super.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
    }

    @Override
    public void toggleDefenseMode() {
        if (this.getDefenseMode()) {
            this.setDefenseModeFalse();
        } else {
            this.setDefenseModeTrue();
        }
    }

    @Override
    public String toString() {
        String mode = this.getDefenseMode() ? "ON" : "OFF";
        return super.toString() + System.lineSeparator() + " *Defense Mode(" + mode + ")";
    }
}

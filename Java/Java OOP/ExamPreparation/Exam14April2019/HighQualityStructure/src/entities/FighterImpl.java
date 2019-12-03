package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double ATTACK_POINTS_MODIFIER = 50;
    private static final double DEFENSE_POINTS_MODIFIER = 25;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.setAggressiveModeTrue();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    private void setAggressiveModeTrue() {
        this.aggressiveMode = true;
        super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
        super.setDefensePoints(super.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
    }

    private void setAggressiveModeFalse() {
        this.aggressiveMode = false;
        super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
        super.setDefensePoints(super.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.getAggressiveMode()) {
            this.setAggressiveModeFalse();
        } else {
            this.setAggressiveModeTrue();
        }
    }

    @Override
    public String toString() {
        String mode = this.getAggressiveMode() ? "ON" : "OFF";
        return super.toString() + System.lineSeparator() + " *Aggressive Mode(" + mode + ")";
    }
}

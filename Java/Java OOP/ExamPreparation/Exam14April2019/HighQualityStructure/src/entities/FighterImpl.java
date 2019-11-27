package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double ATTACK_POINTS_MODIFIER = 50;
    private static final double DEFFENCE_POINTS_MODIFIER = 25;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode) {
            this.aggressiveMode = false;
            super.setAttackPoints(-ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(+DEFFENCE_POINTS_MODIFIER);
        } else {
            this.aggressiveMode = true;
            super.setAttackPoints(+ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(-DEFFENCE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        String mode = this.getAggressiveMode() ? "ON" : "OFF";
        return super.toString() + System.lineSeparator() + " *Aggressive Mode(" + mode + ")";
    }
}

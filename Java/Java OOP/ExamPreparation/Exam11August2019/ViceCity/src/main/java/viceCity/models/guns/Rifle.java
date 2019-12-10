package viceCity.models.guns;

public class Rifle extends BaseGun {
    private final static int BULLETS_PER_BARREL = 50;
    private final static int TOTAL_BULLETS = 500;
    private final static int SHOOTED_BULLETS_BY_TURN = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (super.getBulletsPerBarrel() > 0) {
            super.setBulletsPerBarrel(super.getBulletsPerBarrel() - SHOOTED_BULLETS_BY_TURN);

            if (super.getBulletsPerBarrel() == 0) {
                if (super.getTotalBullets() >= BULLETS_PER_BARREL) {
                    super.setBulletsPerBarrel(BULLETS_PER_BARREL);
                    super.setTotalBullets(super.getTotalBullets() - BULLETS_PER_BARREL);
                }
            }

            return SHOOTED_BULLETS_BY_TURN;
        } else {
            return 0;
        }
    }


}

package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroRepositoryTests {
    HeroRepository heroRepository;

    @Before
    public void init() {
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void getCountOnEmptyRepositoryShouldReturnZeroSize() {
        Assert.assertEquals(0, this.heroRepository.getCount());
    }

    @Test
    public void getCountOnNotEmptyRepositoryShouldReturnRealCount() {
        int testCount = 10;

        for (int i = 0; i < testCount; i++) {
            Hero hero = new Hero("Hero" + i, i);
            heroRepository.create(hero);
        }

        Assert.assertEquals(testCount, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void callCreateCommandWithNullShouldThrowException() {
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void callCreateCommandWithElementWithSameNameAsExistingInRepositoryShouldThrowException() {
        Hero hero = new Hero("Hero", 10);
        Hero hero1 = new Hero("Hero", 11);
        heroRepository.create(hero);
        heroRepository.create(hero1);
    }

    @Test(expected = NullPointerException.class)
    public void removeNullElementShouldThrowException() {
        heroRepository.remove(null);
    }

    @Test
    public void removeElementShouldReturnTrueWhenExistedElementIsRemoveSuccessfully() {
        Hero hero = new Hero("Hero", 10);
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("Hero"));
    }

    @Test
    public void removeElementShouldReturnFalseWithInvalidName() {
        Assert.assertFalse(heroRepository.remove("Hero"));
    }

    @Test
    public void getHeroWithHighestLevelOnEmptyCollectionShouldReturnNull() {
        Assert.assertEquals(null, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void getHeroWithHighestLevelShouldReturnCorrectHero() {
        for (int i = 0; i < 5; i++) {
            Hero hero = new Hero("Hero" + i, i);
            heroRepository.create(hero);
        }

        Hero expectedHero = new Hero("Hero" + 100, 100);
        heroRepository.create(expectedHero);

        for (int i = 10; i < 15; i++) {
            Hero hero = new Hero("Hero" + i, i);
            heroRepository.create(hero);
        }

        Assert.assertEquals(expectedHero, heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void getHeroWithNameShouldReturnCorrectHero() {
        Hero hero1 = new Hero("Hero" + 1, 1);
        Hero hero2 = new Hero("Hero" + 2, 2);
        Hero hero3 = new Hero("Hero" + 3, 3);

        heroRepository.create(hero1);
        heroRepository.create(hero2);
        heroRepository.create(hero3);

        Assert.assertEquals(hero2, heroRepository.getHero("Hero2"));
    }
}

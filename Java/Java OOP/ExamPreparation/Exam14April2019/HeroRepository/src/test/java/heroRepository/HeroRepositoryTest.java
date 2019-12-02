package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class HeroRepositoryTest {
    private HeroRepository heroRepository;

    @Before
    public void setUp() {
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void addShouldAddElementToRepository() {
        Hero hero = mock(Hero.class);
        this.heroRepository.add(hero);

        Assert.assertEquals(1, heroRepository.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateElementShouldToRepositoryShouldThrowException() {
        Hero hero = mock(Hero.class);

        this.heroRepository.add(hero);
        this.heroRepository.add(hero);
    }

    @Test
    public void addTenDifferentElementsShouldAddAllElementsToRepository() {
        Item item = new Item(20, 20, 20);

        for (int i = 0; i < 10; i++) {
            this.heroRepository.add(new Hero("Ivan" + i, 10, item));
        }

        Assert.assertEquals(10, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeNotContainedElementFromRepositoryShouldThrowException() {
        final String heroName = "Ivan";
        Hero hero = mock(Hero.class);
        Mockito.when(hero.getName()).thenReturn(heroName);

        this.heroRepository.remove(heroName + "1");
    }

    @Test
    public void removeElementFromRepositoryShouldRemoveElement() {
        Item item = new Item(20, 20, 20);
        this.heroRepository.add(new Hero("Ivan", 10, item));

        Assert.assertEquals(1, this.heroRepository.getCount());

        this.heroRepository.remove("Ivan");

        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthFromEmptyRepositoryShouldThrowException() {
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestStrengthFromRepositoryShouldGiveExpectedHero() {
        Item item1 = new Item(20 + 1, 20, 20);
        Item item2 = new Item(20 + 2, 20, 20);
        Item item3 = new Item(20 + 3, 20, 20);

        Hero hero1 = new Hero("Ivan" + 1, 10, item1);
        Hero hero2 = new Hero("Ivan" + 2, 10, item2);
        Hero hero3 = new Hero("Ivan" + 3, 10, item3);

        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        this.heroRepository.add(hero3);

        Assert.assertEquals(hero3, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityFromEmptyRepositoryShouldThrowException() {
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestAgilityFromRepositoryShouldGiveExpectedHero() {
        Item item1 = new Item(20, 21, 20);
        Item item2 = new Item(20, 22, 20);
        Item item3 = new Item(20, 23, 20);

        Hero hero1 = new Hero("Ivan" + 1, 10, item1);
        Hero hero2 = new Hero("Ivan" + 2, 10, item2);
        Hero hero3 = new Hero("Ivan" + 3, 10, item3);

        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        this.heroRepository.add(hero3);

        Assert.assertEquals(hero3, heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceFromEmptyRepositoryShouldThrowException() {
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getHeroWithHighestIntelligenceFromRepositoryShouldGiveExpectedHero() {
        Item item1 = new Item(20, 20, 21);
        Item item2 = new Item(20, 20, 22);
        Item item3 = new Item(20, 20, 23);

        Hero hero1 = new Hero("Ivan" + 1, 10, item1);
        Hero hero2 = new Hero("Ivan" + 2, 10, item2);
        Hero hero3 = new Hero("Ivan" + 3, 10, item3);

        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        this.heroRepository.add(hero3);

        Assert.assertEquals(hero3, this.heroRepository.getHeroWithHighestIntelligence());
    }

    @Test
    public void getCountShouldReturnRealCount() {

        Item item = new Item(20, 20, 20);

        for (int i = 0; i < 100; i++) {
            this.heroRepository.add(new Hero("Ivan" + i, 10, item));
        }

        Assert.assertEquals(100, this.heroRepository.getCount());
    }
}
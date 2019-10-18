package heroRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository {
    private Map<String, Hero> data;

    public HeroRepository() {
        this.data = new LinkedHashMap<>();
    }

    public void add(Hero hero) {
        data.putIfAbsent(hero.getName(), hero);
    }

    public void remove(String name) {
        data.remove(name);
    }

    public Hero getHeroWithHighestStrength() {
        Hero hero = null;

        for (Hero currHero : data.values()) {
            if (hero == null || currHero.getItem().getStrength() > hero.getItem().getStrength()) {
                hero = currHero;
            }
        }

        return hero;
    }

    public Hero getHeroWithHighestAgility() {
        Hero hero = null;

        for (Hero currHero : data.values()) {
            if (hero == null || currHero.getItem().getAgility() > hero.getItem().getAgility()) {
                hero = currHero;
            }
        }

        return hero;
    }

    public Hero getHeroWithHighestIntelligence() {
        Hero hero = null;

        for (Hero currHero : data.values()) {
            if (hero == null || currHero.getItem().getIntelligence() > hero.getItem().getIntelligence()) {
                hero = currHero;
            }
        }

        return hero;
    }

    public int getCount() {
       return this.data.size();
    }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();

      for (Hero hero : data.values()) {
         sb.append(hero).append(System.lineSeparator());
      }

      return sb.toString().trim();
   }
}

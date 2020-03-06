package bookshopsystemapp.dto.book;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.EditionType;

import java.math.BigDecimal;

public class ReducedBook {
    private final String title;
    private final EditionType editionType;
    private final BigDecimal price;
    private final AgeRestriction ageRestriction;

    public ReducedBook(String title, EditionType editionType, BigDecimal price, AgeRestriction ageRestriction) {
        this.title = title;
        this.editionType = editionType;
        this.price = price;
        this.ageRestriction = ageRestriction;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %.2f",
                this.title, this.editionType, this.ageRestriction, this.price);
    }
}

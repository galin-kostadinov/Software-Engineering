package homework.gamestore.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GameViewDetailsDto {
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameViewDetailsDto() {
    }

    public GameViewDetailsDto(String title, BigDecimal price, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Title: %s", getTitle())).append(System.lineSeparator());
        sb.append(String.format("Price: %s", getPrice())).append(System.lineSeparator());
        sb.append(String.format("Description: %s", getDescription())).append(System.lineSeparator());
        String date = getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        sb.append(String.format("Release date: %s",date)).append(System.lineSeparator());

        return sb.toString().trim();
    }
}

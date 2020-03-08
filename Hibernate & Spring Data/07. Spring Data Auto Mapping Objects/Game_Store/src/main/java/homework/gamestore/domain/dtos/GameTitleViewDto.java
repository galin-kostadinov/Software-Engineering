package homework.gamestore.domain.dtos;

public class GameTitleViewDto {
    private String title;

    public GameTitleViewDto() {
    }

    public GameTitleViewDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

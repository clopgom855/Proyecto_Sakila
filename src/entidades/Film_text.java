package entidades;

public class Film_text {
    private int film_id;
    private String title;
    private String description;
    
    public Film_text() {}
    
    public Film_text(int film_id, String title, String description) {
        this.film_id = film_id;
        this.title = title;
        this.description = description;
    }
    
    // Getters and Setters
    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

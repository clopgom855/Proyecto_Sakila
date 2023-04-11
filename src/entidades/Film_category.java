package entidades;

import java.sql.Date;

public class Film_category {
    private int filmId;
  private int categoryId;
  private Date lastUpdate;

  public Film_category(int filmId, int categoryId, Date lastUpdate) {
    this.filmId = filmId;
    this.categoryId = categoryId;
    this.lastUpdate = lastUpdate;
  }

  public int getFilmId() {
    return filmId;
  }

  public void setFilmId(int filmId) {
    this.filmId = filmId;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
}

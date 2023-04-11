package entidades;

import java.sql.Timestamp;


public class Film_actor {
    private int actorId;
  private int filmId;
  private Timestamp lastUpdate;

  public Film_actor(int actorId, int filmId, Timestamp lastUpdate) {
    this.actorId = actorId;
    this.filmId = filmId;
    this.lastUpdate = lastUpdate;
  }

  public int getActorId() {
    return actorId;
  }

  public void setActorId(int actorId) {
    this.actorId = actorId;
  }

  public int getFilmId() {
    return filmId;
  }

  public void setFilmId(int filmId) {
    this.filmId = filmId;
  }

  public Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
}


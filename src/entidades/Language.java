package entidades;

import java.sql.Timestamp;

public class Language {
    private int language_id;
    private String name;
    private Timestamp last_update;
  
    public Language(int id, String name, Timestamp last_update) {
      this.language_id = id;
      this.name = name;
      this.last_update = last_update;
    }
  
    public int getId() {
      return language_id;
    }
  
    public void setId(int id) {
      this.language_id = id;
    }
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public Timestamp getLastUpdate() {
      return last_update;
    }
  
    public void setLastUpdate(Timestamp last_update) {
      this.last_update = last_update;
    }
}

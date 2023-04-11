package entidades;

import java.sql.Timestamp;

public class Actor {
    private int actor_id;
    private String first_name;
    private String last_name;
    private Timestamp last_update;
    
    public Actor(int actor_id, String first_name, String last_name, Timestamp last_update) {
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }
    
    // Getter and Setter methods
    
    public int getActor_id() {
        return actor_id;
    }
    
    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
    
    public String getFirst_name() {
        return first_name;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public Timestamp getLast_update() {
        return last_update;
    }
    
    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public String toString() {
        return "Actor #" + actor_id + ": " + first_name + " " + last_name + " (Last update: " + /**last_update.toString()  + */ ")";
      }
}

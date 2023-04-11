package entidades;

import java.sql.Timestamp;


public class Inventary {
    
   private int inventoryId;
   private int filmId;
   private int storeId;
   private Timestamp lastUpdate;

   public Inventary(int inventoryId, int filmId, int storeId, Timestamp lastUpdate) {
      this.inventoryId = inventoryId;
      this.filmId = filmId;
      this.storeId = storeId;
      this.lastUpdate = lastUpdate;
   }

   // Getters and Setters
   public int getInventoryId() {
      return inventoryId;
   }

   public void setInventoryId(int inventoryId) {
      this.inventoryId = inventoryId;
   }

   public int getFilmId() {
      return filmId;
   }

   public void setFilmId(int filmId) {
      this.filmId = filmId;
   }

   public int getStoreId() {
      return storeId;
   }

   public void setStoreId(int storeId) {
      this.storeId = storeId;
   }

   public Timestamp getLastUpdate() {
      return lastUpdate;
   }

   public void setLastUpdate(Timestamp lastUpdate) {
      this.lastUpdate = lastUpdate;
   }
}


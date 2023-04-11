package entidades;

import java.sql.Timestamp;

public class Film {
  private int film_id;
  private String title;
  private String description;
  private int release_year;
  private int language_id;
  private int original_language_id;
  private int rental_duration;
  private double rental_rate;
  private int length;
  private double replacement_cost;
  private String rating;
  //private String[] special_features;
  //private Timestamp last_update;
  
  
                        public Film(int id, String title, String desc, int year, int lang_id, int orig_lang_id,
                                    int rent_dur, double rent_rate, int len, double repl_cost, String rating
              /*, String[] spec_feat, Timestamp last_upd */ ) {
   this.film_id = id;
   this.title = title;
   this.description = desc;
   this.release_year = year;
   this.language_id = lang_id;
   this.original_language_id = orig_lang_id;
   this.rental_duration = rent_dur;
   this.rental_rate = rent_rate;
   this.length = len;
   this.replacement_cost = repl_cost;
   this.rating = rating;
  // this.special_features = spec_feat;
   //this.last_update = last_upd;
 }

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

public int getRelease_year() {
	return release_year;
}

public void setRelease_year(int release_year) {
	this.release_year = release_year;
}

public int getLanguage_id() {
	return language_id;
}

public void setLanguage_id(int language_id) {
	this.language_id = language_id;
}

public int getOriginal_language_id() {
	return original_language_id;
}

public void setOriginal_language_id(int original_language_id) {
	this.original_language_id = original_language_id;
}

public int getRental_duration() {
	return rental_duration;
}

public void setRental_duration(int rental_duration) {
	this.rental_duration = rental_duration;
}

public double getRental_rate() {
	return rental_rate;
}

public void setRental_rate(double rental_rate) {
	this.rental_rate = rental_rate;
}

public int getLength() {
	return length;
}

public void setLength(int length) {
	this.length = length;
}

public double getReplacement_cost() {
	return replacement_cost;
}

public void setReplacement_cost(double replacement_cost) {
	this.replacement_cost = replacement_cost;
}

public String getRating() {
	return rating;
}

public void setRating(String rating) {
	this.rating = rating;
}

}
/* 
public String[] getSpecial_features() {
	return special_features;
}

public void setSpecial_features(String[] special_features) {
	this.special_features = special_features;
}

public Timestamp getLast_update() {
	return last_update;
}

public void setLast_update(Timestamp last_update) {
	this.last_update = last_update;
}

 // getters/setters for all fields

}
*/
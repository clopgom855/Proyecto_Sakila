package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Category {
    
  // atributos de la clase
  private int category_id;
  private String name;
  private Timestamp last_update;

  // constructor por defecto
  public Category() {}

  // constructor con parámetros
  public Category(int category_id, String name, Timestamp last_update) {
    this.category_id = category_id;
    this.name = name;
    this.last_update = last_update;
  }

  // getters y setters para los atributos
  public int getCategory_id() {
    return category_id;
  }
  public void setCategory_id(int category_id) {
    this.category_id = category_id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Timestamp getLast_update() {
    return last_update;
  }
  public void setLast_update(Timestamp last_update) {
    this.last_update = last_update;
  }

  // método que inserta una nueva categoría en la base de datos
  public void insertCategory(Connection con) throws SQLException {
    PreparedStatement ps = con.prepareStatement("INSERT INTO category (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
    ps.setString(1, name);
    ps.executeUpdate();
    ResultSet rs = ps.getGeneratedKeys();
    if (rs.next()) {
      category_id = rs.getInt(1);
    }
  }

  // método que actualiza una categoría existente en la base de datos
  public void updateCategory(Connection con) throws SQLException {
    PreparedStatement ps = con.prepareStatement("UPDATE category SET name=?, last_update=CURRENT_TIMESTAMP WHERE category_id=?");
    ps.setString(1, name);
    ps.setInt(2, category_id);
    ps.executeUpdate();
  }

  // método que borra una categoría existente en la base de datos
  public void deleteCategory(Connection con) throws SQLException {
    PreparedStatement ps = con.prepareStatement("DELETE FROM category WHERE category_id=?");
    ps.setInt(1, category_id);
    ps.executeUpdate();
  }

  // método que obtiene todas las categorías existentes en la base de datos
  public static List<Category> getAllCategories(Connection con) throws SQLException {
    List<Category> categories = new ArrayList<Category>();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM category");
    while (rs.next()) {
      Category category = new Category();
      category.setCategory_id(rs.getInt("category_id"));
      category.setName(rs.getString("name"));
      category.setLast_update(rs.getTimestamp("last_update"));
      categories.add(category);
    }
    return categories;
  }

  // método que obtiene una categoría existente en la base de datos por su ID
  public static Category getCategoryById(Connection con, int categoryId) throws SQLException {
    Category category = null;
    PreparedStatement ps = con.prepareStatement("SELECT * FROM category WHERE category_id=?");
    ps.setInt(1, categoryId);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      category = new Category();
      category.setCategory_id(rs.getInt("category_id"));
      category.setName(rs.getString("name"));
      category.setLast_update(rs.getTimestamp("last_update"));
    }
    return category;
  }
}

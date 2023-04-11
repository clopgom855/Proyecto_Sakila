package entidades;
import java.sql.Blob;
import java.sql.Timestamp;

public class Staff {
   
    private int staff_id;
    private String first_name;
    private String last_name;
    private int address_id;
    private Blob picture;
    private String email;
    private int store_id;
    private boolean active;
    private String username;
    private String password;
    private Timestamp last_update;
    
    public Staff(int staff_id, String first_name, String last_name, int address_id, Blob picture, String email, int store_id, boolean active, String username, String password, Timestamp last_update) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address_id = address_id;
        this.picture = picture;
        this.email = email;
        this.store_id = store_id;
        this.active = active;
        this.username = username;
        this.password = password;
        this.last_update = last_update;
    }
    
    public int getStaff_id() {
        return this.staff_id;
    }
    
    public String getFirst_name() {
        return this.first_name;
    }
    
    public String getLast_name() {
        return this.last_name;
    }
    
    public int getAddress_id() {
        return this.address_id;
    }
    
    public Blob getPicture() {
        return this.picture;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public int getStore_id() {
        return this.store_id;
    }
    
    public boolean getActive() {
        return this.active;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public Timestamp getLast_update() {
        return this.last_update;
    }

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
}
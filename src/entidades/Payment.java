package entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Payment {
    
    private int payment_id;
    private int customer_id;
    private int staff_id;
    private int rental_id;
    private double amount;
    private Timestamp payment_date;
    private Timestamp last_update;

    public Payment(int payment_id, int customer_id, int staff_id, int rental_id, double amount, Timestamp payment_date, Timestamp last_update) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.staff_id = staff_id;
        this.rental_id = rental_id;
        this.amount = amount;
        this.payment_date = payment_date;
        this.last_update = last_update;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getPayment_date() {
        return payment_date;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayment_date(Timestamp payment_date) {
        this.payment_date = payment_date;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public static Payment createPayment(ResultSet resultSet) throws SQLException {
        int payment_id = resultSet.getInt("payment_id");
        int customer_id = resultSet.getInt("customer_id");
        int staff_id = resultSet.getInt("staff_id");
        int rental_id = resultSet.getInt("rental_id");
        double amount = resultSet.getDouble("amount");
        Timestamp payment_date = resultSet.getTimestamp("payment_date");
        Timestamp last_update = resultSet.getTimestamp("last_update");
        return new Payment(payment_id, customer_id, staff_id, rental_id, amount, payment_date, last_update);
    }
}

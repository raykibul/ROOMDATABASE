package cgpakoto.com.roomdatabase;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Semister {

    @PrimaryKey(autoGenerate = true)
    int id;
    double semister_gpa;
    double semister_credit;
    String semister_name;

    public Semister(double semister_gpa, double semister_credit, String semister_name) {
        this.semister_gpa = semister_gpa;
        this.semister_credit = semister_credit;
        this.semister_name = semister_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSemister_gpa() {
        return semister_gpa;
    }

    public void setSemister_gpa(double semister_gpa) {
        this.semister_gpa = semister_gpa;
    }

    public double getSemister_credit() {
        return semister_credit;
    }

    public void setSemister_credit(double semister_credit) {
        this.semister_credit = semister_credit;
    }

    public String getSemister_name() {
        return semister_name;
    }

    public void setSemister_name(String semister_name) {
        this.semister_name = semister_name;
    }
}

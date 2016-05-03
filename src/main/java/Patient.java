import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import org.sql2o.*;

public class Patient {
  private int id;
  private String name;
  private int doctorID;
  private String birthdate;

  public Patient(String name, int doctorID, String birthdate) {
    this.name = name;
    this.doctorID = doctorID;
    this.birthdate = birthdate;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public int getDoctorID() {
    return doctorID;
  }

  public static List<Patient> all() {
    String sql = "SELECT id, name, doctorid FROM patients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Patient.class);
    }
  }

  @Override
  public boolean equals(Object otherPatient){
    if (!(otherPatient instanceof Patient)) {
      return false;
    } else {
      Patient newPatient = (Patient) otherPatient;
      return this.getName().equals(newPatient.getName()) &&
             this.getId() == newPatient.getId() &&
             this.getDoctorID() == newPatient.getDoctorID();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO Patients(name, birthdate, doctorID) VALUES (:name, :birthdate, :doctorID)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("birthdate", this.birthdate)
        .addParameter("doctorID", this.doctorID)
        .executeUpdate()
        .getKey();
    }
  }

  public static Patient find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM Patients where id=:id";
      Patient Patient = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Patient.class);
      return Patient;
    }
  }


}

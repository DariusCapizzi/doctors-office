import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;

public class PatientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctor_office_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deletePatientsQuery = "DELETE FROM patients *;";
      String deleteDoctorQuery = "DELETE FROM doctors *;";
      con.createQuery(deletePatientsQuery).executeUpdate();
      con.createQuery(deleteDoctorQuery).executeUpdate();
    }
  }

  @Test
  public void Patient_instantiatesCorrectly_true() {
    Patient myPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    assertEquals(true, myPatient instanceof Patient);
  }

  @Test
  public void getDescription_instantiatesWithDescription_String() {
    Patient myPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    assertEquals("Mow the lawn", myPatient.getName());
  }
  @Test
  public void all_emptyAtFirst() {
    assertEquals(Patient.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfDescriptionsAretheSame() {
    Patient firstPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    Patient secondPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    assertTrue(firstPatient.equals(secondPatient));
  }

  @Test
  public void find_findsPatientInDatabase_true() {
    Patient myPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    myPatient.save();
    Patient savedPatient = Patient.find(myPatient.getId());
    assertTrue(myPatient.equals(savedPatient));
  }

  @Test
  public void save_assignsIdToObject() {
    Patient myPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    myPatient.save();
    Patient savedPatient = Patient.all().get(0);
    assertEquals(myPatient.getId(), savedPatient.getId());
  }

  @Test
  public void save_returnsTrueIfDescriptionsAretheSame() {
    Patient myPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    myPatient.save();
    assertTrue(Patient.all().get(0).equals(myPatient));
  }

  @Test
  public void save_savesDoctorIdIntoDB_true() {
    Doctor myDoctor = new Doctor("Household chores", "speciality");
    myDoctor.save();
    Patient myPatient = new Patient("Mow the lawn", myDoctor.getId(), "2000-00-00");
    myPatient.save();
    Patient savedPatient = Patient.find(myPatient.getId());
    assertEquals(savedPatient.getDoctorID(), myDoctor.getId());
  }

  @Test
  public void getId_PatientsInstantiateWithAnID_1() {
    Patient myPatient = new Patient("Mow the lawn", 1, "2000-01-01");
    myPatient.save();
    assertEquals(1, myPatient.getDoctorID());
  }

  @Test
  public void find_returnsNullWhenNoPatientFound_null() {
    assertTrue(Patient.find(999) == null);
  }

}

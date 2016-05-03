import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class DoctorTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctor_office_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deletePatientsQuery = "DELETE FROM patients *;";
      String deleteDoctorsQuery = "DELETE FROM doctors *;";
      con.createQuery(deletePatientsQuery).executeUpdate();
      con.createQuery(deleteDoctorsQuery).executeUpdate();
    }
  }

  @Test
  public void Doctor_instantiatesCorrectly_true() {
    Doctor myDoctor = new Doctor("Household chores", "hey");
    assertEquals(true, myDoctor instanceof Doctor);
  }

  @Test
  public void getName_DoctorInstantiatesWithName_String() {
    Doctor myDoctor = new Doctor("Household chores", "blah");
    assertEquals("Household chores", myDoctor.getName());
    assertEquals("blah", myDoctor.getSpecial());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Doctor.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Doctor firstDoctor = new Doctor("Household chores", "blah");
    Doctor secondDoctor = new Doctor("Household chores", "blah");
    assertTrue(firstDoctor.equals(secondDoctor));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Doctor myDoctor = new Doctor("Household chores", "blah");
    myDoctor.save();
    assertTrue(Doctor.all().get(0).equals(myDoctor));
  }

  @Test
  public void save_assignsIdToObject() {
    Doctor myDoctor = new Doctor("Household chores", "blah");
    myDoctor.save();
    Doctor savedDoctor = Doctor.all().get(0);
    assertEquals(myDoctor.getId(), savedDoctor.getId());
  }

  @Test
  public void find_findDoctorInDatabase_true() {
    Doctor myDoctor = new Doctor("Household chores", "blah");
    myDoctor.save();
    Doctor savedDoctor = Doctor.find(myDoctor.getId());
    assertTrue(myDoctor.equals(savedDoctor));
  }

  @Test
  public void getPatients_retrievesALlPatientsFromDatabase_tasksList() {
    Doctor myDoctor = new Doctor("Household chores", "blah");
    myDoctor.save();
    Patient firstPatient = new Patient("Mow the lawn", myDoctor.getId(), "2000-00-00");
    firstPatient.save();
    Patient secondPatient = new Patient("Do the dishes", myDoctor.getId(), "2000-00-00");
    secondPatient.save();
    Patient[] patients = new Patient[] { firstPatient, secondPatient };
    assertTrue(myDoctor.getPatients().containsAll(Arrays.asList(patients)));
  }
}

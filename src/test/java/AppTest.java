// import org.fluentlenium.adapter.FluentTest;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.htmlunit.HtmlUnitDriver;
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.fluentlenium.core.filter.FilterConstructor.*;
// import org.junit.*;
// import java.util.List;
// import org.sql2o.*;
//
// public class AppTest extends FluentTest {
//   public WebDriver webDriver = new HtmlUnitDriver();
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/to_do_test", null, null);
//   }
//
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String deleteTasksQuery = "DELETE FROM tasks *;";
//       String deleteCategoriesQuery = "DELETE FROM categories *;";
//       con.createQuery(deleteTasksQuery).executeUpdate();
//       con.createQuery(deleteCategoriesQuery).executeUpdate();
//     }
//   }
//
//   @Override
//   public WebDriver getDefaultDriver() {
//     return webDriver;
//   }
//
//   @ClassRule
//   public static ServerRule server = new ServerRule();
//
//   @Test
//   public void rootTest() {
//     goTo("http://localhost:4567/");
//     assertThat(pageSource()).contains("Couch!");
//     assertThat(pageSource()).contains("View Category List");
//     assertThat(pageSource()).contains("Add a New Category");
//   }
//   @Test
//   public void categoryIsCreatedTest(){
//     goTo("http://localhost:4567/");
//     click("a", withText("Add a New Category"));
//     fill("#newCategory").with("Household chores");
//     submit(".btn");
//     assertThat(pageSource()).contains("Your category has been saved.");
//   }
//
//   @Test
//   public void categoryIsDisplayedTest() {
//     Category myCategory = new Category("Household chores");
//     myCategory.save();
//     System.out.println(myCategory.getId());
//     String categoryPath = String.format("http://localhost:4567/categories/%d", myCategory.getId());
//     goTo(categoryPath);
//     assertThat(pageSource()).contains("Household chores");
//   }
//
//   @Test
//   public void categoryShowPageDisplaysName() {
//     goTo("http://localhost:4567/categories/new");
//     fill("#newCategory").with("Household chores");
//     submit(".btn");
//     click("a", withText("View categories"));
//     click("a", withText("Household chores"));
//     assertThat(pageSource()).contains("Household chores");
//   }
//   @Test
//   public void categoryTasksFormIsDisplayed() {
//     goTo("http://localhost:4567/categories/new");
//     fill("#newCategory").with("Shopping");
//     submit(".btn");
//     click("a", withText("View categories"));
//     click("a", withText("Shopping"));
//     click("a", withText("Add a new task"));
//     assertThat(pageSource()).contains("Add a task to Shopping");
//   }
//
//   @Test
//   public void allTasksDisplayDescriptionOnCategoryPage() {
//     Category myCategory = new Category("Household chores");
//     myCategory.save();
//     Task firstTask = new Task("Mow the lawn", myCategory.getId(), "2000-00-00");
//     firstTask.save();
//     Task secondTask = new Task("Do the dishes", myCategory.getId(), "2000-00-00");
//     secondTask.save();
//     String categoryPath = String.format("http://localhost:4567/categories/%d", myCategory.getId());
//     goTo(categoryPath);
//     assertThat(pageSource()).contains("Mow the lawn");
//     assertThat(pageSource()).contains("Do the dishes");
//  }
//
//     @Test
//     public void tasksIsAddedAndDisplayed() {
//       goTo("http://localhost:4567/categories/new");
//       fill("#newCategory").with("Banking");
//       submit(".btn");
//       click("a", withText("View categories"));
//       click("a", withText("Banking"));
//       click("a", withText("Add a new task"));
//       fill("#description").with("Deposit paycheck");
//       submit(".btn");
//       click("a", withText("View categories"));
//       click("a", withText("Banking"));
//       assertThat(pageSource()).contains("Deposit paycheck");
//     }
//
//   @Test
//   public void taskNotFoundMessageShown() {
//     goTo("http://localhost:4567/tasks/999");
//     assertThat(pageSource()).contains("Task not found");
//   }
// }

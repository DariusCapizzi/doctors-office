import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    //
    // get("/", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/index.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/categories/new", (request, response) -> {
    //   HashMap<String,Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/new-category-form.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/categories", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   String categoryName = request.queryParams("newCategory");
    //   Category newCategory = new Category(categoryName);
    //   newCategory.save();
    //   model.put("template", "templates/category-success.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/categories", (request, response) -> {
    //   HashMap<String,Object> model = new HashMap<String,Object>();
    //   model.put("categories", Category.all());
    //   model.put("template", "templates/categories.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/categories/:id", (request,response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Category category = Category.find(Integer.parseInt(request.params(":id")));
    //   model.put("category", category);
    //   model.put("template", "templates/category.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("categories/:id/tasks/new", (request, response) -> {
    //   HashMap<String,Object> model = new HashMap<String,Object>();
    //     Category category = Category.find(Integer.parseInt(request.params(":id")));
    //     model.put("category", category);
    //     model.put("template", "templates/category-tasks-form.vtl");
    //     return new ModelAndView(model, layout);
    //   }, new VelocityTemplateEngine());
    //
    // post("/tasks", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));
    //   String description = request.queryParams("description");
    //   String due_date = request.queryParams("due-date");
    //   Task newTask = new Task(description, category.getId(), due_date);
    //   newTask.save();
    //   model.put("category", category);
    //   model.put("template", "templates/category-tasks-success.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("tasks/new", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/task-form.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/tasks", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("tasks", Task.all());
    //   model.put("template", "templates/tasks.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/tasks/:id", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   Task task = Task.find(Integer.parseInt(request.params(":id")));
    //   model.put("task", task);
    //   model.put("template", "templates/task.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }
}

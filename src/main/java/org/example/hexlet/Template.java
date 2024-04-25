package org.example.hexlet;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;
import org.example.hexlet.model.Course;
import org.example.hexlet.dto.courses.CoursePage;

public class Template {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

//        app.get("/", ctx -> ctx.render("index.jte"));
        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
//            var course = /* Курс извлекается из базы данных. Как работать с базами данных мы разберем в следующих уроках */
            var page = new CoursePage(course);
            ctx.render("courses/show.jte", model("page", page));
        });
        app.start(7070);
    }
}

package org.example.hexlet;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;

import java.util.ArrayList;
import java.util.List;

public class Template {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/courses", ctx -> {
            var header = "Programming courses";
            List<Course> db = new ArrayList<>();
//            CoursesPage courseData = new CoursesPage();
            var page = new CoursesPage();
            ctx.render("courses/index.jte", model("page", page));
        });
        app.start(7070);
    }
}

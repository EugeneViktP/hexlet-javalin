package org.example.hexlet;

import io.javalin.Javalin;

public class DynamicRoutes {
    public static void main(String[] args) {
        var app = Javalin.create(config ->
                config.bundledPlugins.enableDevLogging());
        app.get("/hello/{name}/lastname/{surname}", ctx -> {
            ctx.result("Hello: " + ctx.pathParam("name") + " " + ctx.pathParam("surname"));
//            ctx.result("Lastname: " + ctx.pathParam("surname"));
            });
        app.start(7070);
    }
}

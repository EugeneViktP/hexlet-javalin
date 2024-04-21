package org.example.hexlet;

import io.javalin.Javalin;

public class GreetByName {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/hello", ctx -> {
            var names = ctx.queryParamAsClass("name", String.class).getOrDefault("World");
            ctx.result("Hello " + names + "!");
        });
        app.start(7070); // Стартуем веб-сервер
    }
}

package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.NotFoundResponse;
import exercise.util.Security;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void launch(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        LoginPage page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var encryptedPassword = Security.encrypt(password);

        if (UsersRepository.findByName(name) == null) {
            LoginPage page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        } else if (!encryptedPassword.equals(UsersRepository.findByName(name).getPassword())) {
            LoginPage page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        } else {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect("/");
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }
    // END
}

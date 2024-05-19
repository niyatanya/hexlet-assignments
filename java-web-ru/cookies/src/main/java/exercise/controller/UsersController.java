package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        String firstName = ctx.formParamAsClass("firstName", String.class).get();
        String lastName = ctx.formParamAsClass("lastName", String.class).get();
        String email = ctx.formParamAsClass("email", String.class).get();
        String password = ctx.formParamAsClass("password", String.class).get();
        String token = Security.generateToken();

        User user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect("/users/" + user.getId());
    }

    public static void show(Context ctx) {
        String pathToken = ctx.cookie("token");
        var id = ctx.pathParam("id");
        var user = UserRepository.find(Long.valueOf(id));
        String userToken = user.get().getToken();
        if (pathToken.equals(userToken)) {
            UserPage page = new UserPage(user.get());
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect("/users/build");
        }
    }
    // END
}

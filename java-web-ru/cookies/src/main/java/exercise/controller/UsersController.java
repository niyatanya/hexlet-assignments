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
        String firstName = StringUtils.capitalize(ctx.formParam("firstName"));
        String lastName = StringUtils.capitalize(ctx.formParam("lastName"));
        String email = ctx.formParam("email").trim().toLowerCase();
        String password = ctx.formParam("password");
        String encryptedPassword = Security.encrypt(password);
        String token = Security.generateToken();

        User user = new User(firstName, lastName, email, encryptedPassword, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        String pathToken = ctx.cookie("token");
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        String userToken = user.getToken();
        if (pathToken.equals(userToken)) {
            UserPage page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}

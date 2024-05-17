package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import java.util.Objects;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", model("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
           BuildArticlePage page = new BuildArticlePage();
           ctx.render("articles/build.jte", model("page", page));
        });

            app.post("/articles", ctx -> {
                try {
                    String title = ctx.formParamAsClass("title", String.class)
                            .check(value -> value.length() > 1, "Название не должно быть короче двух символов")
                            .check(value -> titleIsUnique(value), "Статья с таким названием уже существует")
                            .get();
                    String content = ctx.formParamAsClass("content", String.class)
                            .check(value -> value.length() > 9, "Статья должна быть не короче 10 символов")
                            .get();
                    Article article = new Article(title, content);
                    ArticleRepository.save(article);
                    ctx.redirect("/articles");
                } catch (ValidationException e) {
                    String returnTitle = ctx.formParam("title");
                    String returnContent = ctx.formParam("content");
                    BuildArticlePage page = new BuildArticlePage(returnTitle, returnContent, e.getErrors());
                    ctx.render("articles/build.jte", model("page", page)).status(422);
                }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static boolean titleIsUnique(String title) {
        List<Article> articles = ArticleRepository.getEntities();
        List<Article> articlesWithSameTitle = articles.stream()
                .filter(a -> a.getTitle().equals(title))
                .toList();
        return articlesWithSameTitle.isEmpty();
    }
}

package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.List;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.repository.PostRepository;
import exercise.model.Post;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        Post post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }

    public static void index(Context ctx) {
    Integer pageNum = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
    List<Post> posts = PostRepository.findAll(pageNum, 5);
    PostsPage page = new PostsPage(posts, pageNum);
    ctx.render("posts/index.jte", model("page", page));
    }
    // END
}

@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    content = @`
    <h1>Посты</h1>
    @if(page.getPosts().isEmpty())
        <h2>На этой странице нет постов</h2>
    @else
        @for(var post : page.getPosts())
            <div>
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
            </div>
        @endfor
    @endif
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath(String.valueOf(page.getPageNum() < 2 ? 1 : page.getPageNum() - 1))}">Назад</a></li>
            <li class="page-item"><a class="page-link" href="${NamedRoutes.postsPath(String.valueOf(page.getPageNum() + 1))}">Вперед</a></li>
        </ul>
    </nav>
`
)

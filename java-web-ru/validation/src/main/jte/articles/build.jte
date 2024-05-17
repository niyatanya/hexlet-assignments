@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
        <main>
            <form action="/articles" method="post">
                <div class="mx-auto p-4 py-md-5">
                <label>
                    Название
                    <input type="text" name="title" value="${page.getTitle()}">
                </label>
                </div>
                <div class="mx-auto p-4 py-md-5">
                <label>
                    Пост
                <textarea name="content">${page.getContent()}</textarea>
                </label>
                </div>
                <div class="mx-auto p-4 py-md-5">
                    <input type="submit" value="Опубликовать">
                </div>
                <div>
                    @if(page.getErrors() != null)
                        <ul>
                            @for(var validator : page.getErrors().values())
                                @for(var error : validator)
                                    <li>${error.getMessage()}</li>
                                @endfor
                            @endfor
                        </ul>
                    @endif
                </div>
            </form>
        </main>
    `
)

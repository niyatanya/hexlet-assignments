@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
    <main>
        @if(page.getName() != null)
            Добро пожаловать, ${page.getName().toString()}.
            <a href="${NamedRoutes.logoutPath()}">Выйти</a>
        @else
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @endif
    </main>
`
)

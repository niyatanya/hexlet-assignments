@import exercise.dto.users.UsersPage

@param UsersPage page

@template.layout.page(
content = @`
    <h2>Регистрация нового пользователя</h2>
    <form action="/users" method="post">
        <div>
        <label>
            Имя
            <input type="text" required name="firstName">
        </label>
        </div>
        <div>
        <label>
            Фамилия
            <input type="text" required name="lastName">
        </label>
        </div>
        <div>
        <label>
            Email
            <input type="text" required name="email">
        </label>
        </div>
        <div>
        <label>
            Пароль
            <input type="text" required name="password">
        </label>
        </div>
        <input type="submit" name="Create user">
    </form>
`
)

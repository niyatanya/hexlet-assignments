@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Users</title>
</head>
<body>
<main>
@if(page.getUsers().isEmpty())
    <p>В системе пока не зарегистрирован ни один пользователь</p>
@endif
    <div class="mx-auto p-4 py-md-5">
            <h1>Пользователи</h1>
            <table class="table table-striped">
                @for(var user : page.getUsers())
                    <tr>
                        <td>
                            ${user.getId()}
                        </td>
                        <td>
                            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                        </td>
                    </tr>
                @endfor
            </table>
        </div>
    </main>
</body>
</html>
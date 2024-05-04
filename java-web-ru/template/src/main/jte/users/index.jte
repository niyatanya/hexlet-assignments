@import exercise.dto.users.UsersPage
@import exercise.model.User
@param UsersPage page

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Users</title>
</head>
<body>
<main>
@if(page.getUsers().isEmpty())
    <p>В системе пока не зарегистрирован ни один пользователь</p>
@else
    @for(User user : page.getUsers())
        <div>
            <h2><a href="/users/${user.getId()}">${user.getLastName()}</a></h2>
            <p>${user.getFirstName()}</p>
        </div>
    @endfor
@endif
</main>
</body>
</html>
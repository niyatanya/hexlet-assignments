@import exercise.dto.users.UserPage
@import exercise.model.User
@param UserPage page1

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>${page1.getUser().getLastName()}</title>
</head>
<body>
<main>
    <h1>${page1.getUser().getLastName()}</h1>
    <p>${page1.getUser().getFirstName()}</p>
    <p>${page1.getUser().getEmail()}</p>
    <p>${page1.getUser().getId()}</p>
</main>
</body>
</html>
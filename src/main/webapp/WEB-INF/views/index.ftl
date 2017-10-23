<html>

<head>
  <title>Welcome!</title>
  <meta charset="UTF-8">
  <title>Login Form</title>
</head>

<body>

  <h2>${message!""}</h2>
  <h2>${errorMessage!""}</h2>

  <#if username??>
    <h1> Welcome, ${username}</h1>
    <h2><a href="/logout">Logout</a></h2>

    <#else>

      <h1><a href="/login">Log In</a></h1>
  </#if>

</body>

</html>
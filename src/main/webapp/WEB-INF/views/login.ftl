<#import "/spring.ftl" as spring/>

<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="static/style.css">

</head>

<body>

<h2>${message!""}</h2>
<h2 style="color: red">${errorMessage!""}</h2>

<ul class="tab-group">
    <li class="tab active"><a href="/register">Sign Up</a></li>
    <li class="tab"><a href="/login">Log In</a></li>
</ul>


<div class="form">
    <form action="/login" method="post" id="loginForm" name="loginForm">
        <label for="username">Username</label>
        <input type="text" name="username" id="username" placeholder="username" autocomplete="off"/>

        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="password"/>

        <button type="submit">Login</button>
    </form>
</div>


</body>

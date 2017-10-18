<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Welcome!</title>
    <meta charset="UTF-8">
    <title>Admin Page</title>
</head>
<body>

<h2>${message!""}</h2>
<h2>${errorMessage!""}</h2>


<#if username??>
<h1> Welcome, ${username}</h1>

<form name="searchForm" action="/search" method="post">
    <label>Search by Email:</label><input type="text" name="email" placeholder="Email"/>

    <input type="submit" value="Search">
</form>

<#if emails??>
<h3>Retrieved email:</h3>

<#list emails as email>
    <form name"retrieveUserData" action="/search" method="GET">
        <label>User Id:</label><input type="text" name="email" value = "${email.userid}" /></br>
        <label>User Ssn:</label><input type="text" name="ssn" value = "${email.ssn}" /></br>
        <label>User Password:</label><input type="text" name="password" value = "${email.password}" /></br>
        <label>User First Name:</label><input type="text" name="firstName" value = "${email.firstname}" /></br>
        <label>User Last Name:</label><input type="text" name="lastName" value = "${email.lastname}" /></br>
        <label>User Email:</label><input type="text" name="email" value = "${email.email}" /></br>
        <label>User Address:</label><input type="text" name="address" value = "${email.address}" />
    </form>
</#list>

<!--
<select id="emailList" name="select">

    <#list emails as email>
        <option>
        ${email.userid}
        ${email.ssn}
        ${email.firstname}
        ${email.lastname}
        ${email.email}
        </option>
    </#list>
</select>

-->
</#if>




<h2><a href="/logout">Logout</a></h2>

<#else>

<h1><a href="/login">Log In</a></h1>
</#if>

</body>
</html>
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
    <label>Search by SSN:</label><input type="text" name="ssn" placeholder="SSN"/>

    <input type="submit" value="Search">
</form>

<a href="http://localhost:8080/admin/home/insert">Insert</a>

<#if emails??>
<h3>Retrieved Users (Search via Email)</h3>

<#list emails as email>
    <form name"retrieveUserData" action="/search" method="post">
        <label>User Id:</label><input type="text" name="email" value = "${email.userid}" /></br>
        <label>User Ssn:</label><input type="text" name="ssn" value = "${email.ssn}" /></br>
        <label>User Password:</label><input type="text" name="password" value = "${email.password}" /></br>
        <label>User First Name:</label><input type="text" name="firstName" value = "${email.firstname}" /></br>
        <label>User Last Name:</label><input type="text" name="lastName" value = "${email.lastname}" /></br>
        <label>User Email:</label><input type="text" name="email" value = "${email.email}" /></br>
        <label>User Address:</label><input type="text" name="address" value = "${email.address}" /></br>

        <input type="submit" value="Update">
    </form>

</#list>
</#if>


<#if ssns??>
<h3>Retrieved Users (Search via SSN):</h3>
<#list ssns as ssn>
    <form name"retrieveUserData" action="/search" method="GET">
        <label>User Id:</label><input type="text" name="email" value = "${ssn.userid}" /></br>
        <label>User Ssn:</label><input type="text" name="ssn" value = "${ssn.ssn}" /></br>
        <label>User Password:</label><input type="text" name="password" value = "${ssn.password}" /></br>
        <label>User First Name:</label><input type="text" name="firstName" value = "${ssn.firstname}" /></br>
        <label>User Last Name:</label><input type="text" name="lastName" value = "${ssn.lastname}" /></br>
        <label>User Email:</label><input type="text" name="email" value = "${ssn.email}" /></br>
        <label>User Address:</label><input type="text" name="address" value = "${ssn.address}" /></br>
    </form>
</#list>
</#if>

<h2><a href="/logout">Logout</a></h2>

<#else>

<h1><a href="/login">Log In</a></h1>
</#if>

</body>
</html>
<#import "/spring.ftl" as spring/>
<html>

<head>
  <#include "master.ftl"/>
  <title>Welcome!</title>
  <meta charset="UTF-8">
  <title>Admin Page</title>
</head>

<body>
  <@navigationbar.navigationbar tab="admin" />
  <h2>${message!""}</h2>
  <h2>${errorMessage!""}</h2>

  <#if username??>
    <h1> Welcome, ${username}</h1>

    <#if repairList??>
      <h3>Retrieved Repairs:</h3>
      <table>
        <#list repairList as repair>
          <tr>
            <td> Cost:${repair.cost}</td>
            <td> Datetime: ${repair.datetime}</td>
            <td> Status: ${repair.status}</td>
            <td> Type: ${repair.type}</td>
          </tr>
        </#list>
      </table>
      <#else>
        <h2> No repairs found </h2>
    </#if>
  </#if>

</html>
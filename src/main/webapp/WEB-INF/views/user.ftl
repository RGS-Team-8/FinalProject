<#import "/spring.ftl" as spring/>
<html>
<head>
    <#include "masteruser.ftl"/>
    <title>Welcome!</title>
    <meta charset="UTF-8">
    <title>User Page</title>
</head>
<body>
<@navbaruser.navbaruser tab="user"/>

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

</body>
</html>
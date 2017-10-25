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
<div class="container">
<div class="row">
<div class="col-xs-12">
<table class="table">
  <#list repairList as repair>
    <thead>
        <tr>
            <td> Cost</td>
             <td> Datetime</td>
             <td> Status</td>
              <td> Type</td>
         </tr>
        </thead>
        <tbody>
           <tr>
            <td> ${repair.cost}</td>
            <td> ${repair.datetime}</td>
            <td> ${repair.status}</td>
            <td> ${repair.type}</td>
        </tr>
        </tbody>

    </#list>
</table>
</div>
</div>
</div>
<#else>
<h2> No repairs found </h2>

</#if>

</body>
</html>
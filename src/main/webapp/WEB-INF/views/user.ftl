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
    <center><h3><b>Retrieved Repairs:</b></h3></center>
    <div class="table-responsive">
<table class="table-table-striped">
  <#list repairList as repair>
      <form id="RetrivedRepairs" name="RetrievedRepairs" action="RetrievedRepairs">
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
      </form>
    </#list>
</table>
</div>
</div>
<#else>
<h2> No repairs found </h2>

</#if>

</body>
</html>
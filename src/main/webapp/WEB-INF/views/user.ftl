<#import "/spring.ftl" as spring/>
<html>

<head>
<#include "masteruser.ftl"/>
    <title>Welcome!</title>
    <meta charset="UTF-8">
    <title>User Page</title>

</head>

<body>
<@navbaruser.navbaruser tab="user" />

<#if repairList??>

<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <table class="table">

                <h3 align="center">Retrieved Repairs:</h3>
                    </div>
                <#list repairList as repair>
                    <thead>
                    <tr>
                        <td class="col-sm-1 "></td>
                        <td> Cost</td>
                        <td> Datetime</td>
                        <td> Status</td>
                        <td> Type</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="col-sm-1 "></td>
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
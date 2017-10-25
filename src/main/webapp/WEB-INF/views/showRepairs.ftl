<#import "/spring.ftl" as spring/>
<body>
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
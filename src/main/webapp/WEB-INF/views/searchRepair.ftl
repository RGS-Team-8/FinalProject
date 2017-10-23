<#import "/spring.ftl" as spring/>
<html>

<head>
  <#include "master.ftl"/>
  <meta charset="UTF-8">
  <title>Search Repair Page</title>
</head>

<body>
  <@navigationbar.navigationbar tab="admin" />

  <form name="searchRepairForm" action="searchRepair" method="post">
    <label>Search by SSN:</label><input type="text" name="ssn" placeholder="SSN" /></br>

    <input type="submit" value="Search">
  </form>

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
    </#if>


</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
  $('#delete').click(function() {
    $('#searchResults').attr('action', 'delete');
  });
</script>

</html>
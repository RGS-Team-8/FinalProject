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
      <label>Search by Datetime:</label><input type="datetime-local" name="datetime" placeholder="Datetime" /></br>
      <input type="submit" value="Search">
  </form>

  <#if repairList??>
    <h3>Retrieved Repairs (Search via Ssn)</h3>

    <#list repairList as repair>
      <form id="searchRepairResults" name="retrieveRepairData" action="updateRepair" method="post">

        <label>Repair Id:</label><input type="text" name="serviceid" value="${repair.serviceid}" /><br/>
        <label>Repair Cost:</label><input type="text" name="cost" value="${repair.cost}" /><br/>
        <label>Repair Datetime:</label><input type="datetime-local" name="datetime" value="${repair.datetime}" /><br/>
        <label>Repair Status:</label>

        <select name="status">
            <option value="Pending" <#if ("${repair.status}" == "Pending") > selected="selected"</#if> >Pending</option>
            <option value="In Progress" <#if ("${repair.status}" == "In Progress") > selected="selected"</#if> >In Progress</option>
            <option value="Completed" <#if ("${repair.status}" == "Completed") > selected="selected"</#if> >Completed</option>
        </select>

        <br/>

        <label>Repair Type:</label>

        <select name="type" value="${repair.type}">
                <option value="Minor Service" <#if ("${repair.type}" == "Minor Service") > selected="selected"</#if> >Minor Service</option>
                <option value="Major Service" <#if ("${repair.type}" == "Major Service") > selected="selected"</#if> >Major Service</option>
        </select>

        <br/>
        <label>Repair Description:</label><input type="text" name="freetext" value="${repair.freetext}" /><br/>
        <label>Repair Owner:</label><input type="text" name="userid" value="${repair.user.userid}" /><br/>

        <input type="submit" value="Update">
        <input type="submit" value="Delete">
      </form>
      </#list>
  </#if>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
  $('#delete').click(function() {
    $('#searchRepairResults').attr('action', 'deleteRepair');
  });
</script>

</html>
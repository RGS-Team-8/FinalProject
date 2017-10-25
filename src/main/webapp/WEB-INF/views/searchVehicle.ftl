<#import "/spring.ftl" as spring/>
<html>

<head>
  <#include "master.ftl"/>
  <meta charset="UTF-8">
  <title>Search Vehicle Page</title>
</head>

<body>
  <@navigationbar.navigationbar tab="admin" />

  <form name="searchVehicleForm" action="searchVehicle" method="post">
      <label>Search by SSN:</label><input type="text" name="ssn" placeholder="SSN" /></br>
      <label>Search by Plate:</label><input type="text" name="plate" placeholder="Plate" /></br>
      <input type="submit" value="Search">
  </form>

  <#if vehicleList??>
    <h3>Retrieved Vehicles (Search via Ssn)</h3>

    <#list vehicleList as vehicle>
      <form id="searchVehicleResults" name="retrieveVehicleData" action="updateVehicle" method="post">

        <label>Vehicle Id:</label><input type="text" name="id" value="${vehicle.id}" /><br/>
        <label>Vehicle Model:</label><input type="text" name="model" value="${vehicle.model}" /><br/>
        <label>Vehicle Brand:</label><input type="text" name="brand" value="${vehicle.brand}" /><br/>
        <label>Vehicle Year:</label><input type="text" name="year" value="${vehicle.year}" /><br/>
        <label>Vehicle Color:</label><input type="text" name="color" value="${vehicle.color}" /><br/>
        <label>Vehicle Plate:</label><input type="text" name="plate" value="${vehicle.plate}" /><br/>
        <label>Vehicle Owner:</label><input type="text" name="userid" value="${vehicle.user.userid}" /><br/>

        <input id="update" type="submit" value="Update">
        <input id="delete" type="submit" value="Delete">
      </form>
      </#list>
  </#if>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
  $('#delete').click(function() {
    $('#searchVehicleResults').attr('action', 'deleteVehicle');
  });
</script>

</html>
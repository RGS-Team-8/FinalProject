<#import "/spring.ftl" as spring/>
<html>

<head>
  <#include "master.ftl"/>
  <title>Insert Repair Page</title>
  <meta charset="UTF-8">
</head>

<body>

  <body>
    <@navigationbar.navigationbar tab="admin" />
    <form name="insertVehicleForm" modelAttribute="insertVehicleForm" action="/admin/vehicle/insertVehicle" method="post">


      <label>Vehicle Model:</label><input type="text" name="model" placeholder="Model" /><br/>
      <label>Vehicle Brand:</label><input type="text" name="brand" placeholder="Brand" /><br/>
      <label>Vehicle Year:</label><input type="text" name="year" placeholder="Year" /><br/>
      <label>Vehicle Color:</label><input type="text" name="color" placeholder="Color" /><br/>
      <label>Vehicle Plate:</label><input type="text" name="plate" placeholder="Plate" /><br/>
      <label>Vehicle Userid:</label><input type="text" name="userid" placeholder="Userid" /><br/>

      <input type="submit" value="Insert">
    </form>
  </body>

</html>
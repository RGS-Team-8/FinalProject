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
    <form name="insertRepairForm" modelAttribute="insertRepairForm" action="/admin/repair/insertRepair" method="post">


      <label>Repair Cost:</label><input type="text" name="cost" placeholder="Cost" /><br/>
      <label>Repair Datetime:</label><input type="datetime-local" name="datetime" placeholder="Datetime" /><br/>
      <label>Repair Status:</label>

      <select name="status">
        <option value="Pending">Pending</option>
        <option value="In Progress">In Progress</option>
        <option value="Completed">Completed</option>
      </select>

      <br/>

      <label>Repair Type:</label>

        <select name="type">
            <option value="Minor Service">Minor Service</option>
            <option value="Major Service">Major Service</option>
        </select>

      <br/>
      <label>Repair Description:</label><input type="text" name="freetext" placeholder="Description" /><br/>
      <label>Repair Owner:</label><input type="text" name="userid" placeholder="UserID" /><br/>

      <input type="submit" value="Insert">
    </form>
  </body>

</html>
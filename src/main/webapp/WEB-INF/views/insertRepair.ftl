<#import "/spring.ftl" as spring/>
<html>

<head>
    <#include "master.ftl"/>
    <title>Insert Repair Page</title>
    <meta charset="UTF-8">
</head>

<body>
<@navigationbar.navigationbar tab="admin" />

<div class="container">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">

        <h3 align="center">Insert Repair Details</h3>

        <form name="insertRepairForm" modelAttribute="insertRepairForm" action="/admin/repair/insertRepair"
              method="post">

            <label>Repair Cost:</label><input class="form-control input-lg" type="text" name="cost" placeholder="Cost"/><br/>
            <label>Repair Datetime:</label><input class="form-control input-lg" type="datetime-local" name="datetime" placeholder="Datetime"/><br/>
            <label>Repair Status:</label>

            <select class="form-control input-lg" name="status">
                <option value="Pending">Pending</option>
                <option value="In Progress">In Progress</option>
                <option value="Completed">Completed</option>
            </select><br/>

            <label>Repair Type:</label>

            <select class="form-control input-lg" name="type">
                <option value="Minor Service">Minor Service</option>
                <option value="Major Service">Major Service</option>
            </select><br/>

            <label>Repair Description:</label><textarea class="form-control" type="text" rows="3" style="resize:none;" name="freetext" placeholder="Description"/></textarea><br/>
            <label>Repair Owner:</label><input class="form-control input-lg" type="text" name="userid" placeholder="UserID"/><br/>

            <input class="btn btn-md col-sm-12 btn-success input-lg" type="submit" value="Insert">
        </form>
    </div>
    <div class="col-sm-2"></div>
</div>
</body>

</html>

<#import "/spring.ftl" as spring/>
<html>

<head>
  <#include "master.ftl"/>
  <title>Insert Owner Page</title>
  <meta charset="UTF-8">

</head>


<body>
<@navigationbar.navigationbar tab="admin" />

<div class="container">
  <form name="insertForm" modelAttribute="insertForm" class="well form-horizontal" action="/admin/repair/insertRepair " method="post"  id="vehicle_service_form">

    <!-- Form Name -->
    <legend><center><h2><b>Vehicle Service Form</b></h2></center></legend><br>

    <!-- Text input-->

    <div class="form-group">
      <label class="col-md-4 control-label" >Repair Cost</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-eur"></i></span>
          <input name="repair_cost" placeholder="Cost" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-4 control-label" >Repair Datetime</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
          <input name="repair_datetime" placeholder="Datetime" class="form-control"  type="datetime-local">
        </div>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label">Repair Status</label>
      <div class="col-md-4 selectContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-tasks"></i></span>
          <select name="department" class="form-control selectpicker">
            <option value="">Current status</option>
              <option>&#8226 Pending</option>
            <option>&#8226 In Progress</option>
              <option>&#8226 Completed</option>
          </select>
        </div>
      </div>
    </div>
      <div class="form-group">
          <label class="col-md-4 control-label">Repair Type</label>
          <div class="col-md-4 selectContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                  <select name="department" class="form-control selectpicker">
                      <option value="">Select service type</option>
                      <option>&#8226 Minor service</option>
                      <option>&#8226 Major service</option>
                  </select>
              </div>
          </div>
      </div>
      <div class="form-group">
          <label class="col-md-4 control-label">Repair Description</label>
          <div class="col-md-4 inputGroupContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-info-sign"></i></span>
                  <textarea class="form-control" rows="5" style="resize:none;" id="comment" placeholder="Comments..."></textarea>
              </div>
          </div>
      </div>
    <div class="form-group">
      <label class="col-md-4 control-label">Repair Owner</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
          <input  name="repair_owner" placeholder="Owner's SSN" class="form-control"  type="text">
        </div>
      </div>
    </div>


    <div class="form-group">
      <label class="col-md-4 control-label"></label>
      <div class="col-md-4"><br>
        <button type="submit" class="btn btn-success btn-block">Submit</button>
      </div>
    </div>



  </form>


</div>
</body>

</html>
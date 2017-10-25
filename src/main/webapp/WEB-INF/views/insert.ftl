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
  <form data-toggle="validator" role="form" name="insertForm" modelAttribute="insertForm" class="well form-horizontal" action="/admin/owner/insert " method="post"  id="register_form">

    <!-- Form Name -->
    <legend><center><h2><b>User Registration Form</b></h2></center></legend><br>

    <!-- Text input-->

    <div class="form-group">
      <label class="col-md-4 control-label" >First name</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
          <input name="firstname" placeholder="First name" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-4 control-label" >Last name</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
          <input name="lastname" placeholder="Last name" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-4 control-label" >Password</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
          <input name="password" placeholder="Password" class="form-control"  type="password" id="inputPassword" required>
        </div>
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-4 control-label">Confirm password</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
          <input type="password"  placeholder="Confirm password" class="form-control" name="password-confirm" id="inputConfirmPassword"
                 data-match="#inputPassword" required/>
        </div>
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-4 control-label">E-Mail</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
          <input name="email" placeholder="Email" class="form-control"  type="text">
        </div>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label">SSN</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-certificate"></i></span>
          <input  name="ssn" placeholder="SSN" class="form-control"  type="text">
        </div>
      </div>
    </div>

    <div class="form-group">
      <label class="col-md-4 control-label">Type of user</label>
      <div class="col-md-4 selectContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
          <select name="typeofuser" class="form-control selectpicker">
            <option value="">Select your type</option>
            <option>ADMIN</option>
            <option>USER</option>
          </select>
        </div>
      </div>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" >Address</label>
      <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
          <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
          <input name="address" placeholder="Address" class="form-control"  type="text">
        </div>
      </div>
    </div>


    <!-- Button -->
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
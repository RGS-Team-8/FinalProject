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
  <form data-toggle="validator" role="form" name="registerForm" modelAttribute="insertForm"
        class="well form-horizontal" action="/admin/owner/insert " method="post"  id="register_form">

<!-- Form Name -->
<legend><center><h2><b>Registration Form</b></h2></center></legend><br>

<!-- Text input-->

      <div class="form-group">
          <label class="col-md-4 control-label" >First name</label>
          <div class="col-md-4 inputGroupContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                  <input name="firstname" placeholder="First name" class="form-control"
                         type="text" id="firstName"
                         pattern="[A-Za-z]+"
                         oninvalid="this.setCustomValidity('Required, please enter your first name.Your first name may only contain lower and upper-case letters.')"
                         oninput="setCustomValidity('')"  required/>
              </div>
              <div class="help-block with-errors"></div>
          </div>
      </div>

      <div class="form-group">
          <label class="col-md-4 control-label" >Last name</label>
          <div class="col-md-4 inputGroupContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                  <input name="last_name" placeholder="Last name" class="form-control"  type="text"
                         pattern="[A-Za-z]+"
                         oninvalid="this.setCustomValidity('Required, please enter your last name.Your last name may only contain lower and upper-case letters.')"
                         oninput="setCustomValidity('')"  required/>
              </div>
              <div class="help-block with-errors"></div>
          </div>
      </div>

      <div class="form-group">
          <label class="col-md-4 control-label" >Password</label>
          <div class="col-md-4 inputGroupContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                  <input name="user_password" placeholder="Password" class="form-control"  type="password" id="inputPassword"
                         oninvalid="this.setCustomValidity('Required, please enter your password.')"
                         oninput="setCustomValidity('')"   required>
              </div>
              <div class="help-block with-errors"></div>
          </div>
      </div>

      <div class="form-group">
          <label class="col-md-4 control-label">Confirm password</label>
          <div class="col-md-4 inputGroupContainer">
              <div class="input-group">

              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

              <input type="password"  placeholder="Confirm password" class="form-control" name="confirmPassword"
                     id="inputConfirmPassword"
                     data-match="#inputPassword" data-match-error="Password and Confirm Password don't match."
                     oninvalid="this.setCustomValidity('Required, please confirm your password.')"
                     oninput="setCustomValidity('')"required/>

          </div>

              <div class="help-block with-errors"></div>
          </div>
      </div>

 <div class="form-group">
  <label class="col-md-4 control-label">E-Mail</label>
    <div class="col-md-4 inputGroupContainer">
      <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
         <input name="email" placeholder="Email" class="form-control"  type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
         oninvalid="this.setCustomValidity('Required, please enter a valid email address.')"
         oninput="setCustomValidity('')" required>
      </div>
        <div class="help-block with-errors"></div>
    </div>
</div>
      <div class="form-group">
          <label class="col-md-4 control-label">SSN</label>
          <div class="col-md-4 inputGroupContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-certificate"></i></span>
                  <input  name="ssn" placeholder="SSN" class="form-control"  type="text" pattern="[1-9]{1}[0-9]{8}"
                          oninvalid="this.setCustomValidity('Required, please enter your 9-digit SSN.')"
                          oninput="setCustomValidity('')" required>

              </div>
              <div class="help-block with-errors"></div>
          </div>
      </div>

      <div class="form-group">
          <label class="col-md-4 control-label">Type of user</label>
          <div class="col-md-4 selectContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                  <select name="department" class="form-control selectpicker"
                          oninvalid="this.setCustomValidity('Required, choose one option from the list.')"
                          oninput="setCustomValidity('')"  required>
                      <option value="">Select your type</option>
                      <option>Admin</option>
                      <option>User</option>
                  </select>
              </div>
              <div class="help-block with-errors"></div>
          </div>
      </div>
      <div class="form-group">
          <label class="col-md-4 control-label" >Address</label>
          <div class="col-md-4 inputGroupContainer">
              <div class="input-group">
                  <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                  <input name="address" placeholder="Address" class="form-control"  type="text" pattern="[A-Za-z-.]+[ ]+[0-9]{1,4}$"
                         oninvalid="this.setCustomValidity('Required, please enter your address.')"
                         oninput="setCustomValidity('')"  required  >
              </div>
              <div class="help-block with-errors"></div>
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
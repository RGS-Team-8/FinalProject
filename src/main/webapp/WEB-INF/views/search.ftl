<#import "/spring.ftl" as spring/>

<html>

<head>
  <#include "master.ftl"/>
  <meta charset="UTF-8">
  <title>Search Owner Page</title>

</head>

<body>
  <@navigationbar.navigationbar tab="admin" />
  <div class="container">
    <div class="row">

      <form class="form-inline" role="search" name="searchForm" action="search" method="post">
        <div class="col-md-6" >

          <label>Search by Email:</label>
          <div class="input-group">
            <input type="text" class="form-control" placeholder="Email" name="Email" id="email">
            <div class="input-group-btn">
              <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
            </div>
          </div>
        </div>
        <label>Search by SSN:</label>
        <div class="input-group">
          <input type="text" class="form-control" placeholder="SSN" name="Ssn" id="ssn">
          <div class="input-group-btn">
            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
          </div>
        </div>

      </form>
    </div>
  </div>
  <#if emailsorssns??>
    <center><h3><b>Retrieved Users (Search via Email Or Ssn)</b></h3></center>>

    <div class="table-responsive">
      <table class="table table-striped">
      <form  id="searchResults" name="retrieveUserData" action="update" method="post">

          <thead>
          <tr>
            <th>User Id</th>
            <th>SSN</th>
            <th>Password</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>User Type</th>
            <th colspan="2">Action</th>

          </tr>
          </thead>
          <tbody>
        <#list emailsorssns as emailsorssn>
          <thead>
          <tr>
            <td class="col-sm-1"><input class="form-control" type="text" name="userid"
                                        value="${emailsorssn.userid}"/></td>
            <td class="col-sm-1"><input class="form-control" type="text" name="ssn"
                                        value="${emailsorssn.ssn}"/></td>
            <td class="col-sm-2"><input class="form-control" type="password" name="password"
                                        value="${emailsorssn.password}"/></td>
            <td class="col-sm-1"><input class="form-control" type="text" name="firstname"
                                        value="${emailsorssn.firstname}"/></td>
            <td class="col-sm-1"><input class="form-control" type="text" name="lastname"
                                        value="${emailsorssn.lastname}"/></td>
            <td class="col-sm-2"><input class="form-control" type="email" name="email"
                                        value="${emailsorssn.email}"/></td>

            <td class="col-sm-1"><input class="form-control" type="text" name="address"
                                        value="${emailsorssn.address}"/></td>
            <td class="col-sm-1"><input class="form-control" type="text" name="typeofuser"
                                        value="${emailsorssn.typeofuser}"/></td>
            <td class="col-sm-1">
              <input class="btn btn-md" id="update" type="submit" value="Update">
              <input class="btn btn-danger btn-md" id="delete" type="submit" value="Delete">
            </td>
          </tr>
      </thead>>
            </#list>
          </tbody>

      </form>
      </table>
    </div>
  </#if>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
  $("#search").click(function() {
    if ($(document.forms["searchUserBar"].value).indexOf("@") >=0) {
    $("#searchUserBar").attr("name", "email"); }
  });
</script>
<script type="text/javascript">
  $('#delete').click(function() {
    $('#searchResults').attr('action', 'delete');
  });
</script>

</html>
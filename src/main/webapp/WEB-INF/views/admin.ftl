<#import "/spring.ftl" as spring/>
<html>

<head>
  <#include "master.ftl"/>
  <meta charset="UTF-8">
  <title>Admin Page</title>
</head>

<body>
  <@navigationbar.navigationbar tab="admin" />

  <#if username??>
  <h1 align="center"> Welcome, ${username}</h1>

  <h2 align="center">${message!""}</h2>
  <h2 align="center">${errorMessage!""}</h2>

    <#if repairList??>
      <h3 align="center">Retrieved Repairs:</h3>
      <div class="table-responsive">
        <table class="table table-striped">

          <#list repairList as repair>
            <form id="searchRepairResults" name="retrieveRepairData" action="updateRepair" method="post">

              <thead>
                <tr>
                  <th class="col-sm-1">Id</th>
                  <th class="col-sm-1">Cost</th>
                  <th class="col-sm-2">Datetime</th>
                  <th class="col-sm-1">Status</th>
                  <th class="col-sm-1">Type</th>
                  <th class="col-sm-4">Description</th>
                  <th class="col-sm-1">Owner</th>
                  <th class="col-sm-1"></th>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td class="col-sm-1"><p class="form-control-static">${repair.serviceid}</p></td>
                  <td class="col-sm-1"><p class="form-control-static">${repair.cost}</p></td>
                  <td class="col-sm-2"><p class="form-control-static">${repair.datetime}</p></td>
                  <td class="col-sm-1"><p class="form-control-static">${repair.status}</p></td>
                  <td class="col-sm-1"><p class="form-control-static">${repair.type}</p></td>
                  <td class="col-sm-4"><p class="form-control-static">${repair.freetext}</p></td>
                  <td class="col-sm-1"><p class="form-control-static">${repair.user.userid}</p></td>
                  <td class="col-sm-1"></td>
                </tr>
              </tbody>

            </form>
          </#list>
        </table>
      </div>
      <#else>
        <h2> No repairs found </h2>
      </#if>
    </#if>
</body>
</html>
<#import "/spring.ftl" as spring/>
<html>

<head>
    <#include "master.ftl"/>
    <title>Search Repair Page</title>
    <meta charset="UTF-8">
</head>

<body>
<@navigationbar.navigationbar tab="admin" />

  <form name="searchRepairForm" action="searchRepair" method="post">
      <label>Search by SSN:</label><input type="text" name="ssn" placeholder="SSN" />
      <input type="submit" value="Search"></br>
      <label>Search by Range of Datetime:</label>
      <input type="datetime-local" name="datetime" placeholder="Datetime" />
      <input type="datetime-local" name="datetime2" placeholder="Datetime" />
      <input type="submit" value="Search"></br>
  </form>

  <#if repairList??>
    <h3>Retrieved Repairs (Search via Ssn)</h3>
<#if repairList??>

    <h3 align="center">Retrieved Repairs (Search via Ssn)</h3>

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
                        <td class="col-sm-1"><input class="form-control" type="text" name="serviceid"
                                                    value="${repair.serviceid}"/></td>
                        <td class="col-sm-1"><input class="form-control" type="text" name="cost"
                                                    value="${repair.cost}"/></td>
                        <td class="col-sm-2"><input class="form-control" type="datetime-local" name="datetime"
                                                    value="${repair.datetime}"/></td>
                        <td class="col-sm-1">
                            <select class="form-control" name="status">
                                <option value="Pending"
                                <#if ("${repair.status}" == "Pending") > selected="selected"</#if>
                                >Pending</option>
                                <option value="In Progress"
                                <#if ("${repair.status}" == "In Progress") > selected="selected"</#if>
                                >In Progress</option>
                                <option value="Completed"
                                <#if ("${repair.status}" == "Completed") > selected="selected"</#if>
                                >Completed</option>
                            </select>
                        </td>
                        <td class="col-sm-1">
                            <select class="form-control" name="type" value="${repair.type}">
                                <option value="Minor Service"
                                <#if ("${repair.type}" == "Minor Service") > selected="selected"</#if>
                                >Minor Service</option>
                                <option value="Major Service"
                                <#if ("${repair.type}" == "Major Service") > selected="selected"</#if>
                                >Major Service</option>
                            </select>
                        </td>
                        <td class="col-sm-4"><textarea class="form-control" type="text" rows="3" style="resize:none;" name="freetext"/>${repair.freetext}</textarea>
                        </td>
                        <td class="col-sm-1"><input class="form-control" type="text" name="userid"
                                                    value="${repair.user.userid}"/>
                        </td>
                        <td class="col-sm-1">
                            <input class="btn btn-md" id="update" type="submit" value="Update">
                            <input class="btn btn-danger btn-md" id="delete" type="submit" value="Delete">
                        </td>
                    </tr>




            </tbody>

            </form>
            </#list>
        </table>
    </div>


</#if>
</#if>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$('#delete').click(function() {
$('#searchRepairResults').attr('action', 'deleteRepair');
});

</script>

</html>
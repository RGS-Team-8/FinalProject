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
    <form data-toggle="validator" role="form" name="insertServiceForm" modelAttribute="insertServiceForm"
          class="well form-horizontal" action="/admin/repair/insertRepair " method="post"  id="service_form">

        <!-- Form Name -->
        <legend><center><h2><b>Service Form</b></h2></center></legend><br>

        <!-- Text input-->

        <div class="form-group">
            <label class="col-md-4 control-label" >Repair Cost</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-eur"></i></span>
                    <input name="cost" placeholder="Cost" class="form-control"  type="text" pattern="[0-9.]+"
                           oninvalid="this.setCustomValidity('Required, please enter the cost of service.')"
                           oninput="setCustomValidity('')" required>
                </div>
                <div class="help-block with-errors"></div>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" >Repair Datetime</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                    <input name="datetime" placeholder="Datetime" class="form-control"  type="datetime-local"
                           oninvalid="this.setCustomValidity('Required, please choose a datetime.')"
                           oninput="setCustomValidity('')"  required >
                </div>
                <div class="help-block with-errors"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Repair Status</label>
            <div class="col-md-4 selectContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-tasks"></i></span>
                    <select name="status" class="form-control selectpicker"
                            oninvalid="this.setCustomValidity('Required, please choose a current status.')"
                            oninput="setCustomValidity('')" required >
                        <option value="">Current status</option>
                        <option>&#8226 Pending</option>
                        <option>&#8226 In Progress</option>
                        <option>&#8226 Completed</option>
                    </select>
                </div>
                <div class="help-block with-errors"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Repair Type</label>
            <div class="col-md-4 selectContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                    <select name="type" class="form-control selectpicker"
                            oninvalid="this.setCustomValidity('Required, please choose a type of service.')"
                            oninput="setCustomValidity('')" required >
                        <option value="">Select service type</option>
                        <option>&#8226 Minor service</option>
                        <option>&#8226 Major service</option>
                    </select>
                </div>
                <div class="help-block with-errors"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Repair Description</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-comment"></i></span>
                    <textarea name="freetext" class="form-control" rows="5" style="resize:none;" id="comment" placeholder="Comments..."
                              oninvalid="this.setCustomValidity('Required, please make a description of service.')"
                              oninput="setCustomValidity('')" required  ></textarea>
                </div>
                <div class="help-block with-errors"></div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-4 control-label">Owner</label>
            <div class="col-md-4 inputGroupContainer">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input  name="userid" placeholder="Owner's id" class="form-control"  type="text" pattern="[1-9]"
                            oninvalid="this.setCustomValidity('Required, please enter valid user id (a number).')"
                            oninput="setCustomValidity('')" required>
                </div>
                <div class="help-block with-errors"></div>
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
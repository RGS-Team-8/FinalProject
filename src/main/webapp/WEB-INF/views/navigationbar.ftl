<#macro navigationbar tab>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="navigationbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin/home"><span style="color:white"><b>Car Repair Services</b></span></a>
        </div>
        <div class="collapse navbar-collapse" id="navigationbar">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Owner <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <#if tab == "create">
                            <li class="active"><span class="glyphicon glyphicon-user"></span> <a href="#">Create</a></li>
                        <#else>
                            <li><a href="http://localhost:8080/admin/owner/insert"><span class="glyphicon glyphicon-user"></span> Create</a></li>
                        </#if>
                        <#if tab == "search">
                            <li class="active"><a href="#"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                        <#else>
                            <li><a href="http://localhost:8080/admin/owner/search"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                        </#if>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Service<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <#if tab == "create">
                            <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span> Create</a></li>
                        <#else>
                            <li><a href="http://localhost:8080/admin/repair/insertRepair"><span class="glyphicon glyphicon-wrench"></span> Create</a></li>
                        </#if>
                        <#if tab == "search">
                            <li class="active"><a href="#"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                        <#else>
                            <li><a href="http://localhost:8080/admin/repair/searchRepair"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                        </#if>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Vehicle<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <#if tab == "create">
                            <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span> Create</a></li>
                        <#else>
                            <li><a href="http://localhost:8080/admin/vehicle/insertVehicle"><span class="glyphicon glyphicon-road"></span> Create</a></li>
                        </#if>
                        <#if tab == "search">
                            <li class="active"><a href="#"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                        <#else>
                            <li><a href="http://localhost:8080/admin/vehicle/searchVehicle"><span class="glyphicon glyphicon-search"></span> Search</a></li>
                        </#if>
                    </ul>
                </li>
            </ul>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login"><span class="glyphicon glyphicon-log-out" style="color:white"></span><span style="color:white"><b> Log out</b></span></a></li>
            </ul>
        </div>
    </div>
</nav>

<nav class="navbar navbar-inverse navbar-fixed-bottom">
    <div class="container-fluid">
        <li role="separator" class="divider"></li>
        <p class="navbar-text"><center><span style="color:white"><b>Copyright &copy Car Repair Services 2017</b></span></center></p>
        <li role="separator" class="divider"></li>
    </div>
    </div>
</nav>


</#macro>
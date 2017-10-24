
<#macro navigationbar tab>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="navigationbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><span style="color:white"><b>Car Repair Services</b></span></a>
    </div>

    <div class="collapse navbar-collapse" id="navigationbar">
      <ul class="nav navbar-nav">
      <#if tab == "home">
        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span>&nbspHome</a></li>
       <#else>
        <li><a href="#"><span class="glyphicon glyphicon-home"></span>&nbspHome</a></li>
        </#if>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span>&nbspOwner <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <#if tab == "create">
            <li class="active"><span class="glyphicon glyphicon-user"></span> <a href="#">&nbspCreate</a></li>
           <#else>
            <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp Create</a></li>
           </#if>

            <#if tab == "search">
              <li class="active"><a href="#"><span class="glyphicon glyphicon-search"></span>&nbspSearch</a></li>
              <#else>
               <li><a href="#"><span class="glyphicon glyphicon-search"></span>&nbsp Search</a></li>
            </#if>
          </ul>
        </li>
        <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-wrench"></span>&nbspService<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <#if tab == "create">
                       <li class="active"><a href="#"><span class="glyphicon glyphicon-wrench"></span>&nbsp Create</a></li>
                  <#else>
                    <li><a href="#"><span class="glyphicon glyphicon-wrench"></span>&nbsp Create</a></li>
                  </#if>

                  <#if tab == "search">
                      <li class="active"><a href="#"><span class="glyphicon glyphicon-search"></span> &nbspSearch</a></li>
                  <#else>
                      <li><a href="#"><span class="glyphicon glyphicon-search"></span>&nbsp Search</a></li>
                  </#if>
              </ul>
            </li>

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
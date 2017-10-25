<#macro navbaruser tab>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="navbaruser">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/user/home"><span style="color:white"><b>Car Repair Services</b></span></a>
    </div>

    <div class="collapse navbar-collapse" id="navbaruser">
      <ul class="nav navbar-nav">
      <#if tab == "home">
        <li class="active"><a href="#">Home</a></li>
       <#else>
        <li><a href="/user/home">Home</a></li>
        </#if>
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

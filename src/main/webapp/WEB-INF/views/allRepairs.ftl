<html>
<head>
<title>Welcome to Spring Web MVC project</title>
</head>

<body>
    <form:form action="/user/" method="POST"  modelAttribute="repairListWrapper">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Serviceid</th>
                        <th>Cost</th>
                        <th>Datetime</th>
                        <th>Status</th>
                        <th>Type<th>
                        <th>Freetext<th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach varStatus="us" var="user" items="${repairListWrapper.users}" >
                        <tr>
                            <td><form:input type="hidden" path="repair[${us.index}]."/>${repair.serviceid}</td>
                            <td><form:input type="hidden" path="repair[${us.index}].lastName"/> ${repair.cost}</td>
                            <td><form:input type="hidden" path="users[${us.index}].login"/>${repair.status}</td>
                            <td><form:input type="hidden" path="users[${us.index}].professi"/>${repair.type}</td>
                            <td><form:checkbox path="users[${us.index}].delete" value="${user.delete}"/></td>
             <form:input type="hidden" path="users[${us.index}].id"/>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            </form:form>
</body>

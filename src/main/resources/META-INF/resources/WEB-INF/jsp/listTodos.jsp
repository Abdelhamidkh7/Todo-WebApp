
<%@ include file="common/header.jspf"   %>


<%@ include file="common/navigation.jspf"   %>



<div class="container">
<!-- <div>Welcome ${name}</div> -->

<hr>
<h1>Your todos</h1>
<table class="table">
<thead>
    <tr>

<th>Description</th>
<th>Target Date</th>
<th>Is Done?</th>
<th></th>
<th></th>
</tr>

</thead>
<tbody>
    <c:forEach items = "${Todo}" var = "todo">

    <tr>
        
        <td>${todo.description}</td>
        <td>${todo.targetDate}</td>
        <td>${todo.done}</td>
        
    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">delete</a></td>
    <td><a href="update-todo?id=${todo.id}" class="btn btn-success">update</a></td>
</tr>

    </c:forEach>

</tbody>


</table>
<a href="add-todo" class="btn btn-success">Add Tudo</a>
</div>
<%@ include file="common/footer.jspf"   %>


</body>

</html>
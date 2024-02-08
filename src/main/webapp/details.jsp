<%@ page import="tascks.entity.TaskEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="boostrap/bootstrap.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<%
    TaskEntity task = (TaskEntity) request.getAttribute("task");
%>

<div style="display: flex; justify-content: center; width: 700px">
    <form action="/updateTask" method="post" style="width: 100%;">
        <div class="mb-3">
            <label class="form-label">Наименование:</label>
            <input class="form-control" placeholder="Наименование..." name="name" value="<%=task.getName()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Описание:</label>
            <textarea class="form-control" rows="3" placeholder="Описание..." name="description"><%=task.getDescription()%></textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">Крайний срок:</label>
            <input type="date" class="form-control" name="deadlineDate" value="<%=task.getDeadlineDate()%>">
        </div>
        <select class="form-select mb-3" name="isDone">
            <option selected value="<%=task.isDone()%>"><%=task.isDone() ? "Да" : "Нет"%></option>
            <option value="<%=!task.isDone()%>"><%=task.isDone() ? "Нет" : "Да"%></option>
        </select>
        <button class="btn btn-success">Сохранить</button>
    </form>
</div>

<%--Добавить кнопку удалить с модальным окном с текстом 'Вы действительно хотите удалить задание?'--%>

</body>
</html>
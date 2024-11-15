<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 13/11/24
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sinh-vien/update" method="post">
    <input type="hidden" name="ma" value="${student.ma}">
    Tên: <input type="text" name="ten" value="${student.ten}"> <br>
    Tuổi: <input type="number" name="tuoi" value="${student.tuoi}"> <br>
    Địa chỉ: <input type="text" name="diaChi" value="${student.diaChi}"> <br>
    Giới tính:
    <input type="radio" name="gioiTinh" ${student.gioiTinh == true ? "checked" : ""} value="true" > Nam
    <input type="radio" name="gioiTinh" ${student.gioiTinh == false ? "checked" : ""} value="false"> Nữ
    <br>
    <button type="submit" onclick="return confirm('Bạn có muốn update không')">Update</button>
</form>
</body>
</html>

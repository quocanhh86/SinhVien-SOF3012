<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<table border="1">
    <form action="/sinh-vien/add" method="post">
        Tên: <input type="text" name="ten" value="${student.ten}"> <br>
        Tuổi: <input type="number" name="tuoi" value="${student.tuoi}"> <br>
        Địa chỉ: <input type="text" name="diaChi" value="${student.diaChi}"> <br>
        Giới tính:
        <input type="radio" name="gioiTinh" ${student.gioiTinh == true ? "checked" : ""} value="true" > Nam
        <input type="radio" name="gioiTinh" ${student.gioiTinh == false ? "checked" : ""} value="false"> Nữ
        <br>
        <button type="submit" onclick="return confirm('Bạn có muốn add không')">Add</button>
    </form>
    <thead>
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Giới tinh</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${listStudent}" var="s">
            <tr>
                <td>${s.ma}</td>
                <td>${s.ten}</td>
                <td>${s.tuoi}</td>
                <td>${s.diaChi}</td>
                <td>${s.gioiTinh?"Nam":"Nữ"}</td>
                <td>
                    <button>
                        <a href="/sinh-vien/detail?id=${s.ma}">
                            Detail
                        </a>
                    </button>
                    <button>
                        <a href="/sinh-vien/view-update?id=${s.ma}">
                            Update
                        </a>
                    </button>
                    <button>
                        <a href="/sinh-vien/remove?id=${s.ma}">
                            Remove
                        </a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>

package com.example.SinhVien.controller;

import com.example.SinhVien.model.SinhVien;
import com.example.SinhVien.repository.SinhVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "ServletSinhVien",
        value = {
        "/sinh-vien/hien-thi",
        "/sinh-vien/detail",
        "/sinh-vien/add",
        "/sinh-vien/remove",
        "/sinh-vien/view-update",
        "/sinh-vien/update",
})
public class ServletSinhVien extends HttpServlet {
    private SinhVienRepository repository = new SinhVienRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sinh-vien/hien-thi")){
            this.viewStudents(request, response);
        } else if (uri.contains("/sinh-vien/detail")){
            this.detailStudent(request,response);
        } else if (uri.contains("/sinh-vien/view-update")){
            this.viewUpdateStudent(request,response);
        } else {
            this.removeStudent(request, response);
        }
    }

    private void removeStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id  = Integer.parseInt(request.getParameter("id"));
        SinhVien sv = repository.getOne(id);
        repository.deleteSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void viewUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SinhVien sv = repository.getOne(id);
        request.setAttribute("student", sv);
        request.getRequestDispatcher("/view/update.jsp").forward(request, response);
    }

    private void detailStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SinhVien sv = repository.getOne(id);
        request.setAttribute("student", sv);
        request.setAttribute("listStudent", repository.getAll());
        request.getRequestDispatcher("/view/hien-thi.jsp").forward(request, response);
    }

    private void viewStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listStudent", repository.getAll());
        request.getRequestDispatcher("/view/hien-thi.jsp").forward(request,response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sinh-vien/add")){
            this.addStudent(request,response);
        } else {
            this.updateStudent(request, response);
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        int id = Integer.parseInt(request.getParameter("ma"));
        SinhVien sv = repository.getOne(id);
        BeanUtils.populate(sv, request.getParameterMap());
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv, request.getParameterMap());
        repository.addSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }
}

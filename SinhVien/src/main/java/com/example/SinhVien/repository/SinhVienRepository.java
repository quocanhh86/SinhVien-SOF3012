package com.example.SinhVien.repository;

import com.example.SinhVien.model.SinhVien;
import com.example.SinhVien.utils.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    Session s;
    public SinhVienRepository(){
        s = HibernateConfig.getFACTORY().openSession();
    }
    public List<SinhVien> getAll(){
        return s.createQuery("FROM SinhVien ").list();
    }
    public SinhVien getOne(Integer id){
        return s.find(SinhVien.class, id);
    }
    public void addSinhVien(SinhVien sv){
        try {
            s.getTransaction().begin();
            s.save(sv);
            s.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void updateSinhVien(SinhVien sv){
        try {
            s.getTransaction().begin();
            s.merge(sv);
            s.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    public void deleteSinhVien(SinhVien sv){
        try {
            s.getTransaction().begin();
            s.delete(sv);
            s.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
}

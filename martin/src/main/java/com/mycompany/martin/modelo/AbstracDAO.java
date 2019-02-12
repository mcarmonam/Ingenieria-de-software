/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.martin.modelo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mcfly
 */
public abstract class AbstracDAO<T> {
    
    protected SessionFactory sessionFactory;
    
    public AbstracDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    protected void save(T obj){
        Session session=this.sessionFactory.openSession();
        Transaction tx =null;
        try{
            tx=session.beginTransaction();
            session.save(obj);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally{
            session.close();
        }
    }
    protected void update(T obj){}
    protected void delete(T obj){
        
    }
    protected T find(Class clazz, int id){
        T obj=null;
        Session session =this.sessionFactory.getCurrentSession();
        Transaction tx = null;
        try{
            tx=session.beginTransaction();
            obj=(T)session.get(clazz, id);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return obj;
    }
    protected List<T> findAll(Class clazz){
        List<T> obj = null;
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tx=null;
        try{
            tx =session.beginTransaction();
            String hql = "From"+clazz;
            Query query = session.createQuery(hql);
            obj =(List<T>)query.list();      
        }catch(HibernateException e){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return obj;
    }
}



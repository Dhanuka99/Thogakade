package dao.custom.impl;

import dao.custom.CustomerDAO;
import entity.Customer;
import lk.ijse.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.delete(s);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Customer search(String s) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select * from Customer where id=?");
        List list = sqlQuery.list();



        transaction.commit();
        session.close();
        return (Customer) list;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        return null;
    }

    @Override
    public String getID() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("select id from Customer order by id desc limit 1");
        String id = (String) sqlQuery.uniqueResult();
        System.out.println("dao "+id);
        transaction.commit();
        session.close();

        return id;
    }
}

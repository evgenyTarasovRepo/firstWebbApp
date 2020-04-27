package DAO;

import HibernateUtil.HibernateUtil;
import org.hibernate.query.Query;
import ru.tarasov.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {


    @Override
    public List<Employee> get() {
        Transaction transaction = null;
        List<Employee> list = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            list = new ArrayList<Employee>();
            //Query query = session.createQuery("from Employee ");
            Query query = session.createQuery("from Employee e order by e.id");
            list = query.getResultList();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Employee employee) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee select(int id) {
        Transaction transaction = null;
        Employee employee = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);

            transaction.commit();
            session.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.update(employee);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Employee employee = session.get(Employee.class, id);
            session.delete(employee);
            flag = true;
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}

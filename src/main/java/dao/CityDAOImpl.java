package dao;

import hibernate.HibernateSessionFactoryUtil;
import model.City;
import org.hibernate.Session;

import org.hibernate.Transaction;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    @Override
    public void create(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }
    @Override
    public City getById(int cityId) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, cityId);
    }

    @Override
    public List<City> getAllCities() {
        return (List<City>)  HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("from City").list();
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            org.hibernate.Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }

}


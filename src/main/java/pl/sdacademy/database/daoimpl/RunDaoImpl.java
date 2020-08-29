package pl.sdacademy.database.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.sdacademy.database.dao.RunDao;
import pl.sdacademy.database.entity.Run;
import pl.sdacademy.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class RunDaoImpl implements RunDao {
  @Override
  public void save (Run run) {
	SessionFactory factory = HibernateUtils
		.getInstance()
		.getSessionfactory();

	Session session = factory.getCurrentSession();
	session.beginTransaction();
	session.saveOrUpdate(run);
	session.getTransaction().commit();
	session.close();
  }

  @Override
  public Run findByID (Long id) {
	Session session = HibernateUtils
		.getInstance()
		.getSessionfactory()
		.getCurrentSession();

	session.beginTransaction();
	Run run = null;

	try{
	  run = session
		  .createQuery("from Run where id=:id", Run.class)
		  .setParameter("id", id)
		  .getSingleResult();

	}catch(NoResultException e){

	}

	return run;
  }

  @Override
  public List<Run> findAll () {
	Session session = HibernateUtils
		.getInstance()
		.getSessionfactory()
		.getCurrentSession();

	List<Run> list = session
		.createQuery("from Run")
		.list();

	session.getTransaction().commit();
	session.close();

	return list;
  }

  @Override
  public void delete (Integer id) {
	Session session = HibernateUtils
		.getInstance()
		.getSessionfactory()
		.getCurrentSession();

	session.beginTransaction();

	session.createQuery("delete Run where id=:id")
		.setParameter("id", id)
		.executeUpdate();

	session.getTransaction().commit();
	session.close();
  }
}

package pl.sdacademy.database.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
  private static HibernateUtils INSTANCE = null;
  private SessionFactory sessionFactory;

  private HibernateUtils() {
	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
		.configure("hibernate.xml")
		.build();
	Metadata metadata = new MetadataSources(standardRegistry)
		.getMetadataBuilder()
		.build();
	sessionFactory = metadata
		.getSessionFactoryBuilder()
		.build();
  }


  public static HibernateUtils getInstance() {
	if(INSTANCE == null){
	  INSTANCE = new HibernateUtils();
	}
	return INSTANCE;
  }

  public SessionFactory getSessionfactory(){
    return sessionFactory;
  }
}

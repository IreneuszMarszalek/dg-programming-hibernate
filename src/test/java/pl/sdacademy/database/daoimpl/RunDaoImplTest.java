package pl.sdacademy.database.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.database.dao.RunDao;
import pl.sdacademy.database.entity.Run;
import pl.sdacademy.database.utils.HibernateUtils;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunDaoImplTest {
  @BeforeEach
void clearBeforeEach(){
    Session session = HibernateUtils.getInstance().getSessionfactory().getCurrentSession();
    session.beginTransaction();
    session.createSQLQuery("delete from RUN").executeUpdate();
    session.getTransaction().commit();
    session.close();
  }

  @Test
  void save () {
    RunDao dao = new RunDaoImpl();
    Run run = new Run();
    run.setName("Duzo");
    run.setMembersLimit(1212);

    dao.save(run);
    Run saved = dao.findByID(run.getId());

    assertNotNull(saved);
    assertEquals(run.getId(), saved.getId());
    assertEquals(run.getName(), saved.getName());
    assertEquals(run.getMembersLimit(), saved.getMembersLimit());
  }

  @Test
  void findByID () {
  }

  @Test
  void findAll () {
    RunDao dao = new RunDaoImpl();
    Run run1 = new Run();
    Run run2 = new Run();

    run1.setName("Bieg 1");
    run1.setMembersLimit(200);

    run2.setName("Bieg 2");
    run2.setMembersLimit(150);

    dao.save(run1);
    dao.save(run2);

    List<Run> runsList = dao.findAll();

    assertNotNull(runsList);
    assertEquals(2, runsList.size());

    Run found1 = null;

    if (runsList.get(0).getId() == run1.getId()) {
      found1 = runsList.get(0);
    } else {
      found1 = runsList.get(1);
    }

    assertNotNull(found1);
    assertEquals(run1.getId(), found1.getId());
    assertEquals(run1.getName(), found1.getName());
    assertEquals(run1.getMembersLimit(), found1.getMembersLimit());

  }
  @Test
  void delete () {
  }
}
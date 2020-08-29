package pl.sdacademy.database.daoimpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.sdacademy.database.dao.RunMemberDao;
import pl.sdacademy.database.entity.RunMember;
import pl.sdacademy.database.utils.HibernateUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RunMemberDaoImplTest {

  @BeforeEach
  void clearBeforeEach(){
    Session session = HibernateUtils
        .getInstance()
        .getSessionfactory()
        .getCurrentSession();

    session.beginTransaction();
    session.createSQLQuery("delete from RUN_MEMBER").executeUpdate();
    session.getTransaction().commit();
    session.close();
  }

  @Test
  void save () {
    RunMemberDao dao = new RunMemberDaoImpl();

    RunMember runMember = new RunMember();
    runMember.setName("Zenek");
    runMember.setStart_number(1);

    dao.save(runMember);
    RunMember saved = dao.findByID(runMember.getId());

    assertNotNull(saved);
    assertEquals(runMember.getId(), saved.getId());
    assertEquals(runMember.getName(), saved.getName());
    assertEquals(runMember.getStart_number(), saved.getStart_number());

  }

  @Test
  void delete () {
    RunMemberDao dao = new RunMemberDaoImpl();
    RunMember runMember = new RunMember();

    runMember.setName("Wpis pierwotny");
    runMember.setStart_number(100);

    dao.save(runMember);
    dao.delete(runMember.getId());
    RunMember deleted = dao.findByID(runMember.getId());
    System.out.println(runMember);
    assertNull(deleted);;
  }

  @Test
  void findAll () {
    RunMemberDao dao = new RunMemberDaoImpl();
    RunMember runMember1 = new RunMember();
    RunMember runMember2 = new RunMember();

    runMember1.setName("Andrzej");
    runMember1.setStart_number(13);

    runMember2.setName("Jarek");
    runMember2.setStart_number(666);

    dao.save(runMember1);
    dao.save(runMember2);

    List<RunMember> runMemberList = dao.findAll();

    assertNotNull(runMemberList);
    assertEquals(2, runMemberList.size());

    RunMember found = null;

    if(runMember1.getId() == runMemberList.get(0).getId()){
      found = runMemberList.get(0);
    }else{
      found = runMemberList.get(1);
    }

    assertNotNull(found);
    assertEquals(found.getName(), runMember1.getName());
    assertEquals(found.getStart_number(), runMember1.getStart_number());
  }
}
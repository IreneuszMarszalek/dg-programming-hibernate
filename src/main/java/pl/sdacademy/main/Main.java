package pl.sdacademy.main;

import pl.sdacademy.database.dao.RunDao;
import pl.sdacademy.database.daoimpl.RunDaoImpl;
import pl.sdacademy.database.entity.Run;

public class Main {
  public static void main (String[] args) {
	RunDao runDao = new RunDaoImpl();
	Run run = new Run();
	run.setId((long) 1);
	run.setName("Zlota piatka blblblb");
	run.setMembersLimit(100);

	runDao.save(run);

	System.out.println(run.getId());
  }
}

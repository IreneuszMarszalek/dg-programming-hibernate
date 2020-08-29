package pl.sdacademy.database.dao;

import pl.sdacademy.database.entity.Run;
import pl.sdacademy.database.entity.RunMember;

import java.util.List;

public interface RunMemberDao {
  void save (RunMember run);
  RunMember findByID(Long id);
  List<RunMember> findAll();
  void delete(Long id);
}

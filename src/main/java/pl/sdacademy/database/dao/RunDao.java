package pl.sdacademy.database.dao;

import pl.sdacademy.database.entity.Run;

import java.util.List;

public interface RunDao {
  void save (Run run);
  Run findByID(Long id);
  List<Run> findAll();
  void delete(Long id);
}

package pl.sdacademy.database.entity;

import javax.persistence.*;

@Entity
@Table(name="RUN_MEMBER")

public class RunMember {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(length = 30)
  private String name;
  private Integer start_number;

  public RunMember(){}

  public Long getId () {
	return id;
  }

  public void setId (Long id) {
	this.id = id;
  }

  public String getName () {
	return name;
  }

  public void setName (String name) {
	this.name = name;
  }

  public Integer getStart_number () {
	return start_number;
  }

  public void setStart_number (Integer start_number) {
	this.start_number = start_number;
  }
}

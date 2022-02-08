package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

  private int id;
  private static int nextId = 1;

  private String name;
  private Employer employer;
  private Location location;
  private PositionType positionType;
  private CoreCompetency coreCompetency;

  public Job(){
    id = nextId;
    nextId++;
  }

  public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
    this();
    this.name = name;
    this.employer = employer;
    this.location = location;
    this.positionType = positionType;
    this.coreCompetency = coreCompetency;
  }

  // override toString, equals, and hashCode
  @Override
  public String toString(){
    // if all fields empty/null, return appropriate message
    if (this.name == null && this.employer == null && this.location == null && this.positionType == null && this.coreCompetency == null) {
      return "OOPS! This job does not seem to exist.";
    }

    // if .get[Field] is empty string, .set[Field] to "Data not available"
    if (this.getName().equals("")){
      this.setName("Data not available");
    } else if (this.getEmployer().getValue().equals("")){
        this.setEmployer(new Employer("Data not available"));
    } else if (this.getLocation().getValue().equals("")){
        this.setLocation(new Location("Data not available"));
    } else if (this.getPositionType().getValue().equals("")){
        this.setPositionType(new PositionType("Data not available"));
    } else if (this.getCoreCompetency().getValue().equals("")){
        this.setCoreCompetency(new CoreCompetency("Data not available"));
    }

    // return string built above with new lines between each field
    return "\nID: " + id + "\n" +
            "Name: " + name + "\n" +
            "Employer: " + employer + "\n" +
            "Location: " + location + "\n" +
            "Position Type: " + positionType + "\n" +
            "Core Competency: " + coreCompetency + "\n";
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Job job = (Job) o;
    return id == job.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  // getters
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Employer getEmployer() {
    return employer;
  }

  public Location getLocation() {
    return location;
  }

  public PositionType getPositionType() {
    return positionType;
  }

  public CoreCompetency getCoreCompetency() {
    return coreCompetency;
  }

  // setters
  public void setName(String name) {
    this.name = name;
  }

  public void setEmployer(Employer employer) {
    this.employer = employer;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public void setPositionType(PositionType positionType) {
    this.positionType = positionType;
  }

  public void setCoreCompetency(CoreCompetency coreCompetency) {
    this.coreCompetency = coreCompetency;
  }
}
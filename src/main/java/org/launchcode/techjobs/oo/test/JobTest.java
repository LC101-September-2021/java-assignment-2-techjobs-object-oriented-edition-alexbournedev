package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.PositionType;

import static org.junit.Assert.*;

// Created by LaunchCode


@RunWith(JUnit4.class)
public class JobTest {

//  Job job1;
//  Job job2;
//
//  @Before
//  public void createJobObjects(){
//    job1 = new Job();
//    job2 = new Job();
//  }

  @Test
  public void testSettingJobId() {
    var job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));
    var job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertEquals(1, job2.getId() - job1.getId());
  }

  @Test
  public void testJobConstructorSetsAllFields() {
    var job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertTrue(job1 instanceof Job);
    assertTrue(job1.getEmployer() instanceof Employer);
    assertTrue(job1.getLocation() instanceof Location);
    assertTrue(job1.getPositionType() instanceof PositionType);
    assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

    assertEquals("Product tester", job1.getName());
    assertEquals("ACME", job1.getEmployer().toString());
    assertEquals("Desert", job1.getLocation().toString());
    assertEquals("Quality control", job1.getPositionType().toString());
    assertEquals("Persistence", job1.getCoreCompetency().toString());
  }

  @Test
  public void testJobsForEquality() {

    var job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));
    var job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertFalse(job1.equals(job2));
  }

  @Test
  public void testToStringStartsAndEndsWithNewLine(){
    var job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    String jobStr = job.toString();
    char firstIndex = jobStr.charAt(0);
    char lastIndex = jobStr.charAt(jobStr.length() - 1);

    assertEquals(firstIndex, '\n');
    assertEquals(lastIndex, '\n');
  }

  @Test
  public void testToStringHandlesEmptyField(){
    var job = new Job("", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    String jobStr = job.toString();
    assertEquals("Data not available", job.getName());
  }

  @Test
  public void testToStringContainsCorrectLabelsAndData(){
    var job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    String jobStr = job.toString();

    assertEquals("Product tester", job.getName());
  }
}
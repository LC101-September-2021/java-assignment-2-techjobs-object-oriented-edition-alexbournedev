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

  @Test
  public void testSettingJobId() {
    Job job1 = new Job();
    Job job2 = new Job();
    assertEquals(1, job2.getId() - job1.getId());
  }

  @Test
  public void testJobConstructorSetsAllFields() {

    var job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertTrue(new Job() instanceof Job);
    assertTrue(job.getEmployer() instanceof Employer);
    assertTrue(job.getLocation() instanceof Location);
    assertTrue(job.getPositionType() instanceof PositionType);
    assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

    assertEquals("Product tester", job.getName());
    assertEquals("ACME", job.getEmployer().toString());
    assertEquals("Desert", job.getLocation().toString());
    assertEquals("Quality control", job.getPositionType().toString());
    assertEquals("Persistence", job.getCoreCompetency().toString());
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
    assertTrue(jobStr.charAt(0) == '\n');
    assertTrue(jobStr.charAt(jobStr.length() - 1) == '\n');
  }

  @Test
  public void testToStringHandlesEmptyField(){
    var job = new Job("", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    String jobStr = job.toString();
    assertTrue(jobStr.contains("Data not available"));
  }
}
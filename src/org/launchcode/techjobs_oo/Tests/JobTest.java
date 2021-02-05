package org.launchcode.techjobs_oo.Tests;

import org.launchcode.techjobs_oo.*;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class JobTest {

    Job test_job1;
    Job test_job2;
    Job test_job3;
    Job test_job4;

    @Before
    public void createJobObjects() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @Test
    public void testSettingJobId() {
        //Test the ID are different:
        assertFalse(test_job1.getId() == test_job2.getId());
        //Test the IDs differ by 1:
        assertTrue(test_job1.getId() - test_job2.getId() == 1 || test_job1.getId() - test_job2.getId() == -1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        //Test Job
        assertEquals("Product tester", test_job3.getName());
        assertTrue(test_job3 instanceof Job);
        //Test Employer
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertTrue(test_job3.getEmployer() instanceof Employer);
        //Test Location
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertTrue(test_job3.getLocation() instanceof Location);
        //Test PositionType
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        //Test CoreCompetency
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job3 == test_job4);
    }

    @Test
    public void testToString() {
        //Test complete constructor
        assertEquals("ID: " + test_job4.getId() + "\nName: Product tester" +
                "\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control" +
                "\nCore Competency: Persistence", test_job4.toString());
        //Test with an empty field
        Job test_job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals("ID: " + test_job5.getId() + "\nName: Product tester" +
                "\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control" +
                "\nCore Competency: Data not available", test_job5.toString());
        //Test if the Job only contains the ID field
        assertEquals("OOPS! This job does not seem to exist.", test_job2.toString());
    }

}

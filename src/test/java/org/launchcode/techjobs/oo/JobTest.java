package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
    Job job1 = new Job();
    Job job2 = new Job();
//    assertFalse(job1 == job2);
    assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());

        assertTrue(job3.getName().equals("Product tester"));
        assertTrue(job3.getEmployer().getValue().equals("ACME"));
        assertTrue(job3.getLocation().getValue().equals("Desert"));
        assertTrue(job3.getPositionType().getValue().equals("Quality control"));
        assertTrue(job3.getCoreCompetency().getValue().equals("Persistence"));

    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job();
        Job job5 = new Job();
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals("\n", Character.toString(job6.toString().charAt(0)));
        assertTrue(job6.toString().endsWith("\n"));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String testToString = "\n" +
                "ID: " + job7.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n";

        assertEquals(testToString, job7.toString());
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));
        String testToString = "\n" +
                "ID: " + job8.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n";
        assertEquals(testToString, job8.toString());
    }
}

package com.example;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    static StudentDAO dao;

    @BeforeAll
    static void setup() {
        dao = new StudentDAO();
    }

    @AfterAll
    static void cleanup() {
        new java.io.File("test.db").delete();
    }

    @Test
    void testInsertStudent() {
        dao.save(new Student(0, "Vijay", "vijay@test.com"));
        List<Student> students = dao.findAll();
        assertEquals(1, students.size());
    }

    @Test
    void testDeleteStudent() {
        Student s = new Student(0, "A", "a@test.com");
        dao.save(s);
        dao.delete(s.getId());
        assertTrue(dao.findAll().isEmpty());
    }
}

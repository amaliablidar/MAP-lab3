
package com.company.Repository;

import java.util.ArrayList;

import com.company.Course;
import com.company.Student;
import com.company.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    private ArrayList<Course> coursesTest = new ArrayList();
    private ArrayList<Course> teacherCourses = new ArrayList();


    @BeforeEach
    void init() {
        this.coursesTest = new ArrayList();
        ArrayList<Student> studentsList = new ArrayList();
        ArrayList<Course> teacherCourses = new ArrayList();
        Teacher teacher1 = new Teacher(15L, "Diana", "Cristea", teacherCourses);
        Teacher teacher2 = new Teacher(16L, "Madalina", "Dicu", teacherCourses);
        Teacher teacher3 = new Teacher(17L, "Christian", "Sacarea", teacherCourses);
        Teacher teacher4 = new Teacher(18L, "Radu", "Dragos", teacherCourses);
        Course course1 = new Course("BD", 6, teacher1, 10, studentsList, 123L);
        Course course2 = new Course("MAP", 6, teacher2, 10, studentsList, 124L);
        Course course3 = new Course("PL", 5, teacher3, 10, studentsList, 125L);
        Course course4 = new Course("RC", 6, teacher4, 10, studentsList, 126L);
        this.coursesTest.add(course1);
        this.coursesTest.add(course2);
        this.coursesTest.add(course3);
        this.coursesTest.add(course4);
    }

    @Test
    void findOne() {
        Student student = new Student(this.coursesTest, "Amalia", "Blidar", 400L, 30);
        assertEquals(this.coursesTest.get(1), student.findOne(124L));
    }

    @Test
    void findAll() {
        Student student = new Student(this.coursesTest, "Amalia", "Blidar", 400L, 30);
        assertEquals(this.coursesTest, student.getEnrolledCourses());
    }

    @Test
    void save() {
        ArrayList<Course> teacherCourses = new ArrayList();
        Student student = new Student(this.coursesTest, "Amalia", "Blidar", 400L, 30);
        Teacher teacher5 = new Teacher(19L, "Hannelore", "Lisei", teacherCourses);
        ArrayList<Student> studentsList = new ArrayList();
        Course course5 = new Course("PS", 6, teacher5, 10, studentsList, 127L);
        assertEquals((Object)null, student.save(course5));
    }

    @Test
    void delete() {
        ArrayList<Course> teacherCourses = new ArrayList();
        new Teacher(15L, "Diana", "Cristea", teacherCourses);
        Student student = new Student(this.coursesTest, "Amalia", "Blidar", 400L, 30);
        Teacher teacher5 = new Teacher(19L, "Hannelore", "Lisei", teacherCourses);
        ArrayList<Student> studentsList = new ArrayList();
        Course course5 = new Course("PS", 6, teacher5, 10, studentsList, 127L);
        student.save(course5);
        assertEquals(course5, student.delete(course5.getId()));
    }

    @Test
    void update() {
        Teacher teacher6 = new Teacher(20L, "Iulian", "Benta", this.teacherCourses);
        Student student = new Student(this.coursesTest, "Amalia", "Blidar", 400L, 30);
        ArrayList<Student> studentsList = new ArrayList();
        Course course6 = new Course("FP", 6, teacher6, 10, studentsList, 125L);
        assertEquals("PL", ((Course)this.coursesTest.get(2)).getTitle());
        assertEquals(this.coursesTest.get(2), student.update(course6));
        assertEquals("FP", ((Course)this.coursesTest.get(2)).getTitle());
    }
}

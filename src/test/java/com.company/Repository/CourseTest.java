
package com.company.Repository;

import java.util.ArrayList;

import com.company.Course;
import com.company.Student;
import com.company.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    private ArrayList<Student> studentsList = new ArrayList();
    private ArrayList<Course> courseTeacher = new ArrayList();

    @BeforeEach
    void init() {
        this.studentsList = new ArrayList();
        ArrayList<Course> studentCourse = new ArrayList();
        Student student1 = new Student(studentCourse, "Amalia", "Blidar", 300L, 30);
        Student student2 = new Student(studentCourse, "Anamaria", "Rus", 301L, 30);
        Student student3 = new Student(studentCourse, "Ionut", "Pop", 302L, 30);
        Student student4 = new Student(studentCourse, "Camelia", "Oanta", 303L, 30);
        this.studentsList.add(student1);
        this.studentsList.add(student2);
        this.studentsList.add(student3);
        this.studentsList.add(student4);
    }

    @Test
    void findOne() {
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.courseTeacher);
        Course course = new Course("BD", 6, teacher, 10, this.studentsList, 123L);
        assertEquals(this.studentsList.get(2), course.findOne(302L));
    }

    @Test
    void findAll() {
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.courseTeacher);
        Course course = new Course("BD", 6, teacher, 10, this.studentsList, 123L);
        assertEquals(this.studentsList, course.findAll());
    }

    @Test
    void save() {
        ArrayList<Course> coursesTest = new ArrayList();
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.courseTeacher);
        Course course = new Course("BD", 6, teacher, 10, this.studentsList, 123L);
        Student student = new Student(coursesTest, "Amalia", "Blidar", 400L, 30);
        assertEquals((Object)null, course.save(student));
    }

    @Test
    void update() {
        ArrayList<Course> studentCourse = new ArrayList();
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.courseTeacher);
        Course course = new Course("BD", 6, teacher, 10, this.studentsList, 123L);
        Student student = new Student(studentCourse, "Bianca", "Blidar", 300L, 30);
        assertEquals(this.studentsList.get(0), course.update(student));
        assertEquals("Bianca", ((Student)this.studentsList.get(0)).getFirstName());
    }

    @Test
    void delete() {
        ArrayList<Course> studentCourse = new ArrayList();
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.courseTeacher);
        Course course = new Course("BD", 6, teacher, 10, this.studentsList, 123L);
        Student student = new Student(studentCourse, "Bianca", "Blidar", 300L, 30);
        assertEquals(this.studentsList.get(0), course.update(student));
        assertEquals("Bianca", ((Student)this.studentsList.get(0)).getFirstName());
    }
}

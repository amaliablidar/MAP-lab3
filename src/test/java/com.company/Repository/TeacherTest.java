

package com.company.Repository;

import java.util.ArrayList;

import com.company.Course;
import com.company.Student;
import com.company.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeacherTest {
    private ArrayList<Course> coursesTest2 = new ArrayList();

    @BeforeEach
    void init() {
        this.coursesTest2 = new ArrayList();
        ArrayList<Student> studentsList = new ArrayList();
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.coursesTest2);
        Course course1 = new Course("BD", 6, teacher, 10, studentsList, 123L);
        Course course2 = new Course("SDA", 6, teacher, 10, studentsList, 124L);
        Course course3 = new Course("MAP", 5, teacher, 10, studentsList, 125L);
        Course course4 = new Course("FP", 6, teacher, 10, studentsList, 126L);
        this.coursesTest2.add(course1);
        this.coursesTest2.add(course2);
        this.coursesTest2.add(course3);
        this.coursesTest2.add(course4);
    }

    @Test
    void findOne() {
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.coursesTest2);
        assertEquals(this.coursesTest2.get(1), teacher.findOne(124L));
    }

    @Test
    void findAll() {
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.coursesTest2);
        assertEquals(this.coursesTest2, teacher.getCourses());
    }

    @Test
    void save() {
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.coursesTest2);
        ArrayList<Student> studentsList = new ArrayList();
        Course course5 = new Course("PS", 6, teacher, 10, studentsList, 127L);
        assertEquals((Object)null, teacher.save(course5));
    }

    @Test
    void delete() {
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.coursesTest2);
        ArrayList<Student> studentsList = new ArrayList();
        Course course5 = new Course("PS", 6, teacher, 10, studentsList, 127L);
        teacher.save(course5);
        assertEquals(course5, teacher.delete(course5.getId()));
    }

    @Test
    void update() {
        Teacher teacher = new Teacher(15L, "Diana", "Cristea", this.coursesTest2);
        ArrayList<Student> studentsList = new ArrayList();
        Course course6 = new Course("PL", 6, teacher, 10, studentsList, 125L);
        assertEquals("MAP", ((Course)this.coursesTest2.get(2)).getTitle());
        assertEquals(this.coursesTest2.get(2), teacher.update(course6));
        assertEquals("PL", ((Course)this.coursesTest2.get(2)).getTitle());
    }
}

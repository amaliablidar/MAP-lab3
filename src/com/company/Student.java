//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Student extends Person implements CrudRepo<Course> {
    private ArrayList<Course> enrolledCourses = new ArrayList();
    private Long id;
    private int totalCredits;

    public Student(ArrayList<Course> courseList, String firstName, String lastName, Long id, int totalCredits) {
        super(firstName, lastName);
        this.enrolledCourses = courseList;
        this.id = id;
        this.totalCredits = totalCredits;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return this.enrolledCourses;
    }

    public void setEnrolledCourses(ArrayList<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalCredits() {
        return this.totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public Course findOne(Long id) {
        Iterator var2 = this.enrolledCourses.iterator();

        Course course;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            course = (Course)var2.next();
        } while(!course.getId().equals(id));

        return course;
    }

    public Iterable<Course> findAll() {
        return this.enrolledCourses;
    }

    public Course save(Course var1) {
        Iterator var2 = this.enrolledCourses.iterator();

        while(var2.hasNext()) {
            Course course = (Course)var2.next();
            if (course.equals(var1)) {
                return course;
            }
        }

        this.enrolledCourses.add(var1);
        return null;
    }

    public Course delete(Long id) {
        Iterator var2 = this.enrolledCourses.iterator();

        Course course;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            course = (Course)var2.next();
        } while(!course.getId().equals(id));

        this.enrolledCourses.remove(course);
        return course;
    }

    public Course update(Course entity) {
        Iterator var2 = this.enrolledCourses.iterator();

        Course course;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            course = (Course)var2.next();
        } while(!course.getId().equals(entity.getId()));

        course.setCredits(entity.getCredits());
        course.setMaxStudents(entity.getMaxStudents());
        course.setStudentsList(entity.getStudentsList());
        course.setTeacher(entity.getTeacher());
        course.setTitle(entity.getTitle());
        return course;
    }
}

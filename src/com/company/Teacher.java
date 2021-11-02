//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Teacher extends Person implements CrudRepo<Course> {
    private ArrayList<Course> courses = new ArrayList();
    private Long id;

    public Teacher(Long id, String firstName, String lastName, ArrayList<Course> courses1) {
        super(firstName, lastName);
        this.id = id;
        this.courses = courses1;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course findOne(Long id2) {
        Iterator var2 = this.courses.iterator();

        Course course;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            course = (Course)var2.next();
        } while(!course.getId().equals(id2));

        return course;
    }

    public Iterable<Course> findAll() {
        return this.courses;
    }

    public Course save(Course var1) {
        Iterator var2 = this.courses.iterator();

        while(var2.hasNext()) {
            Course course = (Course)var2.next();
            if (course.equals(var1)) {
                return course;
            }
        }

        this.courses.add(var1);
        return null;
    }

    public Course delete(Long id) {
        Iterator var2 = this.courses.iterator();

        Course course;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            course = (Course)var2.next();
        } while(!course.getId().equals(id));

        this.courses.remove(course);
        return course;
    }

    public Course update(Course entity) {
        Iterator var2 = this.courses.iterator();

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

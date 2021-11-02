//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Course implements CrudRepo<Student> {
    private Long id;
    private String title;
    private int credits;
    private Person teacher;
    private int maxStudents;
    private ArrayList<Student> studentsEnrolled = new ArrayList();

    public Course(String title, int credits, Person teacher, int maxStudents, ArrayList<Student> studentsList, Long id) {
        this.title = title;
        this.credits = credits;
        this.teacher = teacher;
        this.maxStudents = maxStudents;
        this.studentsEnrolled = studentsList;
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Person getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public ArrayList<Student> getStudentsList() {
        return this.studentsEnrolled;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsEnrolled = studentsList;
    }

    public Student findOne(Long id) {
        Iterator var2 = this.studentsEnrolled.iterator();

        Student student;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            student = (Student)var2.next();
        } while(!student.getId().equals(id));

        return student;
    }

    public Iterable<Student> findAll() {
        return this.studentsEnrolled;
    }

    public Student save(Student var1) {
        Iterator iterator = this.studentsEnrolled.iterator();

        while(iterator.hasNext()) {
            Student student = (Student)iterator.next();
            if (student.equals(var1)) {
                return student;
            }
        }

        this.studentsEnrolled.add(var1);
        return null;
    }

    public Student update(Student entity) {
        Iterator var2 = this.studentsEnrolled.iterator();

        Student student;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            student = (Student)var2.next();
        } while(!student.getId().equals(entity.getId()));

        student.setFirstName(entity.getFirstName());
        student.setLastName(entity.getLastName());
        student.setEnrolledCourses(entity.getEnrolledCourses());
        return student;
    }

    public Student delete(Long id) {
        Iterator var2 = this.studentsEnrolled.iterator();

        Student student;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            student = (Student)var2.next();
        } while(!student.getId().equals(id));

        this.studentsEnrolled.remove(student);
        return student;
    }
}

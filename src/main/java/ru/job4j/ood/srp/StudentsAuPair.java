package ru.job4j.ood.srp;

import java.util.LinkedList;
import java.util.List;

public class StudentsAuPair implements AuPair {

    private List<Student> students;

    public StudentsAuPair(List<Student> students) {
        this.students = students;
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public String getStudentName(Student student) {
        return null;
    }

    @Override
    public List<Student> checkStudentsForAge() {
        return null;
    }

    @Override
    public void checkStudentsDocuments(List<Student> students) {

    }

    @Override
    public void sendInvitation(Student student) {

    }
}

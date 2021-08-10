package ru.job4j.ood.srp;

import java.util.List;

public interface AuPair {

    public void addStudent(Student student);

    public String getStudentName(Student student);

    public List<Student> checkStudentsForAge();

    public void checkStudentsDocuments(List<Student> students);

    public void sendInvitation(Student student);



}

package ru.geekbrains.JavaCore;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Lesson9 {

    static class Student {
        private int id;
        private String name;
        private List<Course> courses;

        public Student(int id, String name, List<Course> courses) {
            this.id = id;
            this.name = name;
            this.courses = courses;
        }

        public List<Course> getCourses() {
            return this.courses;
        }

        public String getName() {
            return this.name;
        }
    }
    static class Course {
        private int id;
        private String name;

        public Course(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(1, "Introduction to Cyber Security Course"));
        courses.add(new Course(2, "Lean Digital Strategy & Transformation"));
        courses.add(new Course(3, "Self-Paced Programs"));
        courses.add(new Course(4, "Course in IT (Web Design)"));
        courses.add(new Course(5, "Cybersecurity: Managing Risk in the Information Age Online Short Course"));
        courses.add(new Course(6, "Digitization of the Legal Sector"));
        courses.add(new Course(7, "Enabling Technologies for Data Science and Analytics: The Internet of Things"));
        courses.add(new Course(8, "Higher Professional Degree in Network and IT Security"));
        courses.add(new Course(9, "Computer Security Analyst"));

        Map<Integer, Course> coursesById = courses.stream().collect(Collectors.toMap(i -> i.id, i -> i));

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Thomas",  Arrays.asList(coursesById.get(1),coursesById.get(2),coursesById.get(3),coursesById.get(4),coursesById.get(5),coursesById.get(6),coursesById.get(7),coursesById.get(8),coursesById.get(9))));
        students.add(new Student(2, "Alex",  Arrays.asList(coursesById.get(1), coursesById.get(2), coursesById.get(3), coursesById.get(4), coursesById.get(5), coursesById.get(6), coursesById.get(7), coursesById.get(8), coursesById.get(9))));
        students.add(new Student(3, "Maria",  Arrays.asList(coursesById.get(5), coursesById.get(6), coursesById.get(7), coursesById.get(8), coursesById.get(9))));
        students.add(new Student(4, " Harry",  Arrays.asList( coursesById.get(1), coursesById.get(2), coursesById.get(3), coursesById.get(4), coursesById.get(5), coursesById.get(6), coursesById.get(9))));
        students.add(new Student(5, "Martin",  Arrays.asList(coursesById.get(3), coursesById.get(4), coursesById.get(5), coursesById.get(6), coursesById.get(7))));
        students.add(new Student(6, "Valentine",  Arrays.asList(coursesById.get(1), coursesById.get(2), coursesById.get(3), coursesById.get(4), coursesById.get(7), coursesById.get(8), coursesById.get(9))));
        students.add(new Student(7, "George",  Arrays.asList(coursesById.get(5), coursesById.get(6), coursesById.get(7), coursesById.get(8), coursesById.get(9))));
        students.add(new Student(8, "John",  Arrays.asList(coursesById.get(3), coursesById.get(4), coursesById.get(5), coursesById.get(7), coursesById.get(9))));
        students.add(new Student(9, "Greg",  Arrays.asList(coursesById.get(1), coursesById.get(2), coursesById.get(3), coursesById.get(4))));
        students.add(new Student(10, "Michael",  Arrays.asList(coursesById.get(1), coursesById.get(2), coursesById.get(6), coursesById.get(7), coursesById.get(8))));
        students.add(new Student(11, "Halyna",  Arrays.asList(coursesById.get(3), coursesById.get(4), coursesById.get(5), coursesById.get(6))));
        students.add(new Student(12, "Marry",  Arrays.asList(coursesById.get(1))));
        students.add(new Student(13, "Bonny",  Arrays.asList(coursesById.get(3), coursesById.get(4), coursesById.get(5), coursesById.get(6), coursesById.get(7))));
        students.add(new Student(14, "Sahra",  Arrays.asList(coursesById.get(1), coursesById.get(2), coursesById.get(7), coursesById.get(8), coursesById.get(9))));
        students.add(new Student(15, "Scarlett",  Arrays.asList(coursesById.get(3), coursesById.get(4), coursesById.get(5), coursesById.get(6))));
        students.add(new Student(16, "Joan",  Arrays.asList(coursesById.get(9))));
        students.add(new Student(17, "Claudia",  Arrays.asList(coursesById.get(7), coursesById.get(8), coursesById.get(9))));
        students.add(new Student(18, "Barbara",  Arrays.asList(coursesById.get(2), coursesById.get(3), coursesById.get(4), coursesById.get(5))));

        Map<Integer, Student> studentsById = students.stream().collect(Collectors.toMap(i -> i.id, i -> i));

        List<Student> selectedStudents = Arrays.asList(studentsById.get(1), studentsById.get(3), studentsById.get(5), studentsById.get(8));
        List<String> courseNames = GetCourses(selectedStudents);
        System.out.println("1. The students " + selectedStudents.stream().map(student -> student.getName()).collect(Collectors.toList()) + " are subscribed for courses " + courseNames);

        List<String> curiousStudentNames = GetTop3CuriousStudents(students);
        System.out.println("2. The most curious students are " + curiousStudentNames);

        Course selectedCourse = coursesById.get(1);

        List<String> studentNames = GetStudents(students, selectedCourse);
        System.out.println("3. The students that are subscribed for '" + selectedCourse.getName() + "' course: " + studentNames);
    }

    private static List<String> GetCourses(List<Student> students) {
        return students.stream()
                .map(student -> student.getCourses())
                .flatMap(course -> course.stream())
                .map(course -> course.getName())
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<String> GetTop3CuriousStudents(List<Student> students) {
        return students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .map(student -> student.getName())
                .collect(Collectors.toList());
    }

    private static List<String> GetStudents(List<Student> students, Course course) {
        return students.stream()
                .filter(student -> student.getCourses().contains(course))
                .map(student -> student.getName())
                .distinct()
                .collect(Collectors.toList());
    }
}

package io.program_logic.chapter13;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDemo2 {
    public static void writeStudents(List<Student> students) throws IOException {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("students.txt"));
            for (Student s : students) {
                writer.write(s.getName() + "," + s.getAge() + "," + s.getScore());
                writer.newLine();
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static List<Student> readStudents() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("students.txt"));
            List<Student> students = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                Student s = new Student();
                s.setName(fields[0]);
                s.setAge(Integer.parseInt(fields[1]));
                s.setScore(Double.parseDouble(fields[2]));
                students.add(s);
                line = reader.readLine();
            }

            return students;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<Student> students = Arrays
                .asList(new Student[]{new Student("张三", 18, 80.9d), new Student("李四", 17, 67.5d)});
        System.out.println(System.getProperty("user.dir"));

        writeStudents(students);

        List<Student> list = readStudents();

        System.out.println(list);

        File file = new File("students.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
    }
}

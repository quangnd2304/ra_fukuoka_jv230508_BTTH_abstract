package ra;

import ra.impl.Student;

import java.util.Scanner;

public interface IStudent {
    float MARK_PASS = 5;
    void inputData(Scanner scanner, Student[] arrStudent, int numberStudent);
    void displayData();
    void calAvgMark();
}

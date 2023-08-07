package ra.run;

import ra.impl.Student;

import java.util.Scanner;

public class StudentManagement {
    static Student[] arrStudent = new Student[100];
    //static List<Student> listStudent = new ArrayList<>();
    // ArrayList<Student> listStudent = new ArrayList<>();

    static int numberStudent = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("******************MENU*****************");
            System.out.println("1. Nhập thông tin các sinh viên");
            System.out.println("2. Tính điểm trung bình các sinh viên");
            System.out.println("3. Đánh giá xếp loại sinh viên");
            System.out.println("4. Tính trạng thái sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Sự lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentManagement.inputListStudent(scanner);
                    break;
                case 2:
                    StudentManagement.calAvgMark();
                    break;
                case 3:
                    StudentManagement.calRank();
                    break;
                case 4:
                    StudentManagement.calStudentStatus();
                    break;
                case 5:
                    StudentManagement.displayListStudent();
                    break;
                case 6:
                    StudentManagement.sortStudentByAvgMarkASC();
                    break;
                case 7:
                    StudentManagement.searchStudentByName(scanner);
                    break;
                case 8:
                    StudentManagement.thongKeSinhVien();
                    break;
                case 9:
                    StudentManagement.thongKeTrangThai();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-10");
            }
        } while (true);
    }

    public static void inputListStudent(Scanner scanner) {
        System.out.println("Nhập số sinh viên cần nhập thông tin: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            arrStudent[numberStudent] = new Student();
            arrStudent[numberStudent].inputData(scanner, arrStudent, numberStudent);
            numberStudent++;
            //Student st = new Student();
            //st.inputData()
            //listStudent.add(st);
        }
    }

    public static void calAvgMark() {
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].calAvgMark();
        }
        /*for(Student st:listStudent){
            st.calAvgMark();
        }*/
        System.out.println("Đã tính xong điểm trung bình cho tất cả sinh viên");
    }

    public static void calRank() {
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].calRank();
        }
        System.out.println("Đã xếp loại xong cho tất cả các sinh viên");
    }

    public static void calStudentStatus() {
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].calStudentStatus();
        }
        System.out.println("Đã tính xong trạng thái tất cả sinh viên");
    }

    public static void displayListStudent() {
        for (int i = 0; i < numberStudent; i++) {
            arrStudent[i].displayData();
        }
    }

    public static void sortStudentByAvgMarkASC() {
        for (int i = 0; i < numberStudent - 1; i++) {
            for (int j = i + 1; j < numberStudent; j++) {
                if (arrStudent[i].getAvgMark() > arrStudent[j].getAvgMark()) {
                    Student temp = arrStudent[i];
                    arrStudent[i] = arrStudent[j];
                    arrStudent[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp xong sinh viên theo điểm trung bình tăng dần");
    }

    public static void searchStudentByName(Scanner scanner) {
        System.out.println("Nhập vào tên sinh viên cần tìm:");
        String searchName = scanner.nextLine();
        System.out.println("Các sinh viên tìm thấy: ");
        boolean searchResult = false;
        for (int i = 0; i < numberStudent; i++) {
            if (arrStudent[i].getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                searchResult = true;
                arrStudent[i].displayData();
            }
        }
        if (!searchResult) {
            System.out.println("Không tìm thấy sinh viên nào");
        }
    }

    public static void thongKeSinhVien() {
        int cntYeu = 0, cntTB = 0, cntKha = 0, cntGioi = 0, cntXuatSac = 0;
        for (int i = 0; i < numberStudent; i++) {
            switch (arrStudent[i].getRank()) {
                case "Yếu":
                    cntYeu++;
                    break;
                case "Trung bình":
                    cntTB++;
                    break;
                case "Khá":
                    cntKha++;
                    break;
                case "Giỏi":
                    cntGioi++;
                    break;
                default:
                    cntXuatSac++;
            }
        }
        System.out.printf("Xuất sắc: %d - Giỏi: %d - Khá: %d - Trung bình: %d - Yếu: %d\n", cntXuatSac, cntGioi, cntKha, cntTB, cntYeu);
    }

    public static void thongKeTrangThai() {
        int cntFail = 0, cntPass = 0;
        for (int i = 0; i < numberStudent; i++) {
            if (arrStudent[i].getStudentStatus().equals("PASS")) {
                cntPass++;
            } else {
                cntFail++;
            }
        }
        System.out.printf("PASS: %d - FAIL: %d\n", cntPass, cntFail);
    }
}

package phon;

import java.sql.SQLException;
import java.util.Scanner;

public class PhoneController {
    public static void main(String[] args) throws SQLException {
        PhoneDao phoneDao = new PhoneDao();
        while (true){
            System.out.println("1.select all data");
            System.out.println("2.add data");
            System.out.println("3.delete data");
            System.out.println("4.search data");
            System.out.println("5.Exit");
            System.out.println("------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.println("enter your input number :");
            int inputNumber = scanner.nextInt();

            switch (inputNumber){
                case 1:
                    phoneDao.getAllData();
                    break;
                case 2:
                    Phone newPhone = AddNewData();
                    phoneDao.isertDataBase(newPhone);
                    break;
                case 3:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("enter delete");
                    String delete = scanner2.nextLine();

                    phoneDao.deleteDataID(delete);
                    break;
                case 4:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("enter keyword: ");
                    String keyword = scanner1.nextLine();

                    phoneDao.searchDataWithName(keyword);
                    break;
                case 5:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("không tồn tại: mời bạn nhập lại hihi??");
                    break;
            }
        }
    }

    private static Phone AddNewData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name: ");
        String name = scanner.nextLine();
        System.out.println("Input information");
        String information = scanner.nextLine();
        System.out.println("Input price:");
        double price = scanner.nextDouble();

        Phone newPhone = new Phone(name,price,information);
        return newPhone;
    }
}

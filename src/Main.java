import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static Employee[] arrEmployees;

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Выполенение курсовой работы №1. Базовый уровень");

        arrEmployees = new Employee[10];
        Employee employeeMinSalary;
        Employee employeeMaxSalary;

        Employee petrov = new Employee("Петров Александр Сергеевич", 2, 56000);
        Employee ivanov = new Employee("Иванов Иван Иванович", 4, 38000);
        Employee sidorov = new Employee("Сидоров Петр Иванович", 5, 78000);
        Employee sharipov = new Employee("Шарипов Кирилл Валерьевич", 1, 105000);
        Employee strokova = new Employee("Строкова Анастасия Вадимовна", 1, 150000);
        Employee kiselev = new Employee("Киселев Сергей Андреевич", 1, 140000);
        Employee zazulov = new Employee("Зазулов Алексей Генрихович", 3, 127000);
        Employee binkovskay = new Employee("Биньковская Ангелина Андреевна", 2, 98000);
        Employee timonina = new Employee("Тимонина Татьяна Владимировна", 3, 78000);
        Employee semenov = new Employee("Семенов Андрей Сергеевич", 4, 45000);

        if (insertEmployeeInArray(petrov) == false) {
            printErrorWhenAddingEmployeeInArray(petrov);
        }else if (insertEmployeeInArray(ivanov) == false){
            printErrorWhenAddingEmployeeInArray(ivanov);
        }else if (insertEmployeeInArray(sidorov) == false){
            printErrorWhenAddingEmployeeInArray(sidorov);
        }else if (insertEmployeeInArray(sharipov) == false){
            printErrorWhenAddingEmployeeInArray(sharipov);
        }else if (insertEmployeeInArray(strokova) == false){
            printErrorWhenAddingEmployeeInArray(strokova);
        }else if (insertEmployeeInArray(kiselev) == false){
            printErrorWhenAddingEmployeeInArray(kiselev);
        }else if (insertEmployeeInArray(zazulov) == false){
            printErrorWhenAddingEmployeeInArray(zazulov);
        }else if (insertEmployeeInArray(binkovskay) == false){
            printErrorWhenAddingEmployeeInArray(binkovskay);
        }else if (insertEmployeeInArray(timonina) == false){
            printErrorWhenAddingEmployeeInArray(timonina);
        }else if (insertEmployeeInArray(semenov) == false){
            printErrorWhenAddingEmployeeInArray(semenov);
        }else if (insertEmployeeInArray(semenov) == false){
            printErrorWhenAddingEmployeeInArray(semenov);
        }else if (insertEmployeeInArray(semenov) == false){
            printErrorWhenAddingEmployeeInArray(semenov);
        }

        System.out.println("Задание. Базовая сложность:");
        System.out.println("Список всех сотрудников:");
        printEmployees(0);
        System.out.println("========================");
        System.out.println();
        System.out.println("Общая зарплата за месяц - " + totalSalaryInMounth(0));
        System.out.println("Сотрудник с минимальной зарплатой - " + findEmployeeSalaryMin(0).toString());
        System.out.println("Сотрудник с максимальной зарплатой - " + findEmployeeSalaryMax( 0).toString());
        System.out.println("Средняя зарплата за месяц - " + middleSalaryInMounth(0));
        System.out.println();
        System.out.println("ФИО всех сотрудников:");
        printOnlyNameEmployees();

        System.out.println();
        System.out.println("Задание. Повышенная  сложность:");
        indexationSalary(0, 10); // индесация зарплаты всех сотрудников
        System.out.println("Список всех сотрудников, после индексации:");
        printEmployees(0);
        System.out.println("Сотрудник с минимальной зарплатой, отдел 3 - " + findEmployeeSalaryMin(3).toStringWithoutDepartment());
        System.out.println("Сотрудник с максимальной зарплатой, отдел 2 - " + findEmployeeSalaryMax(2).toStringWithoutDepartment());
        System.out.println("Общая зарплата за месяц, отдел 3 - " + totalSalaryInMounth(3));
        System.out.println("Средняя зарплата за месяц, отдел 3 - " + middleSalaryInMounth(3));
        indexationSalary(2, 5); // индесация зарплаты сотрудников, отдела 2
        System.out.println("Список всех сотрудников отдела 2, после индексации:");
        printEmployees(2);
        System.out.println("Список всех сотрудников с зарплатой меньше 100 тыс.:");
        printEmployeesSalaryLow(100000);
        System.out.println("Список всех сотрудников с зарплатой выше или ровно 100 тыс.:");
        printEmployeesSalaryHigh(100000);


    }

    // Метод добавляет сотрудника в массив
    private static boolean insertEmployeeInArray(Employee employee) {
        boolean employeeAdd = false;

        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] == null) {
                arrEmployees[i] = employee;
                employeeAdd = true;
                break;
            }
        }
        return employeeAdd;
    }

    private static void printErrorWhenAddingEmployeeInArray(Employee employee) {
        System.out.println(employee.getName() + " - не был добавлен в массив, т.к. в массиве нет свободного места!");
    }

    private static void printEmployees(int department){
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] == null) {
                continue;
            }
            if (department == 0){
                System.out.println(arrEmployees[i].toString());
            } else if (arrEmployees[i].getDepartment() == department) {
                System.out.println(arrEmployees[i].toStringWithoutDepartment());
            }
        }
    }

    private static void printOnlyNameEmployees(){
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] != null){
                System.out.println(arrEmployees[i].getName());
            }
        }
    }


    // Метод проверяет условия соответсвия департаменту. Для упращение написания основных методов
    private static boolean checDepartmentMatches(Employee employees, int department) {
        return employees != null && (department == 0 || department == employees.getDepartment());
    }

    // Метод возращает сумму всех ЗП. Если нужно считать по всему массиву то парамтер отдела = 0,
    // если по конретному отделу, то указываем номер отдела
    private static int totalSalaryInMounth(int department) {
        int totalSalaryInMounth = 0;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (checDepartmentMatches(arrEmployees[i], department)){
                totalSalaryInMounth = totalSalaryInMounth + arrEmployees[i].getSalary();
            }
        }
        return totalSalaryInMounth;
    }

    // Метод ищет сотрудника с максимальной ЗП. Если нужно искать по всему массиву то парамтер отдела = 0,
    // если по конретному отделу, то указываем номер отдела
    private static Employee findEmployeeSalaryMin(int department) {
        Employee EmployeeSalaryMin = null;
        int minSalary = -1;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (!checDepartmentMatches(arrEmployees[i], department)) {
                continue;
            }
            if (minSalary == -1 || minSalary > arrEmployees[i].getSalary()) {
                EmployeeSalaryMin = arrEmployees[i];
                minSalary = arrEmployees[i].getSalary();
            }
        }
        return EmployeeSalaryMin;
    }

    // Метод ищет сотрудника с максимальной ЗП. Если нужно искать по всему массиву то парамтер отдела = 0,
    // если по конретному отделу, то указываем номер отдела
    private static Employee findEmployeeSalaryMax(int department) {
        Employee EmployeeSalaryMax = null;
        int maxSalary = 0;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (!checDepartmentMatches(arrEmployees[i], department)) {
                continue;
            }
            if (maxSalary == 0|| maxSalary < arrEmployees[i].getSalary()) {
                EmployeeSalaryMax = arrEmployees[i];
                maxSalary = arrEmployees[i].getSalary();
            }
        }
        return EmployeeSalaryMax;
    }

    // Метод возращает среднюю ЗП. Если нужно искать по всему массиву то парамтер отдела = 0,
    // если по конретному отделу, то указываем номер отдела
    private static double middleSalaryInMounth(int department) {
        return totalSalaryInMounth(department) / (double)(employeesInDepartment(department));
    }

    // Метод возвращает количетсво сотрудников  в отделе
    private static int employeesInDepartment(int department) {
        int count = 0;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] != null) {
                if (department == 0) {
                    count++;
                } else if (arrEmployees[i].getDepartment() == department) {
                    count++;
                }
            }
        }
        return count;
    }

    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    private static void indexationSalary(int department, int percent) {
        int salary;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (!checDepartmentMatches(arrEmployees[i], department)){
                continue;
            }
            salary = arrEmployees[i].getSalary();
            arrEmployees[i].setSalary(salary + (salary * percent / 100));
        }
    }

    // Метод печатает всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printEmployeesSalaryLow(int levelSalary) {
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i].getSalary() < levelSalary) {
                System.out.println(arrEmployees[i].toStringWithoutDepartment());
            }
        }
    }

    // Метод печатает всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    private static void printEmployeesSalaryHigh(int levelSalary) {
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i].getSalary() >= levelSalary) {
                System.out.println(arrEmployees[i].toStringWithoutDepartment());
            }
        }
    }

}
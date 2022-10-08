public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Выполенение курсовой работы №1. Базовый уровень");

        Employee[] arrEmployees = new Employee[10];
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

        if (insertEmployeeInArray(arrEmployees, petrov) == false) {
        }else if (insertEmployeeInArray(arrEmployees, ivanov) == false){
        }else if (insertEmployeeInArray(arrEmployees, sidorov) == false){
        }else if (insertEmployeeInArray(arrEmployees, sharipov) == false){
        }else if (insertEmployeeInArray(arrEmployees, strokova) == false){
        }else if (insertEmployeeInArray(arrEmployees, kiselev) == false){
        }else if (insertEmployeeInArray(arrEmployees, zazulov) == false){
        }else if (insertEmployeeInArray(arrEmployees, binkovskay) == false){
        }else if (insertEmployeeInArray(arrEmployees, timonina) == false){
        }else if (insertEmployeeInArray(arrEmployees, semenov) == false){
        }else if (insertEmployeeInArray(arrEmployees, semenov) == false){
        }else if (insertEmployeeInArray(arrEmployees, semenov) == false){
        }

        System.out.println("Задание. Базовая сложность:");
        System.out.println("Список всех сотрудников:");
        printEmployees(arrEmployees, 0);
        System.out.println("========================");
        System.out.println();
        System.out.println("Общая зарплата за месяц - " + totalSalaryInMounth(arrEmployees, 0));
        System.out.println("Сотрудник с минимальной зарплатой - " + findEmployeeSalaryMin(arrEmployees, 0).toString());
        System.out.println("Сотрудник с максимальной зарплатой - " + findEmployeeSalaryMax(arrEmployees, 0).toString());
        System.out.println("Средняя зарплата за месяц - " + middleSalaryInMounth(arrEmployees, 0));
        System.out.println();
        System.out.println("ФИО всех сотрудников:");
        printOnlyNameEmployees(arrEmployees);

        System.out.println();
        System.out.println("Задание. Повышенная  сложность:");
        indexationSalary(arrEmployees, 0, 10); // индесация зарплаты всех сотрудников
        System.out.println("Список всех сотрудников, после индексации:");
        printEmployees(arrEmployees, 0);
        System.out.println("Сотрудник с минимальной зарплатой, отдел 3 - " + findEmployeeSalaryMin(arrEmployees, 3).toStringWithoutDepartment());
        System.out.println("Сотрудник с максимальной зарплатой, отдел 2 - " + findEmployeeSalaryMax(arrEmployees, 2).toStringWithoutDepartment());
        System.out.println("Общая зарплата за месяц, отдел 3 - " + totalSalaryInMounth(arrEmployees, 3));
        System.out.println("Средняя зарплата за месяц, отдел 3 - " + middleSalaryInMounth(arrEmployees, 3));
        indexationSalary(arrEmployees, 2, 5); // индесация зарплаты сотрудников, отдела 2
        System.out.println("Список всех сотрудников отдела 2, после индексации:");
        printEmployees(arrEmployees, 2);
        System.out.println("Список всех сотрудников с зарплатой меньше 100 тыс.:");
        printEmployeesSalaryLow(arrEmployees, 100000);
        System.out.println("Список всех сотрудников с зарплатой выше или ровно 100 тыс.:");
        printEmployeesSalaryHigh(arrEmployees, 100000);


    }

    // Метод добавляет сотрудника в массив
    public static boolean insertEmployeeInArray(Employee[] arrEmployees, Employee employee) {
        boolean employeeAdd = false;

        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] == null) {
                arrEmployees[i] = employee;
                employeeAdd = true;
                break;
            }
        }
        if (employeeAdd == false){
            System.out.println(employee.getName() + " - не был добавлен в массив, т.к. в массиве нет свободного места!");
        }
        return employeeAdd;
    }

    public static void printEmployees(Employee[] arrEmployees, int department){
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

    public static void printOnlyNameEmployees(Employee[] arrEmployees){
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] != null){
                System.out.println(arrEmployees[i].getName());
            }
        }
    }


    // Метод проверяет условия соответсвия департаменту. Для упращение написания основных методов
    public static boolean checDepartmentMatches(Employee employees, int department) {
        if (employees == null ||
                (department != 0 && department != employees.getDepartment())) {
            return false;
        } else {
            return true;
        }
    }

    // Метод возращает сумму всех ЗП. Если нужно считать по всему массиву то парамтер отдела = 0,
    // если по конретному отделу, то указываем номер отдела
    public static int totalSalaryInMounth(Employee[] arrEmployees, int department) {
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
    public static Employee findEmployeeSalaryMin(Employee[] arrEmployees, int department) {
        Employee EmployeeSalaryMin = new Employee("", 0, 0);
        int minSalary = -1;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (checDepartmentMatches(arrEmployees[i], department) == false) {
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
    public static Employee findEmployeeSalaryMax(Employee[] arrEmployees, int department) {
        Employee EmployeeSalaryMax = new Employee("", 0, 0);
        int maxSalary = 0;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (checDepartmentMatches(arrEmployees[i], department) == false) {
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
    public static int middleSalaryInMounth(Employee[] arrEmployees, int department) {
        if (department == 0) {
            return totalSalaryInMounth(arrEmployees, 0) / arrEmployees.length;
        } else {
            return totalSalaryInMounth(arrEmployees, department) / employeesInDepartment(arrEmployees, department);
        }
    }

    // Метод возвращает количетсво сотрудников  в отделе
    public static int employeesInDepartment(Employee[] arrEmployees, int department) {
        int count = 0;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i].getDepartment() == department) {
                count++;
            }
        }
        return count;
    }

    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public static void indexationSalary(Employee[] arrEmployees, int department, int percent) {
        int salary;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (checDepartmentMatches(arrEmployees[i], department) == false){
                continue;
            }
            salary = arrEmployees[i].getSalary();
            arrEmployees[i].setSalary(salary + (salary * percent / 100));
        }
    }

    // Метод печатает всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public static void printEmployeesSalaryLow(Employee[] arrEmployees, int levelSalary) {
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i].getSalary() < levelSalary) {
                System.out.println(arrEmployees[i].toStringWithoutDepartment());
            }
        }
    }

    // Метод печатает всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public static void printEmployeesSalaryHigh(Employee[] arrEmployees, int levelSalary) {
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i].getSalary() >= levelSalary) {
                System.out.println(arrEmployees[i].toStringWithoutDepartment());
            }
        }
    }

}
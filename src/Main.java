public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Выполенение курсовой работы №1. Базовый уровень");

        Employee[] arrEmployees = new Employee[10];
        Employee employeeMinSalary;
        Employee employeeMaxSalary;

        Employee petrov = new Employee("Петров Александр Сергеевич", 2, 56000);
        Employee ivanov = new Employee("Иванов Иван Иванович", 4, 38000);
        Employee sidorov = new Employee("Сидоров Петр Ивановоич", 5, 78000);
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

        System.out.println("Список всех сотрудников:");
        printEmployees(arrEmployees);
        System.out.println("========================");
        System.out.println();
        System.out.println("Общая зарплата за месяц - " + totalSalaryInMounth(arrEmployees));
        System.out.println("Сотрудник с минимальной зарплатой - " + findEmployeeSalaryMin(arrEmployees).toString());
        System.out.println("Сотрудник с максимальной зарплатой - " + findEmployeeSalaryMax(arrEmployees).toString());
        System.out.println("Средняя зарплата за месяц - " + middleSalaryInMounth(arrEmployees));
        System.out.println();
        System.out.println("ФИО всех сотрудников:");
        printOnlyNameEmployees(arrEmployees);

    }
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

    public static void printEmployees(Employee[] arrEmployees){
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] != null){
                System.out.println(arrEmployees[i].toString());
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

    public static int totalSalaryInMounth(Employee[] arrEmployees) {
        int totalSalaryInMounth = 0;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] != null){
                totalSalaryInMounth = totalSalaryInMounth + arrEmployees[i].getSalary();
            }
        }
        return totalSalaryInMounth;
    }

    public static Employee findEmployeeSalaryMin(Employee[] arrEmployees) {
        Employee EmployeeSalaryMin = new Employee("", 0, 0);
        int minSalary = -1;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] != null) {
                if (minSalary == -1 || minSalary > arrEmployees[i].getSalary()) {
                    EmployeeSalaryMin = arrEmployees[i];
                    minSalary = arrEmployees[i].getSalary();
                }
            }
        }
        return EmployeeSalaryMin;
    }

    public static Employee findEmployeeSalaryMax(Employee[] arrEmployees) {
        Employee EmployeeSalaryMax = new Employee("", 0, 0);
        int maxSalary = 0;
        for (int i = 0; i < arrEmployees.length; i++) {
            if (arrEmployees[i] != null) {
                if (maxSalary == 0|| maxSalary < arrEmployees[i].getSalary()) {
                    EmployeeSalaryMax = arrEmployees[i];
                    maxSalary = arrEmployees[i].getSalary();
                }
            }
        }
        return EmployeeSalaryMax;
    }

    public static int middleSalaryInMounth(Employee[] arrEmployees) {
        return totalSalaryInMounth(arrEmployees) / arrEmployees.length;
    }
}
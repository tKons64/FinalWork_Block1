public class Employee {
    private String name;
    private int department;
    private int salary;
    int id;

    static int count = 0;

    public Employee(String name, int department, int salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = count++;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник id=" + id + " {" +
                "ФИО='" + name + '\'' +
                ", департамент=" + department +
                ", ЗП=" + salary +
                '}';
    }

    public String toStringWithoutDepartment() {
        return "Сотрудник id=" + id + " {" +
                "ФИО='" + name + '\'' +
                ", ЗП=" + salary +
                '}';
    }


}

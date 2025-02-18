
import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name = name;
        this.id = id;
    }

    public String getname(){
        return name;
    }

    public int getid(){
        return id;
    }

   public abstract double calculateSalary();

   @Override
   public String toString(){
    return "Employee[name="+name+",id="+id+",salary="+calculateSalary()+"]";
   }
}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
     return monthlySalary;
}
}

class PartTimeEmployee extends Employee{

    private int HoursWork;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id,int HoursWork,double hourlyRate){
        super(name, id);
        this.HoursWork = HoursWork;
        this.hourlyRate = hourlyRate;


        }
        @Override

        public double calculateSalary(){
            return HoursWork * hourlyRate;
    }

}

class  PayRollSystem{
    private ArrayList<Employee> employeeList;

    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }
    public void AddEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void RemoveEmployee(int id){
        Employee employeeToRemove = null;

        for(Employee employee : employeeList){
            if(employee.getid() == id){
                employeeToRemove = employee;
                break;

            }
        }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }

    }

    public void  disPlayEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

class Main {
    public static void main(String[] args) {
        PayRollSystem payrollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikas" , 1,70000.00);
        PartTimeEmployee emp2 = new PartTimeEmployee("Alexander", 2, 40, 100);

        payrollSystem.AddEmployee(emp1);
        payrollSystem.AddEmployee(emp2);
        System.out.println("Initial Employee Details: ");
        payrollSystem.disPlayEmployee();
        System.out.println("Removing employees");
        payrollSystem.RemoveEmployee(2);
        System.out.println("Remaining Employee Details");
        payrollSystem.disPlayEmployee();
        
    }
    
}

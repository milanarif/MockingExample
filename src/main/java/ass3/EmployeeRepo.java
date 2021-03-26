package ass3;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeRepo implements EmployeeRepository {
   private static List<Employee> employeeArray;

   public EmployeeRepo(){
      employeeArray = new ArrayList<>();
   }

   public EmployeeRepo(List<Employee> list){
      employeeArray = new ArrayList<>(list);
   }

   @Override
   public List<Employee> findAll() {
      return employeeArray;
   }

   @Override
   public Employee save(Employee e) {
      for (Employee emp : employeeArray) {
         if (emp.getId().equalsIgnoreCase(e.getId())){
            employeeArray.set(employeeArray.indexOf(emp), e);
            return e;
         }
      }
      employeeArray.add(e);
      return e;
   }
}


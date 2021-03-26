package ass3;

import com.example.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeRepoTest {

   @Test
   void findAllEmptyArray(){
      EmployeeRepo repo = new EmployeeRepo();
      assertThat(repo.findAll().isEmpty());
   }

   @Test
   void SaveEmployeeToRepo(){
      EmployeeRepo repo = new EmployeeRepo();
      repo.save(new Employee("one", 2000));

      assertThat(repo.findAll()).isNotEmpty();
   }

   @Test
   void testSameIdOverwrites(){
      EmployeeRepo repo = new EmployeeRepo();
      repo.save(new Employee("one", 2000));
      repo.save(new Employee("one", 2000));

      assertThat(repo.findAll().size()).isEqualTo(1);
   }

   @Test
   void initializeWithEmployees(){
      List<Employee> initialList = new ArrayList<>();
      initialList.add(new Employee("one", 2000));
      initialList.add(new Employee("two", 4000));
      EmployeeRepo repoWithStartValues = new EmployeeRepo(initialList);

      assertThat(repoWithStartValues.findAll()).containsAll(initialList);
   }
}

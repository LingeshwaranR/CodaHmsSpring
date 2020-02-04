package global.coda.hms.repo;

import global.coda.hms.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
    @Query(value="SELECT * FROM t_employee",nativeQuery =true)
    Collection<Employee> readEmployeeBy(int id);

}

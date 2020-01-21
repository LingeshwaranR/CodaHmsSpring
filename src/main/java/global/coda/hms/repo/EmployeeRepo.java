package global.coda.hms.repo;

import global.coda.hms.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {


}

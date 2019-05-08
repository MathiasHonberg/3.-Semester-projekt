package semesterprojekt.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import semesterprojekt.demo.Model.Test;

public interface ITestRepo extends CrudRepository<Test, Long> {

}

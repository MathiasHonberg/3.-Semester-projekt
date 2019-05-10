package semesterprojekt.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import semesterprojekt.demo.Model.Kontakt;

import java.util.Optional;

public interface IKontaktRepo extends CrudRepository<Kontakt, Long>
{
    Optional<Kontakt> findById (Long id);

}

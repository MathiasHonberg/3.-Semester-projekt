package semesterprojekt.demo.Repo;

import org.springframework.data.repository.CrudRepository;
import semesterprojekt.demo.Model.Contact;

public interface IContactRepo extends CrudRepository<Contact, Long>
{
    Contact findAllById (Long id);

}

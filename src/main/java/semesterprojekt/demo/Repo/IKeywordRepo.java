package semesterprojekt.demo.Repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import semesterprojekt.demo.Model.Keyword;

import javax.transaction.Transactional;

public interface IKeywordRepo extends CrudRepository<Keyword, Long> {

    Keyword findAllByName(String id);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("UPDATE NavigationBar n SET " +
            "n.name=:name " +
            "WHERE n.id =:id")
    void UpdateKeywordById(
            @Param("name") String name,
            @Param("id") Long id);
}

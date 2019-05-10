package semesterprojekt.demo.Service;

import semesterprojekt.demo.Model.Kontakt;


public interface IKontaktService {

    Iterable<Kontakt> findAll();
    Kontakt findKontaktById(int id);
    Kontakt addKontakt (Kontakt k);
    boolean editKontakt(Kontakt k);
    boolean deleteKontakt(int id);

}

package semesterprojekt.demo.Service;

import semesterprojekt.demo.Model.Contact;


public interface IContactService {

    Iterable<Contact> findAll();
    Contact findKontaktById(Long id);
    Contact addKontakt (Contact k);
    Contact editKontakt(Contact k);
    void deleteKontakt(Long id);

}

package semesterprojekt.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.Contact;
import semesterprojekt.demo.Repo.IContactRepo;

@Service
public class ContactServiceImpl implements IContactService
{

    @Autowired
    IContactRepo iContactRepo;

    @Override
    public Iterable<Contact> findAll()
    {
        return iContactRepo.findAll();
    }

    @Override
    public Contact findContactById(Long id)
    {
        return iContactRepo.findAllById(id);
    }

    @Override
    public Contact addContact(Contact contact)
    {
        return iContactRepo.save(contact);
    }

    @Override
    public Contact editContact(Contact contact)
    {
        return iContactRepo.save(contact);
    }

    @Override
    public void deleteContact(Long id)
    {
        iContactRepo.deleteById(id);
    }
}

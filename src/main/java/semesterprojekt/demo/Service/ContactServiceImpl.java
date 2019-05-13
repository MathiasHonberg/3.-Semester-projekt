package semesterprojekt.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.Contact;
import semesterprojekt.demo.Repo.IContactRepo;

@Service
public class ContactServiceImpl implements IContactService
{

    @Autowired
    IContactRepo kontaktRepo;

    @Override
    public Iterable<Contact> findAll()
    {
        return kontaktRepo.findAll();
    }

    @Override
    public Contact findKontaktById(Long id)
    {

        return kontaktRepo.findAllById(id);
    }

    @Override
    public Contact addKontakt(Contact k)
    {
        return kontaktRepo.save(k);
    }

    @Override
    public Contact editKontakt(Contact k)
    {

        return kontaktRepo.save(k);
    }

    @Override
    public void deleteKontakt(Long id)
    {

        kontaktRepo.deleteById(id);
    }
}

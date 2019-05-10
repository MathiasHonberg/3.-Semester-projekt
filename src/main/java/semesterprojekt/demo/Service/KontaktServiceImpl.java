package semesterprojekt.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.Kontakt;
import semesterprojekt.demo.Repo.IKontaktRepo;

@Service
public class KontaktServiceImpl implements IKontaktService
{

    @Autowired
    IKontaktRepo kontaktRepo;

    @Override
    public Iterable<Kontakt> findAll()
    {
        return kontaktRepo.findAll();
    }

    @Override
    public Kontakt findKontaktById(int id)
    {
        return null;
    }

    @Override
    public Kontakt addKontakt(Kontakt k)
    {
        return kontaktRepo.save(k);
    }

    @Override
    public boolean editKontakt(Kontakt k)
    {
        return false;
    }

    @Override
    public boolean deleteKontakt(int id)
    {
        return false;
    }
}

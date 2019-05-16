package semesterprojekt.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.Keyword;
import semesterprojekt.demo.Repo.IKeywordRepo;

@Service
public class KeywordServiceImpl implements IKeywordService
{

    @Autowired
    IKeywordRepo iKeywordRepo;

    @Override
    public Iterable<Keyword> fetchAllKeywords()
    {
        return iKeywordRepo.findAll();
    }

    @Override
    public void editProduct(Keyword keyword)
    {
        Long id = keyword.getId();
        String name = keyword.getName();


        iKeywordRepo.UpdateKeywordById(name, id);
    }
}

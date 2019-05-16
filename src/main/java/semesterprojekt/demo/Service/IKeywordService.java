package semesterprojekt.demo.Service;

import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.Keyword;

@Service
public interface IKeywordService
{

    Iterable<Keyword> fetchAllKeywords();
    void editProduct(Keyword keyword);

}

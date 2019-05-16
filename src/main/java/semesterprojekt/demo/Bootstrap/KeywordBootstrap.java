package semesterprojekt.demo.Bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import semesterprojekt.demo.Model.Keyword;
import semesterprojekt.demo.Repo.IKeywordRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class KeywordBootstrap implements ApplicationListener<ContextRefreshedEvent>
{
    @Autowired
    IKeywordRepo iKeywordRepo;

    private List<Keyword> createKeywords()
    {

        List<Keyword> keywordList = new ArrayList<>();
        Keyword keyword = new Keyword();
        keyword.setName("Kategorier");

        return keywordList;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        System.out.println("KEYWORD_BOOTSTRAP context refreshed");
        iKeywordRepo.saveAll(createKeywords());

    }
}

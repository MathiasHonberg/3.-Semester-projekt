package semesterprojekt.demo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.NewsModel;
import semesterprojekt.demo.Repo.INewsRepo;

@Service
public class NewsServiceImpl implements INewsService
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    INewsRepo iNewsRepo;

    @Override
    public NewsModel createNews(NewsModel newsModel)
    {
        iNewsRepo.save(newsModel);

        return null;
    }

    @Override
    public Iterable<NewsModel> fetchAllNews()
    {
        return iNewsRepo.findAll();
    }

    @Override
    public void deleteSpecificNews(Long id)
    {
        iNewsRepo.deleteById(id);
    }
}

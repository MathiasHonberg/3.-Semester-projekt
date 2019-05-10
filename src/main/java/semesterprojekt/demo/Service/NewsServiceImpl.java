package semesterprojekt.demo.Service;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semesterprojekt.demo.Model.NewsModel;
import semesterprojekt.demo.Repo.INewsRepo;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class NewsServiceImpl implements INewsService
{
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private SessionFactory hibernateFactory;

    @Autowired
    INewsRepo iNewsRepo;
    /*
    @Override
    @Transactional
    public NewsModel createNews(NewsModel newsModel)
    {

        iNewsRepo.save(newsModel);

        return null;
    }
    */

    @Override
    @Transactional
    public void saveImage(NewsModel newsModel)
    {
        hibernateFactory.getCurrentSession().save(newsModel);
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

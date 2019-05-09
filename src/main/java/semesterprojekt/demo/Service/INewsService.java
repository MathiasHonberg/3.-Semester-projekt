package semesterprojekt.demo.Service;

import semesterprojekt.demo.Model.NewsModel;

public interface INewsService {

    NewsModel createNews(NewsModel newsModel);

    Iterable<NewsModel> fetchAllNews();

    void deleteSpecificNews(Long id);
}

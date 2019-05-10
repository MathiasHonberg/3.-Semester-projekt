package semesterprojekt.demo.Service;

import semesterprojekt.demo.Model.NewsModel;

import java.io.IOException;

public interface INewsService {

    //NewsModel createNews(NewsModel newsModel);
    void saveImage(NewsModel newsModel);

    Iterable<NewsModel> fetchAllNews();

    void deleteSpecificNews(Long id);


}

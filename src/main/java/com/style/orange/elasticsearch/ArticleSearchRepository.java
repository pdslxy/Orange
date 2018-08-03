package com.style.orange.elasticsearch;

import com.style.orange.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Mr.Li
 * @create 2018-08-01 13:58
 * @desc esDao
 **/
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
}

package com.style.orange.controller;

import com.style.orange.elasticsearch.ArticleSearchRepository;
import com.style.orange.model.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Mr.Li
 * @create 2018-08-01 14:00
 * @desc ES接口
 **/
@RestController
@RequestMapping("/es")
@Api(tags={"ES接口"})
public class ElasticSearchController {
    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @PutMapping("/add/{id}")
    @ApiOperation("新增数据")
    @ApiImplicitParam(name = "id", value = "id", required = true)
    public void add(@PathVariable("id") Long id) {
        Article article = new Article();
        article.setId(id);
        article.setTitle("springboot integreate elasticsearch");
        article.setAbstracts("springboot integreate elasticsearch is very easy");
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);
        articleSearchRepository.save(article);
    }

    @GetMapping("/find/{keyword}")
    @ApiOperation("根据关键字查询")
    @ApiImplicitParam(name = "keyword", value = "关键字")
    public List<Article> find(@PathVariable(name = "keyword", required = false) String keyword) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(keyword);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        List<Article> list = new ArrayList<>();
        searchResult.forEach(article -> {
            list.add(article);
        });
        return list;
    }
}

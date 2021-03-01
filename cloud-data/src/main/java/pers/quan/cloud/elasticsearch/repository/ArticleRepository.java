package pers.quan.cloud.elasticsearch.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pers.quan.cloud.elasticsearch.po.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
	
	List<Article> findByTitleContaining(String title);
	
} 
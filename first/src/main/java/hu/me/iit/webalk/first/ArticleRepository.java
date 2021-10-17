package hu.me.iit.webalk.first;

import java.util.List;

public interface ArticleRepository {
	List<ArticleDto> findAll();
	Long save(ArticleDto articleDto);
	void deleteById(Long id);
	ArticleDto getById(Long id);
}

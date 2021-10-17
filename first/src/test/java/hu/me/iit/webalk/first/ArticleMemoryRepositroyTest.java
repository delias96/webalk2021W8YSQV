package hu.me.iit.webalk.first;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ArticleMemoryRepositroyTest {

	@Test
	public void findAll_Empty() {
		//Given
		ArticleMemoryRepositroy articleMemoryRepositroy = new ArticleMemoryRepositroy();
		//When
		List<ArticleDto> result = articleMemoryRepositroy.findAll();
		//Then
		assertEquals(0, result.size());
	}

	@Test
	public void findAll_NotEmpty() {
		//Given
		ArticleMemoryRepositroy articleMemoryRepositroy = new ArticleMemoryRepositroy();
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("J.K.Rowling");
		articleDto.setPages(300);
		articleDto.setTitle("Harry Potter");
		articleDto.setId(2L);
		articleMemoryRepositroy.save(articleDto);
		//When
		List<ArticleDto> result = articleMemoryRepositroy.findAll();
		//Then
		assertEquals(1, result.size());
		assertEquals(articleDto, result.get(0));
	}

	@Test
	public void findArticleById() {
		//Given
				ArticleMemoryRepositroy articleMemoryRepositroy = new ArticleMemoryRepositroy();
				Long id = 2L;
				Long notExistedId = 4L;
				ArticleDto articleDto = new ArticleDto();
				articleDto.setAuthor("J.K.Rowling");
				articleDto.setPages(300);
				articleDto.setTitle("Harry Potter");
				articleDto.setId(id);
				articleMemoryRepositroy.save(articleDto);
				//When
				int result = articleMemoryRepositroy.findArticleById(notExistedId);
				//Then
				assertEquals(-1, result);

	}

	@Test
	public void DeleteById_exists() {
		//Given
		ArticleMemoryRepositroy articleMemoryRepositroy = new ArticleMemoryRepositroy();
		Long id = 2L;
		Long notExistedId = 4L;
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("J.K.Rowling");
		articleDto.setPages(300);
		articleDto.setTitle("Harry Potter");
		articleDto.setId(id);
		articleMemoryRepositroy.save(articleDto);
		//When
		articleMemoryRepositroy.deleteById(id);;
		//Then
		assertEquals(0, articleMemoryRepositroy.findAll().size());
	}
	@Test
	public void DeleteById_notexists() {
		//Given
		ArticleMemoryRepositroy articleMemoryRepositroy = new ArticleMemoryRepositroy();
		Long id = 2L;
		Long notExistedId = 4L;
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("J.K.Rowling");
		articleDto.setPages(300);
		articleDto.setTitle("Harry Potter");
		articleDto.setId(id);
		articleMemoryRepositroy.save(articleDto);
		//When
		articleMemoryRepositroy.deleteById(notExistedId);;
		//Then
		assertEquals(1, articleMemoryRepositroy.findAll().size());
	}
	@Test
	public void getById_notExists() {
		//Given
				ArticleMemoryRepositroy articleMemoryRepositroy = new ArticleMemoryRepositroy();
				Long id = 2L;
				Long notExistedId = 4L;
				ArticleDto articleDto = new ArticleDto();
				articleDto.setAuthor("J.K.Rowling");
				articleDto.setPages(300);
				articleDto.setTitle("Harry Potter");
				articleDto.setId(id);
				articleMemoryRepositroy.save(articleDto);
				//When
				ArticleDto dto = articleMemoryRepositroy.getById(notExistedId);
				//then
				assertEquals(dto, articleDto);
	}
	@Test
	public void save_update() {
		//Given
		ArticleMemoryRepositroy articleMemoryRepositroy = new ArticleMemoryRepositroy();
		Long id = 2L;
		Long notExistedId = 4L;
		ArticleDto articleDto = new ArticleDto();
		articleDto.setAuthor("J.K.Rowling");
		articleDto.setPages(300);
		articleDto.setTitle("Harry Potter");
		articleDto.setId(id);
		articleMemoryRepositroy.save(articleDto);
		//When
		ArticleDto articleDto2 = new ArticleDto();
		articleDto2.setAuthor("J.K.Rowling2");
		articleDto2.setPages(500);
		articleDto2.setTitle("Harry Potter 2");
		articleDto2.setId(id);
		articleMemoryRepositroy.save(articleDto2);
		//then
		List<ArticleDto> articleDtoList = articleMemoryRepositroy.findAll();
		assertEquals(1, articleDtoList.size());
		assertEquals(articleDto2, articleDtoList.get(0));
	}
}

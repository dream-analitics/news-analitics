package org.neigbors.analitics.service;

import org.neigbors.analitics.dto.ArticleDto;
import org.neigbors.analitics.dto.ArticleSetDto;
import org.neigbors.analitics.dto.CategoryDto;

import java.util.List;

/**
 * Service that will dial with fetching news
 */
public interface ArticleService {

    List<ArticleDto> fetchLatestNews();

    List<CategoryDto> fetchAllRootCategories();

    ArticleSetDto getArticlesByCategoryId(Integer categoryId, Integer count);
}

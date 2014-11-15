package org.neigbors.analitics.service;

import org.neigbors.analitics.dto.ArticleDto;

import java.util.List;

/**
 * Service that will dial with fetching news
 */
public interface ArticleService {

    List<ArticleDto> fetchLatestNews();
}

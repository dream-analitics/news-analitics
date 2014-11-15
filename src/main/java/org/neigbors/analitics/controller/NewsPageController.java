package org.neigbors.analitics.controller;

import org.neigbors.analitics.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Controls the news page
 */
@Controller
@RequestMapping("/news")
public class NewsPageController {

    @Resource
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public String showLatestNews(ModelMap model) {
        model.addAttribute("articles", articleService.fetchLatestNews());
        return "news";
    }
}

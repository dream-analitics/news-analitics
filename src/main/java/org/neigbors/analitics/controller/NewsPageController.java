package org.neigbors.analitics.controller;

import org.neigbors.analitics.dto.ArticleDto;
import org.neigbors.analitics.dto.ArticleSetDto;
import org.neigbors.analitics.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
        model.addAttribute("root_categories", articleService.fetchAllRootCategories());
        model.addAttribute("articles", articleService.fetchLatestNews());
        return "news";
    }

    @RequestMapping(value = "/srefresh", method = RequestMethod.GET)
    @ResponseBody
    public Object add(
            @RequestParam(value="categoryId", required=true) Integer categoryId,
            @RequestParam(value="count", required=false, defaultValue = "3") Integer count) {

        return articleService.getArticlesByCategoryId(categoryId, count);
    }
}

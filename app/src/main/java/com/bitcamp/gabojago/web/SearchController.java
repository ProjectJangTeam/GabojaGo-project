package com.bitcamp.gabojago.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bitcamp.gabojago.service.search.exhibition.ExhibitionSearchService;
import com.bitcamp.gabojago.service.search.exhibition.ExhibitionSearchType;
import com.bitcamp.gabojago.service.search.member.MemberSearchService;
import com.bitcamp.gabojago.service.search.member.MemberSearchType;
import com.bitcamp.gabojago.service.search.recommendation.RecommendationSearchService;
import com.bitcamp.gabojago.service.search.recommendation.RecommendationSearchType;

@Controller
@RequestMapping("/search/")
public class SearchController {
  
  @Autowired
  ExhibitionSearchService exhibitionSearchService;
  
  @Autowired
  MemberSearchService memberSearchService;
  
  @Autowired
  RecommendationSearchService reccomendationSearchService;
  
  @GetMapping("searchForm")
  public void search(Model model) throws Exception {
  }
  
  @GetMapping("searchResult")
  public void searchResult(Model model, String keyword) throws Exception {
    model.addAttribute("exhibitionResult", exhibitionSearchService.getResult(ExhibitionSearchType.TITLE, keyword));
    model.addAttribute("memberResult", memberSearchService.getResult(MemberSearchType.PUBLIC, keyword));
    model.addAttribute("recommendationResult", reccomendationSearchService.getResult(RecommendationSearchType.DEFAULT, keyword));
  }
}

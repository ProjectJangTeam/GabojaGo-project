package com.bitcamp.gabojago.service.search.exhibition;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.gabojago.dao.search.ExhibitionSearchDAO;
import com.bitcamp.gabojago.service.search.SearchService;

/**
 * 
 * <p>
 * 전시회 검색 기능을 제공하는 Service 클래스입니다.
 * </p>
 * 
 * <p>
 * 이 객체는 {@link #getResult(ExhibitionSearchType, String)} 메서드를 통해 전시회 검색을 수행합니다.<br>
 * </p>
 *
 */
@Service
public class ExhibitionSearchService implements SearchService<ExhibitionSearchType> {

  @Autowired
  private ExhibitionSearchDAO searchDAO;

  /**
   * <p>
   * 전시회 검색 기능을 제공하는 메서드입니다.
   * </p>
   * 
   * @param type : {@link #ExhibitionSearchType} 열거형 원소 중 하나를 입력받습니다.
   * 각각의 원소가 실행하는 검색 방법은 해당 열거형 타입의 설명을 참조해주세요.
   * 
   * @param keyword : 검색할 검색어를 입력받습니다. 검색한 입력어는 공백을 기준으로 파싱되어 검색됩니다.
   */
  @Override
  public List<Map<String, String>> getResult(ExhibitionSearchType type, String keyword) {
    return type.execute(searchDAO, parseKeyword(keyword));
  }
}

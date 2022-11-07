package com.bitcamp.gabojago.service.search.member;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bitcamp.gabojago.dao.search.MemberSearchDAO;
import com.bitcamp.gabojago.service.search.SearchService;

/**
 * 
 * <p>
 * 회원 검색 기능을 제공하는 Service 클래스입니다.
 * </p>
 * 
 * <p>
 * 이 객체는 {@link #getResult(MemberSearchType, String)} 메서드를 통해 회원 검색을 수행합니다.<br>
 * </p>
 *
 */
@Service
public class MemberSearchService implements SearchService<MemberSearchType> {

  @Autowired
  private MemberSearchDAO searchDAO;

  /**
   * <p>
   * 회원 검색 기능을 제공하는 메서드입니다.
   * </p>
   * 
   * @param type : {@link #MemberSearchType} 열거형 원소 중 하나를 입력받습니다.
   * 각각의 원소가 실행하는 검색 방법은 해당 열거형 타입의 설명을 참조해주세요.
   * 
   * @param keyword : 검색할 검색어를 입력받습니다. 검색어는 대소문자를 구분하여 정확히 일치하는 닉네임만을 반환합니다.
   */
  @Override
  public List<Map<String, String>> getResult(MemberSearchType type, String keyword) {
    return type.execute(searchDAO, keyword);
  }
}

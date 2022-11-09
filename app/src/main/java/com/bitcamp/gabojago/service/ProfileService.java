package com.bitcamp.gabojago.service;


import com.bitcamp.gabojago.vo.Member;


public interface ProfileService {


    boolean profileUpdate(Member member) throws Exception;

    Member get(String id) throws Exception;

}

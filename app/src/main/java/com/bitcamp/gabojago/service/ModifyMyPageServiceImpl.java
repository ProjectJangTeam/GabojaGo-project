package com.bitcamp.gabojago.service;


import com.bitcamp.gabojago.dao.ModifyMyPageDao;
import com.bitcamp.gabojago.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyMyPageServiceImpl implements ModifyMyPageService {
    @Autowired
    ModifyMyPageDao modifyMyPageDao;


    @Override
    public boolean profileUpdate(Member member) throws Exception {
        if (modifyMyPageDao.profileUpdate(member) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean myAccountUpdate(Member member) throws Exception {
        if (modifyMyPageDao.myAccountUpdate(member) == 0) {
            return false;
        }
        return true;
    }
    @Override
    public Member get(String id) throws Exception {
        return modifyMyPageDao.findById(id);
    }



}


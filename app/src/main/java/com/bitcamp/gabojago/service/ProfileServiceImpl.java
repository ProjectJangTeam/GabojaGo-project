package com.bitcamp.gabojago.service;


import com.bitcamp.gabojago.dao.ProfileDao;
import com.bitcamp.gabojago.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileDao profileDao;


    @Override
    public Member get(String id) throws Exception {
        return profileDao.findById(id);
    }

    @Override
    public boolean profileUpdate(Member member) throws Exception {
        if (profileDao.update(member) == 0) {
            return false;
        }
        return true;
    }
}


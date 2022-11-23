package com.bitcamp.gabojago.service.payment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bitcamp.gabojago.dao.cart.CartDao;
import com.bitcamp.gabojago.vo.Member;
import com.bitcamp.gabojago.vo.OrderingInformation;

@Service
public class PaymentService {
  
  @Autowired
  CartDao cartDao;
  
  @Transactional
  public List<Map<String, String>> getCartList(Member member) {
    return cartDao.getCartList(member.getId());
  }
  
  @Transactional
  public List<Map<String, String>> getCheckedCartList(Member member, String exno){
    return cartDao.getCheckedCartList(member.getId(), exno.split(","));
  }
  
  @Transactional
  public void insertOrderingInfo (String paymentType, Member member, String exno) {
    List<OrderingInformation> infoList = cartDao.getOrderingInfo(exno.split(","));
    
    for(OrderingInformation info : infoList) {      
      info.setId(member.getId());
      info.setPayment(paymentType);
      info.setPurdate(new SimpleDateFormat ("yyyy-MM-dd").format(new Date()));
    
      cartDao.insertOrderingInfo(info);
    }
  }
  
  @Transactional
  public List<OrderingInformation> getOrderingInfo(Member member) {
    return cartDao.getOrderingInfoVo(member.getId());
  }
}

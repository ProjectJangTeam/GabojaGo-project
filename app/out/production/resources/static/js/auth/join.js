// 비밀번호 확인
var password = document.getElementById("password")
  ,confirm_password = document.getElementById("passwordConfirm");

function validatePassword() {
  if(password.value != passwordConfirm.value) {
    // 만일 두 인풋 필드값이 같지 않을 경우
    // setCustomValidity의 값을 지정해 무조건 경고 표시가 나게 하고
    passwordConfirm.setCustomValidity("비밀번호가 일치하지 않습니다.");
  }
  else {
    // 만일 두 인풋 필드값이 같을 경우
    // 오류가 없으면 메시지를 빈 문자열로 설정해야한다. 오류 메시지가 비어 있지 않은 한 양식은 유효성 검사를 통과하지 않고 제출되지 않는다.
    // 따라서 빈값을 주어 submit 처리되게 한다
    passwordConfirm.setCustomValidity('');
  }
}

password.onchange = validatePassword;
passwordConfirm.onkeyup = validatePassword;



// 아이디 중복 확인
  var doId = function () {
  var id = $("input.id").val();
  var idCheckBox = document.getElementById("idCheckBox");

  $.ajax({
    type: "POST",
    url: "idCheck",
    data: { id: id},
    success: function (result) {
      if(result == "true") {
        idCheckBox.innerHTML = "멋진 아이디에요!";
        idCheckBox.style.color = "green";
        window.cid = 1;
      } else if (result == "duplicated") {
        idCheckBox.innerHTML = "같은 아이디가 이미 사용중이에요.";
        idCheckBox.style.color = "red";
        window.cid = 0;
      } else if (result == "incorrect") {
        idCheckBox.innerHTML = "영문, 숫자 조합으로 4~12자로 입력해주세요.";
        idCheckBox.style.color = "red";
        window.cid = 0;
      }
    },
  });
};
  $(".id").blur(doId);



// 닉네임 중복 확인
  var doNickName = function () {
  var nickName = $("input.nickName").val();
  var nickNameCheckBox = document.getElementById("nickNameCheckBox");

  $.ajax({
    type: "GET",
    url: "nickNameCheck",
    data: { nickName: nickName},
    success: function (result) {
      if(result == "true") {
        nickNameCheckBox.innerHTML = "멋진 별명이에요!";
        nickNameCheckBox.style.color = "green";
        window.cnickname = 1;
      } else if (result == "duplicated") {
        nickNameCheckBox.innerHTML = "같은 별명이 이미 사용중이에요.";
        nickNameCheckBox.style.color = "red";
        window.cnickname = 0;
      } else if (result == "incorrect") {
        nickNameCheckBox.innerHTML = "영문, 한글, 숫자 조합으로 4~12자로 입력해주세요.";
        nickNameCheckBox.style.color = "red";
        window.cnickname = 0;
      }
    },
  });
};
  $(".nickName").blur(doNickName);



// 휴대전화 번호 중복 확인
  var doPhoneNo = function () {
  var phoneNo = $("input.cellphoneNo").val();
  var phoneNoCheckBox = document.getElementById("phoneNoCheckBox");

  $.ajax({
    type: "GET",
    url: "phoneNoCheck",
    data: { phoneNo: phoneNo},
    success: function (result) {
      if(result == "true") {
        phoneNoCheckBox.innerHTML = "이 번호는 사용할 수 있어요.";
        phoneNoCheckBox.style.color = "green";
        window.cphoneno = 1;
      } else if (result == "false") {
        phoneNoCheckBox.innerHTML = "이미 사용중인 번호에요.";
        phoneNoCheckBox.style.color = "red";
        window.cphoneno = 0;
      }
    },
  });
};
  $(".cellphoneNo").keyup(doPhoneNo);



// 이메일 인증 코드 발송
  var doSend = function () {
  var address = $("input.email").val();
  document.getElementById("emailCodeBox").innerHTML = "이메일을 확인 중입니다.";
  document.getElementById("emailCodeBox").style.color = "black";
  window.cemail = 0;

  $.ajax({
    type: "POST",
    url: "../mail/emailCode",
    data: { address: address},
    success: function (result) {
      if (result == "false") {
        document.getElementById("emailCodeBox").innerHTML = "이미 가입된 이메일입니다.";
        document.getElementById("emailCodeBox").style.color = "red";
      } else {
        document.getElementById("emailCodeBox").innerHTML = "이메일이 발송되었습니다.";
        document.getElementById("emailCodeBox").style.color = "green";
        code = result;
      }
    },
  });
};
  $(".c-btn-code").click(doSend);



// 이메일 인증 코드 확인
  var doCertificate = function () {
  var answer = $("input.code").val();
  if (answer === code) {
    document.getElementById("codeConfirmBox").innerHTML = "이메일 인증이 완료되었습니다.";
    document.getElementById("codeConfirmBox").style.color = "green";
    window.cemail = 1;
  } else {
    document.getElementById("codeConfirmBox").innerHTML = "이메일 인증에 실패하였습니다.";
    document.getElementById("codeConfirmBox").style.color = "red";
    window.cemail = 0;
  }
};
  $(".s-btn-code").click(doCertificate);
//  $.ajax({
//    type: "POST",
//    url: "../mail/codeConfirm",
//    data: { answer: answer},
//    success: function (request) {
//      if (request===code)
//      document.getElementById("codeConfirmBox").innerHTML = "이메일 인증이 완료되었습니다.";
//    },
//  });



// 최종 확인
  var doJoin = function () {
  var finalCheck;
  if (cid==1 && cnickname==1 && cphoneno==1 && cemail==1) {
    finalCheck = 1;
  } else {
    finalCheck = 0;
  }

  $.ajax({
    type: "POST",
    url: "lastCheck",
    data: { finalCheck: finalCheck},
    success: function (result) {
      if(result == "true") {
        document.getElementById("joinForm").submit();
      } else if (result == "false") {
        alert("올바른 정보를 입력해주세요.");
        window.location.reload();
      }
    },
  });
};
  $(".joinForm").submit(doJoin);

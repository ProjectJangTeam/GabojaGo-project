let place_name_list = [];
let road_address_name_list = [];
let phone_list = [];
let x_list = [];
let y_list = [];

const doSearch1 = function () {
  place_name_list.splice(0);
  road_address_name_list.splice(0);
  phone_list.splice(0);
  x_list.splice(0);
  y_list.splice(0);

  const keyword = $(".ga-input-box1").val();

  if (keyword.length > 0) {
    $.ajax({
      url:
        "https://dapi.kakao.com/v2/local/search/keyword.json?size=5&query=" +
        encodeURIComponent(keyword),
      type: "GET",
      headers: {
        Authorization: "KakaoAK 0164bda1178748f8b8e6ff5f441710a0",
      },
      success: function (data) {
        for (let i = 0; i < data.documents.length; i++) {
          place_name_list.push(data.documents[i].place_name);
          road_address_name_list.push(data.documents[i].road_address_name);
          phone_list.push(data.documents[i].phone);
          x_list.push(data.documents[i].x);
          y_list.push(data.documents[i].y);
        }
        $("#searchOptions").html("");
        for (let i = 0; i < place_name_list.length; i++) {
          if (road_address_name_list[i].length >= 4) {
            $("#searchOptions").append(
              $("<option>").html(
                place_name_list[i] + ", " + road_address_name_list[i]
              )
            );
          } else if (road_address_name_list[i].length < 4) {
            $("#searchOptions").append($("<option>").html(place_name_list[i]));
          }
        }
      },
      error: function (e) {
        console.log(e);
      },
    });
  }
};
const doSearch2 = function () {
  place_name_list.splice(0);
  road_address_name_list.splice(0);
  phone_list.splice(0);
  x_list.splice(0);
  y_list.splice(0);

  const keyword = $(".ga-input-box2").val();

  if (keyword.length > 0) {
    $.ajax({
      url:
        "https://dapi.kakao.com/v2/local/search/keyword.json?size=5&query=" +
        encodeURIComponent(keyword),
      type: "GET",
      headers: {
        Authorization: "KakaoAK 0164bda1178748f8b8e6ff5f441710a0",
      },
      success: function (data) {
        for (let i = 0; i < data.documents.length; i++) {
          place_name_list.push(data.documents[i].place_name);
          road_address_name_list.push(data.documents[i].road_address_name);
          phone_list.push(data.documents[i].phone);
          x_list.push(data.documents[i].x);
          y_list.push(data.documents[i].y);
        }
        $("#searchOptions").html("");
        for (let i = 0; i < place_name_list.length; i++) {
          if (road_address_name_list[i].length >= 4) {
            $("#searchOptions").append(
              $("<option>").html(
                place_name_list[i] + ", " + road_address_name_list[i]
              )
            );
          } else if (road_address_name_list[i].length < 4) {
            $("#searchOptions").append($("<option>").html(place_name_list[i]));
          }
        }
      },
      error: function (e) {
        console.log(e);
      },
    });
  }
};
const doSearch3 = function () {
  place_name_list.splice(0);
  road_address_name_list.splice(0);
  phone_list.splice(0);
  x_list.splice(0);
  y_list.splice(0);

  const keyword = $(".ga-input-box3").val();

  if (keyword.length > 0) {
    $.ajax({
      url:
        "https://dapi.kakao.com/v2/local/search/keyword.json?size=5&query=" +
        encodeURIComponent(keyword),
      type: "GET",
      headers: {
        Authorization: "KakaoAK 0164bda1178748f8b8e6ff5f441710a0",
      },
      success: function (data) {
        for (let i = 0; i < data.documents.length; i++) {
          place_name_list.push(data.documents[i].place_name);
          road_address_name_list.push(data.documents[i].road_address_name);
          phone_list.push(data.documents[i].phone);
          x_list.push(data.documents[i].x);
          y_list.push(data.documents[i].y);
        }
        $("#searchOptions").html("");
        for (let i = 0; i < place_name_list.length; i++) {
          if (road_address_name_list[i].length >= 4) {
            $("#searchOptions").append(
              $("<option>").html(
                place_name_list[i] + ", " + road_address_name_list[i]
              )
            );
          } else if (road_address_name_list[i].length < 4) {
            $("#searchOptions").append($("<option>").html(place_name_list[i]));
          }
        }
      },
      error: function (e) {
        console.log(e);
      },
    });
  }
};
const doSearch4 = function () {
  place_name_list.splice(0);
  road_address_name_list.splice(0);
  phone_list.splice(0);
  x_list.splice(0);
  y_list.splice(0);

  const keyword = $(".ga-input-box4").val();

  if (keyword.length > 0) {
    $.ajax({
      url:
        "https://dapi.kakao.com/v2/local/search/keyword.json?size=5&query=" +
        encodeURIComponent(keyword),
      type: "GET",
      headers: {
        Authorization: "KakaoAK 0164bda1178748f8b8e6ff5f441710a0",
      },
      success: function (data) {
        for (let i = 0; i < data.documents.length; i++) {
          place_name_list.push(data.documents[i].place_name);
          road_address_name_list.push(data.documents[i].road_address_name);
          phone_list.push(data.documents[i].phone);
          x_list.push(data.documents[i].x);
          y_list.push(data.documents[i].y);
        }
        $("#searchOptions").html("");
        for (let i = 0; i < place_name_list.length; i++) {
          if (road_address_name_list[i].length >= 4) {
            $("#searchOptions").append(
              $("<option>").html(
                place_name_list[i] + ", " + road_address_name_list[i]
              )
            );
          } else if (road_address_name_list[i].length < 4) {
            $("#searchOptions").append($("<option>").html(place_name_list[i]));
          }
        }
      },
      error: function (e) {
        console.log(e);
      },
    });
  }
};
const doSearch5 = function () {
  place_name_list.splice(0);
  road_address_name_list.splice(0);
  phone_list.splice(0);
  x_list.splice(0);
  y_list.splice(0);

  const keyword = $(".ga-input-box5").val();

  if (keyword.length > 0) {
    $.ajax({
      url:
        "https://dapi.kakao.com/v2/local/search/keyword.json?size=5&query=" +
        encodeURIComponent(keyword),
      type: "GET",
      headers: {
        Authorization: "KakaoAK 0164bda1178748f8b8e6ff5f441710a0",
      },
      success: function (data) {
        for (let i = 0; i < data.documents.length; i++) {
          place_name_list.push(data.documents[i].place_name);
          road_address_name_list.push(data.documents[i].road_address_name);
          phone_list.push(data.documents[i].phone);
          x_list.push(data.documents[i].x);
          y_list.push(data.documents[i].y);
        }
        $("#searchOptions").html("");
        for (let i = 0; i < place_name_list.length; i++) {
          if (road_address_name_list[i].length >= 4) {
            $("#searchOptions").append(
              $("<option>").html(
                place_name_list[i] + ", " + road_address_name_list[i]
              )
            );
          } else if (road_address_name_list[i].length < 4) {
            $("#searchOptions").append($("<option>").html(place_name_list[i]));
          }
        }
      },
      error: function (e) {
        console.log(e);
      },
    });
  }
};

// fin_after_select 배열을 form submit 할 때 같이 보내기
let fin_before_select = "";
const fin_after_select = [];

const doAdd1 = function () {
  $(".ga-input-box1").attr("readonly", true);
  fin_after_select.push(fin_before_select);
  console.log(fin_after_select);
};
const doAdd2 = function () {
  $(".ga-input-box2").attr("readonly", true);
  fin_after_select.push(fin_before_select);
  console.log(fin_after_select);
};
const doAdd3 = function () {
  $(".ga-input-box3").attr("readonly", true);
  fin_after_select.push(fin_before_select);
  console.log(fin_after_select);
};
const doAdd4 = function () {
  $(".ga-input-box4").attr("readonly", true);
  fin_after_select.push(fin_before_select);
  console.log(fin_after_select);
};
const doAdd5 = function () {
  $(".ga-input-box5").attr("readonly", true);
  fin_after_select.push(fin_before_select);
  console.log(fin_after_select);
};

$(document).on("change", "input", function () {
  let options = $("datalist")[0].options;
  let val = $(this).val();
  fin_before_select = "";
  for (var i = 0; i < options.length; i++) {
    if (options[i].value === val) {
      fin_before_select =
        place_name_list[i] +
        "," +
        road_address_name_list[i] +
        "," +
        phone_list[i] +
        "," +
        x_list[i] +
        "," +
        y_list[i] +
        "//";
      break;
    }
  }
});

$("#place-add-btn1").click(doAdd1);
$("#place-add-btn2").click(doAdd2);
$("#place-add-btn3").click(doAdd3);
$("#place-add-btn4").click(doAdd4);
$("#place-add-btn5").click(doAdd5);
$(".ga-input-box1").keyup(doSearch1);
$(".ga-input-box2").keyup(doSearch2);
$(".ga-input-box3").keyup(doSearch3);
$(".ga-input-box4").keyup(doSearch4);
$(".ga-input-box5").keyup(doSearch5);



//// ------------------------------------
//// li 태그
//var copiedform4 = document.querySelector(".copied-form4");
//var copiedform3 = document.querySelector(".copied-form3");
//var copiedform5 = document.querySelector(".copied-form5");
//// review-add-btn 태그
//var rvadbtn2 = document.querySelector(".review-add-btn2");
//var rvadbtn3 = document.querySelector(".review-add-btn3");
//var rvadbtn4 = document.querySelector(".review-add-btn4");
//// review-remove-btn 태그
//var rvrmbtn5 = document.querySelector(".review-remove-btn5");
//var rvrmbtn4 = document.querySelector(".review-remove-btn4");
//var rvrmbtn3 = document.querySelector(".review-remove-btn3");
//
//function addReview2() {
//  copiedform3.style.display = "block";
//  rvadbtn2.style.display = "none";
//}
//function addReview3() {
//  copiedform4.style.display = "block";
//  rvadbtn3.style.display = "none";
//  rvrmbtn3.style.display = "none";
//}
//function addReview4() {
//  copiedform5.style.display = "block";
//  rvadbtn4.style.display = "none";
//  rvrmbtn4.style.display = "none";
//}
//function removeReview5() {
//  copiedform5.style.display = "none";
//  document.querySelector(".cont5").value = null;
//  rvadbtn4.style.display = "inline-block";
//  rvrmbtn4.style.display = "inline-block";
//}
//function removeReview4() {
//  copiedform4.style.display = "none";
//  document.querySelector(".cont4").value = null;
//  rvadbtn3.style.display = "inline-block";
//  rvrmbtn3.style.display = "inline-block";
//}
//function removeReview3() {
//  copiedform3.style.display = "none";
//  document.querySelector(".cont3").value = null;
//  rvadbtn2.style.display = "inline-block";
//  rvrmbtn2.style.display = "inline-block";
//}
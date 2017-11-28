$(document)
        .ready(
                function () {

                    var no = 0;
                    var gpurchaseNo = $("#gpurchaseNo").val()
                    var memberNo = $("#memberNo").val()
                    var goodsNo = $("#goodsNo").val();
                    var status = 1;

                    /** 구매 / 공구재요청 버튼 */
                    var string = "";
                    var status = $("#status").val()
                    var askCnt = $("#askCnt").val()

                    if (status == 1) {
                        string += "<a class='button style-15 purchaseBtn'><i class='fa fa-heart'></i>구매하기"
                        string += "<input type='submit' value=''>"

                        $(".btnDiv").html(string)
                    } else {
                        status = 2;
                        askBtn(askCnt)
                    }

                    function askBtn(askCheck) {
                        var str = "";

                        if (askCheck == 0) {
                            str += "<a class='button style-10 askresale'>재공구요청</a>"
                        } else {
                            str += "<a class='button style-10 askcancle'>요청취소</a>"
                        }

                        $(".buttonDiv").html(str)
                    }

                    /** 재공구 요청 버튼 클릭시 이벤트 */
                    $(document).on("click", ".askresale", function (event) {
                        askCheck(0, gpurchaseNo)
                        event.stopImmediatePropagation()
                    })
                    $(document).on("click", ".askcancle", function (event) {
                        askCheck(1, gpurchaseNo)
                        event.stopImmediatePropagation()
                    })

                    function askCheck(askCk, gpNo) {
                        $.ajax({
                            url : "/product/askck/" + askCk + "/" + gpNo,
                            type : "POST",
                            data : {
                                "memberNo" : memberNo
                            },
                            success : function (askCheck) {
                                askBtn(askCheck)
                            },
                            error : function (data) {
                                console.log(data)
                            }
                        })

                    }

                    /** 주문항목 추가 */
                    $(".size")
                            .on(
                                    "click",
                                    function () {
                                        var pSize = $(this).html() // size 이름
                                                                    // (ex
                                                                    // XS/S/M...)
                                        var pNum = $(this).attr("id") // 상의/하의
                                                                        // PK

                                        $(this).addClass("active")

                                        var str = "";
                                        no += 1

                                        /** 이미 선택한 사이즈인지 체크 / 선택한 사이즈면 return */
                                        if ($("#" + pNum + "qt").length == 1) {
                                            return;

                                        } else {

                                            str += "<div class='article-container style-1' id='"
                                                    + no + "'>"
                                            str += "	<div class='col-sm-4 checkDiv1 inline-product-column-title'> - "
                                                    + pSize + " </div>"
                                            str += "	<div class='col-sm-6 checkDiv2'>"
                                            str += "		<div class='quantity-selector detail-info-entry qtnChoice'>"
                                            str += "			<div class='entry number-minus minus'>&nbsp;</div>"
                                            str += "			<div class='entry number quantity' name='quantity' id='"
                                                    + pNum + "qt'>1</div>"
                                            str += "			<div class='entry number-plus plus'>&nbsp;</div>"
                                            str += "		</div>"
                                            str += "	</div>"
                                            str += "	<div class='col-sm-1 xMark'>"
                                            str += "		<i class='fa fa-times '></i>"
                                            str += "	</div>"
                                            str += "</div>"

                                            $(".orderItem").append(str)

                                            var hiddenStr = "";
                                            var qtP = $("#" + pNum + "qt")
                                                    .html()

                                            if ($(".size").attr("name") == 'TOP') {
                                                hiddenStr += "<input type='hidden' name='topsNo' value='"
                                                        + pNum + "'>"
                                            } else {
                                                hiddenStr += "<input type='hidden' name='bottomNo' value='"
                                                        + pNum + "'>"
                                            }

                                            hiddenStr += "<input type='hidden' class='"
                                                    + pNum
                                                    + "qt' name='qty' value='"
                                                    + qtP + "'>"
                                            hiddenStr += "<input type='hidden' name='sizes' value='"
                                                    + pSize + "'>"

                                            $("#" + no + "").append(hiddenStr)

                                        }

                                    })

                    /** 상품 갯수 +/- */
                    $(document).on("click", ".plus", function () {
                        var qtIdP = $(this).prev().attr("id") // 상의/하의 pk +qt
                        var qtP = $("#" + qtIdP).html()
                        qtP = Number(qtP)

                        qtP += 1

                        $("#" + qtIdP).html(qtP) // +된 데이터 붙여주기
                        $("." + qtIdP + "").val(qtP) // name='qty'의 value
                                                        // 넣어주기
                    })

                    $(document).on("click", ".minus", function () {
                        var qtIdM = $(this).next().attr("id")
                        var qtM = $("#" + qtIdM).html()
                        qtM = Number(qtM)

                        if (qtM > 1) {
                            qtM -= 1

                            $("#" + qtIdM).html(qtM)
                            $("." + qtIdM + "").val(qtM)
                        }
                    })

                    /** 선택한 상품 삭제 */
                    $(document).on("click", ".xMark", function () {
                        $(this).parent().remove();
                    })

                    /** 주문페이지로 데이터 전송 */
                    $("#orderForm")
                            .submit(
                                    function (e) {
                                        e.preventDefault();

                                        var qty = $("input[name='qty']")
                                        var sizes = $("input[name='sizes']")

                                        if ($(".size").attr("name") == 'TOP') {
                                            var topsNo = $("input[name='topsNo']")
                                            var type = 'top'
                                        } else {
                                            var bottomNo = $("input[name='bottomNo']")
                                        }

                                        var OrderList;
                                        var OlList = new Array();

                                        for (var i = 0; i < qty.length; i++) {

                                            if (type == 'top') {
                                                OrderList = {
                                                    'topsNo' : topsNo[i].value,
                                                    'gpurchaseNo' : gpurchaseNo,
                                                    'qty' : qty[i].value,
                                                    'sizes' : sizes[i].value
                                                }
                                            } else {
                                                OrderList = {
                                                    'bottomNo' : bottomNo[i].value,
                                                    'gpurchaseNo' : gpurchaseNo,
                                                    'qty' : qty[i].value,
                                                    'sizes' : sizes[i].value
                                                }
                                            }

                                            OlList.push(OrderList)
                                        }

                                        var OLJson = JSON.stringify(OlList)

                                        var submitStr = "<input type='hidden' name='orderList' value='"
                                                + OLJson + "'>"

                                        $(this).append(submitStr)

                                        $(this).get(0).submit();

                                    })

                    $(".compare").append();
                    matchBest();

                    $(".size").click(function () {
                        changeSizeGap($(this).text());
                    });

                }); //end ready

//회원의 사이즈와 가장 적합한 사이즈를 반환
function matchBest() {
    $.ajax({
        url : "/size/get/" + $("#memberNo").val() + "/" + $("#goodsNo").val(),
        type : "get",
        dataType : "json",
        success : function (data) {
            print(data);
            $("#sizeAnnounce").html("가장 적합한 사이즈 : " + data.sizes);
        },
        error : function (xhr, statusText) {
            console.log("(" + xhr.status + ", " + statusText + ")");
        }
    });
}

//사이즈 비교 결과 띄어줌
function print(data) {

    $(".compare").html(data.sizes + "와 자신 사이즈와 비교결과<br>");

    if (data.types == 'pants' || data.types == 'shortPants'
            || data.types == 'skirt') {
        letter('허리', data.waist);

        if (data.types != 'skirt') {
            letter('밑위', data.rise);
            letter('허벅지', data.thigh);
        }

        letter('엉덩이', data.hip);
    } else { //상의
        var num = productSize.sleeveLength - userSize.sleeve;
        letter('소매길이', data.sleeveLength);
    }

    letter('총 길이', data.fullLength);
}

function letter(body, num) {
    $(".compare").append(body + " 사이즈 : " + num + "<br>");
}

//사용자가 클릭할 때마다 사이즈 차이 변환
function changeSizeGap(data) {
    $.ajax({
        url : "/size/get/" + $("#memberNo").val() + "/" + data + "/"
                + $("#goodsNo").val(),
        type : "get",
        dataType : "json",
        success : function (data) {
            print(data);
        },
        error : function (xhr, statusText) {
            console.log("(" + xhr.status + ", " + statusText + ")");
        }
    });
}

/** 상품 이미지 자동 슬라이드 */
jQuery(function ($) {
    var mySwiper = new Swiper('.swiper-container', {
        pagination : '.swiper-pagination',
        nextButton : '.swiper-button-next',
        prevButton : '.swiper-button-prev',
        paginationClickable : true,
        spaceBetween : 30,
        centeredSlides : true,
        autoplay : 3000,
        autoplayDisableOnInteraction : true,
        loop : true
    });

    /** 웹에서의 자동 슬라이드 */
    $(".swiper-container").on("focusout", function () {
        setTimeout(function () {
            if ($(this).find(":focus").length === 0) {
                mySwiper.startAutoplay();
            }
        }, 100);
    });

    /** 모바일에서의 자동 슬라이드 */
    $(document).on("touchmove", function () {
        mySwiper.startAutoplay();
    });

});

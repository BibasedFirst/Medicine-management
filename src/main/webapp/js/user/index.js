$(function () {
        //得到焦点
        $("#password").focus(function () {
            $("#left_hand").animate({
                left: "150",
                top: " -38"
            }, {
                step: function () {
                    if (parseInt($("#left_hand").css("left")) > 140) {
                        $("#left_hand").attr("class", "left_hand");
                    }
                }
            }, 2000);
            $("#right_hand").animate({
                right: "-64",
                top: "-38px"
            }, {
                step: function () {
                    if (parseInt($("#right_hand").css("right")) > -70) {
                        $("#right_hand").attr("class", "right_hand");
                    }
                }
            }, 2000);
        });
        //失去焦点
        $("#password").blur(function () {
            $("#left_hand").attr("class", "initial_left_hand");
            $("#left_hand").attr("style", "left:100px;top:-12px;");
            $("#right_hand").attr("class", "initial_right_hand");
            $("#right_hand").attr("style", "right:-112px;top:-12px");
        });
        $(".changeSubmit").click(function(){
            var thisHtml = $(this).html();
            $(this).html($('.submit').val());
            $('.submit').val(thisHtml);
            thisHtml = $('.indexForm').attr("action");
            $('.indexForm').attr("action",$('.formUrl').val());
            $('.formUrl').val(thisHtml);
        })
        
        //提交点击事件
        $(":submit").click(function(){
        	var returned = false;
        	$(".ipt").each(function () {
                    if ($(this).val() == "") {
                        alert($(this).attr("title")+"不能为空！");
                        $(this).focus();
                        returned = false;
                        return returned;
                    }else returned = true;
                })
        	return returned;
        });
        

        //忘记密码点击事件
        $(".forget").click(function(){
        	if($('.uName').val() != ""){
                $('.indexForm').attr("action",$('.forgetUrl').val());
                $('.indexForm').submit();
        	}else{
        		alert($('.uName').attr("title")+"不能为空！");
        		$('.uName').focus();
        	}
        })
    });
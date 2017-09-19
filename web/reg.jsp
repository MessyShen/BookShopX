<%--
  Created by IntelliJ IDEA.
  User: messy
  Date: 2017/9/17
  Time: 上午9:05
  .     .
     ^
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style type="text/css">
        .input-field div.error{
            position: relative;
            top: -1rem;
            left: 0rem;
            font-size: 0.8rem;
            color:#FF4081;
            -webkit-transform: translateY(0%);
            -ms-transform: translateY(0%);
            -o-transform: translateY(0%);
            transform: translateY(0%);
        }
        .input-field label.active{
            width:100%;
        }
        .left-alert input[type=text] + label:after,
        .left-alert input[type=password] + label:after,
        .left-alert input[type=email] + label:after,
        .left-alert input[type=url] + label:after,
        .left-alert input[type=time] + label:after,
        .left-alert input[type=date] + label:after,
        .left-alert input[type=datetime-local] + label:after,
        .left-alert input[type=tel] + label:after,
        .left-alert input[type=number] + label:after,
        .left-alert input[type=search] + label:after,
        .left-alert textarea.materialize-textarea + label:after{
            left:0px;
        }
        .right-alert input[type=text] + label:after,
        .right-alert input[type=password] + label:after,
        .right-alert input[type=email] + label:after,
        .right-alert input[type=url] + label:after,
        .right-alert input[type=time] + label:after,
        .right-alert input[type=date] + label:after,
        .right-alert input[type=datetime-local] + label:after,
        .right-alert input[type=tel] + label:after,
        .right-alert input[type=number] + label:after,
        .right-alert input[type=search] + label:after,
        .right-alert textarea.materialize-textarea + label:after{
            right:70px;
        }
    </style>
</head>



<body>
<div class="container">
    <div class="col s12 m12 l12">
        <div class="col s12 m4 l8">
            <div class="card-panel">

                <div class="container">
                    <h4 class="header2">注册</h4>
                    <div class="row">
                        <s:form class="formValidate" id="formValidate" method="get" action="doRegister" novalidate="novalidate">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="uname" class="active">用户名</label>
                                    <input id="uname" name="users.loginId" type="text" data-error=".errorTxt1" aria-required="true" aria-invalid="true" class="error" aria-describedby="uname-error">
                                    <div class="errorTxt1"><div id="uname-error" class="error">Enter at least 5 characters</div></div>
                                </div>
                                <div class="input-field col s12">
                                    <label for="uname2">姓名</label>
                                    <input id="uname2" name="users.name" type="text" data-error=".errorTxt5">
                                    <div class="errorTxt5"></div>
                                </div>
                                <div class="input-field col s12">
                                    <label for="cemail" class="">E-Mail</label>
                                    <input id="cemail" type="email" name="users.mail" data-error=".errorTxt2">
                                    <div class="errorTxt2"></div>
                                </div>
                                <div class="input-field col s12">
                                    <label for="password">密码</label>
                                    <input id="password" type="password" name="users.loginPwd" data-error=".errorTxt3">
                                    <div class="errorTxt3"></div>
                                </div>
                                <div class="input-field col s12">
                                    <label for="cpassword">确认密码</label>
                                    <input id="cpassword" type="password" name="cpassword" data-error=".errorTxt4">
                                    <div class="errorTxt4"></div>
                                </div>

                                <div class="input-field col s12">
                                    <label for="addr">地址</label>
                                    <input id="addr" name="users.address" type="text" data-error=".errorTxt6">
                                    <div class="errorTxt6"></div>
                                </div>

                                <div class="input-field col s12">
                                    <label for="phone">电话</label>
                                    <input id="phone" name="users.phone" type="text" data-error=".errorTxt7">
                                    <div class="errorTxt7"></div>
                                </div>

                                <%--<div class="input-field col s12">--%>
                                    <%--<label for="birthday">生日</label>--%>
                                    <%--<input id="birthday" name="users.birthday" type="date" class="datepicker" data-error=".errorTxt8">--%>
                                    <%--<div class="errorTxt8"></div>--%>
                                <%--</div>--%>

                                <div class="col s12">
                                    <label for="genter_select">性别</label>
                                    <p>
                                        <input name="cgender" type="radio" id="gender_male" data-error=".errorTxt9">
                                        <label for="gender_male">Male</label>
                                    </p>
                                    <p>
                                        <input name="cgender" type="radio" id="gender_female" value="f">
                                        <label for="gender_female">Female</label>
                                    </p>
                                    <div class="input-field">
                                        <div class="errorTxt9"></div>
                                    </div>
                                </div>

                                <div class="col s12">
                                    <label for="tnc_select">条款</label>
                                    <p>
                                        <input type="checkbox" class="checkbox" id="cagree" name="cagree" data-error=".errorTxt10">
                                        <label for="cagree">Please agree to our policy</label>
                                    </p>
                                    <div class="input-field">
                                        <div class="errorTxt10"></div>
                                    </div>
                                </div>
                                <div class="input-field col s12">
                                    <button class="btn waves-effect waves-light right submit" type="submit" name="action">Submit
                                        <i class="mdi-content-send right"></i>
                                    </button>
                                </div>
                            </div>
                        </s:form>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>
<script type="text/javascript" src="js/plugins/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-validation/additional-methods.min.js"></script>
<script type="text/javascript">
    $("#formValidate").validate({
        rules: {
            loginId: {
                required: true,
                minlength: 5
            },
            uname: {
                required: true,
                minlength: 5
            },
            cemail: {
                required: true,
                email:true
            },
            password: {
                required: true,
                minlength: 5
            },
            cpassword: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            },
            curl: {
                required: true,
                url:true
            },
            crole:"required",
            ccomment: {
                required: true,
                minlength: 15
            },
            cgender:"required",
            cagree:"required",
        },
        //For custom messages
        messages: {
            uname:{
                required: "Enter a username",
                minlength: "Enter at least 5 characters"
            },
            curl: "Enter your website",
        },
        errorElement : 'div',
        errorPlacement: function(error, element) {
            var placement = $(element).data('error');
            if (placement) {
                $(placement).append(error)
            } else {
                error.insertAfter(element);
            }
        }
    });
</script>
<script type="text/javascript">
    $(document).ready(function() {
        $('select').material_select();
    });
</script>

<script type="text/javascript">
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 40 // Creates a dropdown of 15 years to control year
    });
</script>

</body>
</html>

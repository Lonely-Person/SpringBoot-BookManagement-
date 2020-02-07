<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>戎狄图书管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="/plugins/fontawesome-free/css/all.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/adminlte.min.css">
    <!-- Google Font: Source Sans Pro -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="javascript:void(0)"><b>Admin</b>LTE</a>
    </div>

    <div class="card">
        <div class="card-body register-card-body">
            <p class="login-box-msg">Register a new membership</p>

            <form id="form">
                <span></span>
                <div class="input-group mb-3">
                    <input type="text" id="userName" name="userName" required="required" class="form-control" placeholder="用户名">

                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-user"></span>
                        </div>
                    </div>
                </div>
                <span></span>
                <div class="input-group mb-3">
                    <input type="email" id="userEmail" name="userEmail" class="form-control" placeholder="邮箱">
                    <span></span>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-envelope"></span>
                        </div>
                    </div>

                </div>
                <span></span>
                <div class="input-group mb-3">
                    <input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="密码">
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
                <span></span>
                <div class="input-group mb-3">
                    <input type="password" id="userPasswordAgain" name="userPasswordAgain" class="form-control" placeholder="再次输入密码">
                    <span></span>
                    <div class="input-group-append">
                        <div class="input-group-text">
                            <span class="fas fa-lock"></span>
                        </div>
                    </div>
                </div>
            </form>


                <div class="row">
                    <!-- /.col -->
                    <div class="col-4">
                        <button type="button" id="reg-btn" class="btn btn-primary btn-block">Register</button>
                    </div>
                    <!-- /.col -->
                </div>


            <a href="login.ftl" class="text-center">已注册，登录！</a>
        </div>
        <!-- /.form-box -->
    </div><!-- /.card -->
</div>
<!-- /.register-box -->

<!-- jQuery -->
<script src="/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/adminlte.min.js"></script>

<script>
    $(function(){
        $("#reg-btn").click(function () {
            $.ajax({
                url: "/doRegister",
                type: "POST",
                // contentType:"application/json;charset=utf-8",
                data: $("#form").serialize(),
                success: function (response) {
                    // var result = JSON.parse(response);
                    if(response.code === "100"){
                        $.each(response, function (k,v) {
                            $("#"+k).parent().prev("span").css("color","red").text(v);
                        });
                    }
                    else{
                        window.location.href = "/index";
                    }
                }
            })
        })
    });
    $('input').focus(function () {
        $(this).parent().prev('span').text('');
    });
</script>
</body>
</html>

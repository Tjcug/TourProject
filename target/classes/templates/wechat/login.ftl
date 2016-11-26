<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>注册</title>
<#include "common/head.ftl">

</head>

<body>
<div class="page">
    <header class="bar bar-nav">
        <h1 class="title">Login</h1>
    </header>
    <div class="content">
        <div class="page-login">
            <div class="list-block inset text-center">
                <h3>Login Light7 Mall</h3>
                <ul>
                    <!-- Text inputs -->
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-name"></i></div>
                            <div class="item-inner">
                                <div class="item-input">
                                    <input type="text" placeholder="Username/Email">
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="item-content">
                            <div class="item-media"><i class="icon icon-form-email"></i></div>
                            <div class="item-inner">
                                <div class="item-input">
                                    <input type="password" placeholder="Password">
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="content-block">
                <p><a class="button button-big button-fill external" href='home' data-transition='fade'>Login</a></p>
                <p class='text-center signup'>
                    <a href="#" class='pull-left'>No Accout?</a>
                    <a href="#" class='pull-right'>Forget Password?</a>
                </p>
            </div>
            <div class="leader">Other login</div>
            <div class="row others">
                <a class="col-33"> <img src="http://gtms04.alicdn.com/tps/i4/TB1n75bIFXXXXaMXXXXgYS7HVXX-96-144.png"
                                        alt="" width='60'></a>
                <a class="col-33"> <img src="http://gtms03.alicdn.com/tps/i3/TB1fN1XIFXXXXbEXXXX8oekJXXX-98-149.png"
                                        alt="" width='61'></a>
                <a class="col-33"> <img src="http://gtms02.alicdn.com/tps/i2/TB16fh8IFXXXXXdXpXXEs40ZFXX-105-147.png"
                                        alt="" width='64'></a>
            </div>
        </div>
    </div>
</div>
<style>
    .content {
        color: #999;
    }

    .button.button-fill.button-big {
        line-height: 2.0rem;
        height: 2.0rem;
    }

    .list-block {
        margin: .75rem;
    }

    .content-block {
        margin: .75rem 0;
    }

    .signup a {
        color: #999;
    }
</style>
</body>
<#include "common/js.ftl">
</html>

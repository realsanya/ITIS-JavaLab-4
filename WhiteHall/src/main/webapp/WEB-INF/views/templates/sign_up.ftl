<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Регистрация" css=["styles.css"]>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="offset-3 col-md-6 title">Регистрация</div>
            </div>

            <div class="container" style="padding-top: 40px; padding-bottom: 100px">
                <form action="/signUp" method="post" autocomplete="off">
                    <div class="offset-3 col-md-6">
                        <div class="row justify-content-center">
                            <input class="login-input" type="text" name="first_name" placeholder="Фамилия"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="text" name="last_name" placeholder="Имя"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="email" name="email" placeholder="Почта"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="password" name="password" placeholder="Пароль"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="password" name="password_again" placeholder="Повторите пароль"/>
                        </div>

                        <div class="row justify-content-center" style="padding-top: 40px">
                            <button type="submit" class="register-button">
                                Зарегистрироваться <img src="/static/assets/img/click.png" style="padding-left: 15px"/>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@base.main>
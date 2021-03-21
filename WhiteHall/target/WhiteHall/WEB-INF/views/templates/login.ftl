<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Авторизация" css=["styles.css"]>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="offset-3 col-md-6 title">Авторизация</div>
            </div>

            <div class="container" style="padding-top: 40px; padding-bottom: 100px">
                <form action="/login" method="post">
                    <div class="offset-3 col-md-6">
                        <div class="row justify-content-center">
                            <input class="login-input" type="email" name="email" placeholder="Почта"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="password" name="password" placeholder="Пароль"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 40px">
                            <div>Еще не зарегистрированы?</div>
                            <a href="/signUp"> Регистрация</a>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <button class="login-button">
                                Войти <img src="/static/assets/img/click.png" style="padding-left: 15px"/>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@base.main>
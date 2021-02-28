<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<#import "/spring.ftl" as spring>
<@base.main title="Регистрация" css=["styles.css"]>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="offset-3 col-md-6 title"><@spring.message 'sign_up_page.registration.title'/></div>
            </div>

            <div class="container" style="padding-top: 40px; padding-bottom: 100px">
                <form action="/signUp" method="post" autocomplete="off">
                    <div class="offset-3 col-md-6">
                        <div class="row justify-content-center">
<#--                            <label for="lastName">-->
<#--                                <label for="lastName"><@spring.message 'sign_up_page.registration.last_name.placeholder'/></label>-->
<#--                            </label>-->
<#--                            <@spring.formInput "signUpForm.lastName" "class='login-input'"/>-->
                            <input class="login-input" type="text" name="lastName" placeholder="<@spring.message 'sign_up_page.registration.last_name.placeholder'/>"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="text" name="firstName" placeholder="<@spring.message 'sign_up_page.registration.first_name.placeholder'/>"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="email" name="email" placeholder="<@spring.message 'sign_up_page.registration.email.placeholder'/>"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="password" name="password" placeholder="<@spring.message 'sign_up_page.registration.password.placeholder'/>"/>
                        </div>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <input class="login-input" type="password" name="password_again" placeholder="<@spring.message 'sign_up_page.registration.repeat_password.placeholder'/>"/>
                        </div>

                        <div class="row justify-content-center" style="padding-top: 40px">
                            <button type="submit" class="register-button">
                                <@spring.message 'sign_up_page.registration.button'/> <img src="/static/assets/img/click.png" style="padding-left: 15px"/>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@base.main>
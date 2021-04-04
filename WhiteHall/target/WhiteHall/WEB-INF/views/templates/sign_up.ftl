<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<#import "/spring.ftl" as spring>
<style>
    .error {
        color: red;
        padding-left: 90px;
        margin-top: 15px;
    }
</style>
<@base.main title="Регистрация" css=["styles.css"]>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="offset-3 col-md-6 title"><@spring.message 'sign_up_page.registration.title'/></div>
            </div>
            <@spring.bind "userForm"/>
            <#if namesErrorMessage??>
                <p class="error" style="display: flex; justify-content: center; padding-right: 55px;">${namesErrorMessage}</p>
            </#if>
            <#if passwordsErrorMessage??>
                <p class="error" style="display: flex; justify-content: center; padding-right: 55px;">${passwordsErrorMessage}</p>
            </#if>
            <div class="container" style="padding-top: 40px; padding-bottom: 100px">
                <form action="/signUp" method="post" autocomplete="off">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="offset-3 col-md-6">
                        <div class="row justify-content-center">
                            <#assign firstNamePlaceholder><@spring.message 'sign_up_page.registration.first_name.placeholder'/></#assign>
                            <@spring.formInput "userForm.firstName" "class='login-input' placeholder='" + firstNamePlaceholder + "'" />
<#--                            <input class="login-input" type="text" name="firstName"-->
<#--                                   placeholder="<@spring.message 'sign_up_page.registration.first_name.placeholder'/>"/>-->
                        </div>
                        <@spring.showErrors "<br>" "error"/>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <#assign lastNamePlaceholder><@spring.message 'sign_up_page.registration.last_name.placeholder'/></#assign>
                            <@spring.formInput "userForm.lastName" "class='login-input' placeholder='" + lastNamePlaceholder + "'" />
<#--                            <input class="login-input" type="text" name="lastName"-->
<#--                                   placeholder="<@spring.message 'sign_up_page.registration.last_name.placeholder'/>"/>-->
                        </div>
                        <@spring.showErrors "<br>" "error"/>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <#assign emailPlaceholder><@spring.message 'sign_up_page.registration.email.placeholder'/></#assign>
                            <@spring.formInput "userForm.email" "class='login-input' placeholder='" + emailPlaceholder + "'" />
                            <#--                            <input class="login-input" type="email" name="email" placeholder="<@spring.message 'sign_up_page.registration.email.placeholder'/>"/>-->
                        </div>
                        <@spring.showErrors "<br>" "error"/>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <#assign passwordPlaceholder><@spring.message 'sign_up_page.registration.password.placeholder'/></#assign>
                            <@spring.formPasswordInput "userForm.password" "class='login-input' placeholder='" + passwordPlaceholder + "'" />
<#--                            <input class="login-input" type="password" name="password"-->
<#--                                   placeholder="<@spring.message 'sign_up_page.registration.password.placeholder'/>"/>-->
                        </div>
                        <@spring.showErrors "<br>" "error"/>
                        <div class="row justify-content-center" style="padding-top: 20px">
                            <#assign passwordAgainPlaceholder><@spring.message 'sign_up_page.registration.repeat_password.placeholder'/></#assign>
                            <@spring.formPasswordInput "userForm.passwordAgain" "class='login-input' placeholder='" + passwordAgainPlaceholder + "'" />
<#--                            <input class="login-input" type="password" name="password_again"-->
<#--                                   placeholder="<@spring.message 'sign_up_page.registration.repeat_password.placeholder'/>"/>-->
                        </div>
                        <@spring.showErrors "<br>" "error"/>


                        <div class="row justify-content-center" style="padding-top: 40px">
                            <button type="submit" class="register-button">
                                <@spring.message 'sign_up_page.registration.button'/> <img
                                        src="/static/assets/img/click.png" style="padding-left: 15px"/>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@base.main>
<#import "/spring.ftl" as spring>
<header class="header">
    <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document" style="border-radius: 20px;">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="modal-title" style="color: #484D50;" id="exampleModalLabel">Спасибо за интерес к нашим
                        услугам! <br/> Оставьте свой номер телефона
                        для связи!
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times</span>
                    </button>
                </div>
                <div class="modal-body" style="border: 1px none;">
                    <div class="form-group">
                        <input type="text" class="form-control" name="comment-input" id="comment-input"
                               required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="push_btn" class="btn btn-primary btn-lg px-3">
                        Сохранить
                    </button>
                </div>
            </div>
        </div>
    </div>

    <nav>
        <div class="container">
            <div class="row">
                <div class="col-md-1" style="padding-top: 40px">
                    <img src="/static/assets/img/Logo.png">
                </div>
                <div class="col-md-3" style="padding-right: 40px; padding-top: 40px">
                    <div class="row" style="padding-top: 10px">
                        <span class="header-title"><@spring.message 'header.title'/></span>
                    </div>
                    <div class="row" style="padding-top: 10px">
                        <span class="header-subtitle"><@spring.message 'header.subtitle'/></span>
                    </div>
                </div>
                <div class="offset-1 col-md-3" style="padding-top: 70px">
                    <a href="https://vk.com/id174637822" target="_blank" class="header-icon-link"><img
                                src="/static/assets/img/VkIcon.png"></a>
                    <a href="https://www.instagram.com/morozova.al/" target="_blank" class="header-icon-link"><img
                                src="/static/assets/img/InstagramIcon.png"></a>
                    <a href="" target="_blank"><img src="/static/assets/img/TelegramIcon.png" class="header-icon-link"></a>
                    <a href="" target="_blank"><img src="/static/assets/img/WhatsIcon.png" class="header-icon-link"></a>
                    <a href="" target="_blank"><img src="/static/assets/img/ViberIcon.png" class="header-icon-link"></a>
                </div>
                <div class="col-md-1"
                     style="padding-top: 70px; display: flex; flex-direction: row; align-items: flex-start; justify-content: space-between;">
                    <div>
                        <span>
                            <a href="?lang=ru">RU</a>
                        </span>
                    </div>
                    <div>
                        <span>
                            <a href="?lang=en">EN</a>
                        </span>
                    </div>
                </div>
                <div class="col-md-3" style="padding-top: 25px">
                    <div class="row">
                        <a href="tel:+79046712346" class="ml-auto phone"> +7 (904) 671-23-46</a>
                    </div>
                    <div class="row" style="padding-top: 15px">
                        <button id="write_comment" data-toggle="modal" data-target="#exampleModal"
                                class="ml-auto order-call-button"><img src="/static/assets/img/phoneIcon.png"/><span
                                    style="padding-left: 10px"><@spring.message 'header.call'/></span></button>
                    </div>
                </div>
            </div>
            <div class="row" style="padding-top: 30px; padding-bottom: 40px;">
                <div class="col-md-12" style="display: flex; justify-content: space-between;">
<#--                    <#if user??>-->
                        <a class="nav-item" href="/main"><@spring.message 'header.main'/></a>
                        <a class="nav-item" href="/advantages"><@spring.message 'header.advantages'/></a>
                        <a class="nav-item" href="/services"><@spring.message 'header.services'/></a>
                        <a class="nav-item" href="/gift"><@spring.message 'header.gift'/></a>
                        <a class="nav-item" href="/stages"><@spring.message 'header.stages'/></a>
                        <a class="nav-item" href="/reviews"><@spring.message 'header.reviews'/></a>
                        <a class="nav-item" href="/members"><@spring.message 'header.members'/></a>
                        <a class="nav-item" href="/profile"><@spring.message 'header.profile'/></a>
<#--                    <#else>-->
<#--                        <a class="nav-item" href="/main"><@spring.message 'header.main'/></a>-->
<#--                        <a class="nav-item" href="/advantages"><@spring.message 'header.advantages'/></a>-->
<#--                        <a class="nav-item" href="/services"><@spring.message 'header.services'/></a>-->
<#--                        <a class="nav-item" href="/gift"><@spring.message 'header.gift'/></a>-->
<#--                        <a class="nav-item" href="/stages"><@spring.message 'header.stages'/></a>-->
<#--                        <a class="nav-item" href="/reviews"><@spring.message 'header.reviews'/></a>-->
<#--                        <a class="nav-item" href="/members"><@spring.message 'header.members'/></a>-->
<#--                        <a class="nav-item" href="/signIn"><@spring.message 'header.login'/></a>-->
<#--                    </#if>-->
                </div>
            </div>
        </div>
    </nav>
</header>
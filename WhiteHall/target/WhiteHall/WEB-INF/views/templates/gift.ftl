<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Получить подарок" css=["styles.css"]>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <div class="row" style="padding-top: 60px">
                        <div class="title">Проходи опрос и забирай подарок</div>
                    </div>
                    <div class="row" style="padding-top: 70px">
                        <div class="gift-text">Пройди опрос и мы подарим тебе <br/> <span class="gift-text-second">+5 обработанных фотографий</span>
                        </div>
                    </div>
                    <div class="row" style="padding-top: 50px">
                        <button class="gift-button" data-toggle="modal" data-target="#giftModal">
                            Получить подарок <img src="/static/assets/img/click.png" style="padding-left: 5px"/>
                        </button>
                    </div>
                </div>
                <div class="col-md-5">
                    <img src="/static/assets/img/Phone.png" style="width: 560px">
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade bd-example-modal-lg" id="giftModal" tabindex="-1" role="dialog"
         aria-labelledby="giftModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document" style="border-radius: 20px;">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="modal-title" style="color: #484D50;" id="giftModalLabel"> Опрос
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times</span>
                    </button>
                </div>
                <div class="modal-body" style="border: 1px none;">

                    <div class="form-group">
                        <label>Любите ли вы фотографироваться ?</label>
                        <br/>
                        <label>
                            <input type="checkbox"/>
                            Очень люблю
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Не очень, стараюсь лишний раз не попадать в кадр
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Не люблю
                        </label>
                        <br/>

                        <label>Что вы ждете от профессиональной фотосессии БОЛЬШЕ всего?</label>
                        <label>
                            <input type="checkbox"/>
                            Качественные фотографии
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Удовольствие от процесса съёмки
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Низкие цены
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Хочу понравиться себе
                        </label>
                        <br/>

                        <label>Какие цвета в фотографиях Вам импонируют больше всего?</label>
                        <label>
                            <input type="checkbox"/>
                            Черно-белые
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Яркие, контрастные
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Светлые, пастельные
                        </label>
                        <br/>
                        <label>
                            <input type="checkbox">
                            Коричневая гамма, приглушенный свет
                        </label>
                        <br/>
                        <label>Оставьте свой e-mail</label>
                        <input type="email"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="push_btn" class="btn btn-primary btn-lg px-3">
                        Отправить
                    </button>
                </div>
            </div>
        </div>
    </div>
</@base.main>
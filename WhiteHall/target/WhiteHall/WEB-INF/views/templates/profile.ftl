<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Отзывы" css=["styles.css"]>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="offset-3 col-md-6 title">Профиль</div>
            </div>
            <form class="/update" method="post" enctype="multipart/form-data" id="upload-form">
                <div class="container" style="padding-top: 40px; padding-bottom: 40px">
                    <div class="row justify-content-center">
                        <img class="rounded-circle w-25 h-25"
                             src="/static/assets/img/${image.getPath()}.${image.getType()}"/>
                    </div>

                    <div class="row justify-content-center" style="padding-top: 20px">
                        <div>
                            <h2 class="profile-card-title">${user.getFirst_name()} ${user.getLast_name()}</h2>
                        </div>
                        <div style="alignment: center; horiz-align: center; padding-top: 60px; padding-right: 300px;"
                             class="text-center position-absolute right text-changer">
                            <input type='file' name="file" class="invisible" id="imageUpload"
                                   accept=".png, .jpg, .jpeg"/>
                            <label for="imageUpload">
                                <p class="btn btn-primary" style="background-color: #6F99E8; cursor: pointer; border: 1px none">Изменить фотографию</p>
                            </label>
                        </div>
                    </div>
                    <div class="row justify-content-center" style="padding-top: 65px">
                        <button class="register-button">
                            Выйти <img src="/static/assets/img/click.png" style="padding-left: 15px"/>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</@base.main>
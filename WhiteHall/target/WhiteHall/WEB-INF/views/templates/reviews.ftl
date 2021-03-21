<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Отзывы" css=["styles.css"]>
    <div class="content">
        <div class="container">
            <div class="row">
                <div class="offset-3 col-md-6 title">Нам доверяют</div>
            </div>

            <div class="row justify-content-center" style="padding-top: 40px; padding-bottom: 40px">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="reviews-card">
                                <!-- Card image -->
                                <div class="row justify-content-center">
                                    <img class="rounded-circle w-25 h-25" src="/static/assets/img/review1.png"
                                         alt="Card image cap">
                                </div>

                                <!-- Card content -->
                                <div class="card-body reviews-card-body">
                                    <!-- Title -->
                                    <h4 class="reviews-card-title">Маргарита Розенкевич</h4>
                                    <!-- Text -->
                                    <p class="reviews-card-text">22 июля 2015г.</p>
                                    <p class="reviews-card-text">Понравилась атмосфера работы. Мы практически не
                                        позировали,
                                        за 2
                                        часа
                                        сделали всего несколько постановочных кадров, просто общались, а Надя всё
                                        снимала и
                                        снимала...
                                        в результате мы получились настоящие, такие, как в жизни, словом всё вышло
                                        достойным
                                        остаться на долгую память)) Спасибо))) </p>
                                </div>
                            </div>
                        </div>
                        <#list reviews as review>
                            <div class="carousel-item">
                                <div class="reviews-card">
                                    <!-- Card image -->
                                    <div class="row justify-content-center">
                                        <img class="rounded-circle w-25 h-25" src="/static/assets/img/review1.png"
                                             alt="Card image cap">
                                    </div>

                                    <!-- Card content -->
                                    <div class="card-body reviews-card-body">
                                        <!-- Title -->
                                        <h4 class="reviews-card-title">${review.getUser_id().getFirst_name()} ${review.getUser_id().getLast_name()}</h4>
                                        <!-- Text -->
                                        <p class="reviews-card-text">${review.getDate()}</p>
                                        <p class="reviews-card-text">${review.getText()}</p>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"
                    >
                        <img src="/static/assets/img/prevIcon.png" aria-hidden="true"/>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"
                    >
                        <img src="/static/assets/img/nextIcon.png" aria-hidden="true"/>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</@base.main>
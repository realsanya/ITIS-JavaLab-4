<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main title="Наша команда" css=["styles.css"] scripts=["searchAjax.js"]>
    <div class="content">
        <div class="row">
            <div class="offset-3 col-md-6 title">Наша команда</div>
        </div>
        <section class="shop mt-5">
            <div class="container card px-5 pt-5 pb-5 pb-lg-5">
                <div class="row ">
                    <div class="col-lg-3">
                        <div class="shop__sidebar">
                            <div class="shop__sidebar__search">
                                <form action="/search" method="get" id="searh-form" class="search-form">
                                    <div class="autocomplete">
                                        <input
                                                id="inputSearch" type="text"
                                                class="login-input"
                                                style="background-color: #DFDFDF"
                                                name="search-input"
                                                placeholder="Search...">
                                    </div>
                                    <button type="submit" class="login-button"
                                            style="width: 120px; height: 40px; font-size:14px; margin-top: 10px;">
                                        Поиск
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9 ">
                        <div class="shop__product__option">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__left">
                                        <p></p>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="shop__product__option__right">
                                        <form action="/searchByRole" method="post">
                                            <select name="select-form" class="login-input">
                                                <option value="priceIncrease">фотограф</option>
                                                <option value="priceDecrease">видеограф</option>
                                                <option value="weightIncrease">визажист</option>
                                                <option value="weightDecrease">стилист</option>
                                                <option value="weightDecrease">парикмахер</option>
                                            </select>
                                            <button type="submit" class="login-button"
                                                    style="width: 100px; height: 40px; font-size:14px; margin-top: 10px">
                                                Выбрать
                                            </button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" id="results" style="padding-top: 10px">
                    </div>
                </div>
            </div>
        </section>
    </div>
</@base.main>
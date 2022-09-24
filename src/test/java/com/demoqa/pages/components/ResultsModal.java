package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

/**
 * @author Vlad Litvinov компонена модального окна с результатами
 */
public class ResultsModal {

    /**
     * текст заголовка в таблице результатов
     */
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    /**
     * проверка, что модалка видна
     * @return ResultsModal
     */
    public ResultsModal checkVisible() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));

        return this;
    }

    /**
     * проверка значений в модалке
     * @param key наименование значения
     * @param value само значение
     * @return ResultsModal
     */
    public ResultsModal checkResult(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}

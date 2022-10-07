package com.lvo23.pages.components;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Vlad Litvinov компонента элемента Календарь
 */
public class CalendarComponent {

    /**
     * установить дату в компоненте Календарь
     * @param day заданный день
     * @param month заданный месяц
     * @param year заданный год
     * @return CalendarComponent
     */
    public CalendarComponent setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        return this;
    }
}

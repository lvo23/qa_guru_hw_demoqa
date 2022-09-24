package com.demoqa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

/**
 * @author Vlad Litvinov класс для страницы с формой регистрации
 */
public class RegistrationFormPage {

    /**
     * Константа урла с формой регистрации
     */
    private static final String REG_FORM_URL = "/automation-practice-form";

    /**
     * Константа с текстом заголовка на странице
     */
    private final static String TITLE_TEXT = "Student Registration Form";

    /**
     * Инициализация компоненты календарь
     */
    private final CalendarComponent calendarComponent = new CalendarComponent();

    /**
     * Инициализация компоненты модалки с результатами
     */
    private final ResultsModal resultsModal = new ResultsModal();

    /**
     * Нужные локаторы на странице
     */
    private final SelenideElement firstNameInput = $("#firstName"), lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"), genderSelect = $("#genterWrapper"),
            numberInput = $("#userNumber"), birthDateInput = $("#dateOfBirthInput"),
            hobbiesInput = $("#hobbiesWrapper"), subjectsInput = $("#subjectsInput"),
            pictureUpload = $("#uploadPicture"), adressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"), cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");

    /**
     * метод открытия страницы со вспомогательными действиями
     * 
     * @return RegistrationFormPage
     */
    public RegistrationFormPage openPage() {

        open(REG_FORM_URL);
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    /**
     * прописать в поле заданное имя
     * 
     * @param value
     *            имя строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setFirstName(String value) {

        firstNameInput.setValue(value);

        return this;
    }

    /**
     * прописать в поле заданную фамилию
     * 
     * @param value
     *            фамилия строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setLastName(String value) {

        lastNameInput.setValue(value);

        return this;
    }

    /**
     * прописать в поле заданный емейл
     * 
     * @param value
     *            емейл строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setEmail(String value) {

        emailInput.setValue(value);

        return this;
    }

    /**
     * выбрать гендер
     * 
     * @param value
     *            гендер строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setGender(String value) {

        genderSelect.$(byText(value)).click();

        return this;
    }

    /**
     * прописать заданный номер телефона в поле
     * 
     * @param value
     *            номер телефона строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setNumber(String value) {

        numberInput.setValue(value);

        return this;
    }

    /**
     * установить дату рождения через компонент Календарь
     * 
     * @param day
     *            установить заданный день
     * @param month
     *            установить заданный месяц
     * @param year
     *            установить заданный год
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setBirthDate(String day, String month, String year) {

        birthDateInput.click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    /**
     * выбрать хобби
     * 
     * @param value
     *            хобби строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setHobbies(String value) {

        hobbiesInput.$(byText(value)).click();

        return this;

    }

    /**
     * установить предмет
     * 
     * @param value
     *            предмет строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setSubjects(String value) {

        subjectsInput.setValue(value).pressEnter();

        return this;

    }

    /**
     * загрузить изображение через форму
     * 
     * @param fileName
     *            имя файла
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setUploadPicture(String fileName) {

        pictureUpload.uploadFromClasspath(fileName);

        return this;

    }

    /**
     * установить заданный адрес
     * 
     * @param value
     *            адрес строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setAddress(String value) {

        adressInput.setValue(value);

        return this;

    }

    /**
     * выбрать заданный штат (область)
     * 
     * @param state
     *            штат строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setState(String state) {

        $(stateInput).setValue(state).pressEnter();

        return this;

    }

    /**
     * выбрать заданный город штата
     * 
     * @param city
     *            город строкой
     * @return RegistrationFormPage
     */
    public RegistrationFormPage setCity(String city) {

        $(cityInput).setValue(city).pressEnter();

        return this;

    }

    /**
     * нажать на кнопку подтвердить
     */
    public void setSubmit() {

        submitButton.click();

    }

    /**
     * проверить, что модалка с результатами появилась
     * 
     * @return RegistrationFormPage
     */
    public RegistrationFormPage checkResultsTableVisible() {

        resultsModal.checkVisible();

        return this;

    }

    /**
     * Проверить результаты в модалке
     * 
     * @param key
     *            название значения в таблице
     * @param value
     *            значение в таблице
     * @return RegistrationFormPage
     */
    public RegistrationFormPage checkTableResult(String key, String value) {

        resultsModal.checkResult(key, value);

        return this;

    }
}

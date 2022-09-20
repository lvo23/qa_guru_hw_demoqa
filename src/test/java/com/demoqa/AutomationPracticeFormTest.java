package com.demoqa;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.utils.Highlighter.highlight;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import com.github.javafaker.Faker;

/**
 * @author Vlad Litvinov
 *
 *         класс для тестов <a href="https://demoqa.com/automation-practice-form">формы
 *         регистрации</a>
 */
public class AutomationPracticeFormTest extends BaseTest {

    /**
     * тест на заполнение формы регистрации
     */
    @Test
    void fillRegistrationFormTest() {

        // инициализируем java-faker
        Faker faker = new Faker();
        Random random = new Random();

        // генерация и хардкод тестовых данных
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();

        // гендер выбираем рандомно, чтобы максимально убрать хардкод
        String[] genders = { "Male", "Female", "Other" };
        String gender = genders[new Random().nextInt(genders.length)];

        String phoneNumber = faker.phoneNumber().subscriberNumber(10);

        String date = "20";
        String month = "September";
        String year = "2022";
        String birthDay = date + " " + month + "," + year;

        String[] subjects = { "English", "Math", "Computer Science" };
        String subject = subjects[new Random().nextInt(subjects.length)];

        String[] hobbies = { "Sports", "Reading", "Music" };
        String hobby = hobbies[new Random().nextInt(hobbies.length)];

        String imagePath = "image_poo.jpg";
        String address = faker.address().streetAddress();

        // вот тут чёт так и не придумал как сделать подбор
        String state = "NCR";
        String city = "Delhi";

        // открываем страницу с формой регистрации
        open("/automation-practice-form");

        highlight(executeJavaScript("$('footer').remove()"));
        highlight(executeJavaScript("$('#fixedban').remove()"));

        highlight($("#firstName").setValue(firstName));
        highlight($("#lastName").setValue(lastName));
        highlight($("#userEmail").setValue(email));
        $$(".custom-radio").findBy(text(gender)).click();
        highlight($("#userNumber").setValue(phoneNumber));

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--020").click();
        highlight($("#subjectsInput").setValue(subject).pressEnter());
        $$(".custom-control-label").findBy(text(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(imagePath);
        highlight($("#currentAddress").setValue(address));
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        // проверяем успех заполнения формы
        highlight($(".modal-header").shouldHave(text("Thanks for submitting the form")));
        highlight($(".table-responsive").shouldHave(text(firstName + " " + lastName), text(email),
                text(gender), text(phoneNumber), text(birthDay), text(subject), text(hobby),
                text(imagePath), text(address), text(state + " " + city)));
    }

}

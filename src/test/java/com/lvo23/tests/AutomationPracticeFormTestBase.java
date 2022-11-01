package com.lvo23.tests;

import static com.lvo23.utils.DataGenerator.generateAddress;
import static com.lvo23.utils.DataGenerator.generateAvatar;
import static com.lvo23.utils.DataGenerator.generateCity;
import static com.lvo23.utils.DataGenerator.generateDay;
import static com.lvo23.utils.DataGenerator.generateEmail;
import static com.lvo23.utils.DataGenerator.generateFirstName;
import static com.lvo23.utils.DataGenerator.generateGender;
import static com.lvo23.utils.DataGenerator.generateHobby;
import static com.lvo23.utils.DataGenerator.generateLastName;
import static com.lvo23.utils.DataGenerator.generateMonth;
import static com.lvo23.utils.DataGenerator.generatePhoneNumber;
import static com.lvo23.utils.DataGenerator.generateState;
import static com.lvo23.utils.DataGenerator.generateSubject;
import static com.lvo23.utils.DataGenerator.generateYear;
import static io.qameta.allure.Allure.step;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lvo23.pages.RegistrationFormPage;

/**
 * @author Vlad Litvinov
 *
 *         класс для тестов <a href="https://demoqa.com/automation-practice-form">формы
 *         регистрации</a>
 */
public class AutomationPracticeFormTestBase extends TestBase {

    /**
     * Инициализация страницы с формой регистрации
     */
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    /**
     * тест на заполнение формы регистрации
     */
    @Test
    @DisplayName("Заполнение всех полей регистрационной формы")
    @Disabled("Неактуален")
    void fillRegistrationFormTest() {

        // генерим тестовые данные
        String firstName = generateFirstName();
        String lastName = generateLastName();
        String email = generateEmail();
        String gender = generateGender();
        String phoneNumber = generatePhoneNumber();
        String hobby = generateHobby();
        String subject = generateSubject();
        String address = generateAddress();
        String imagePath = generateAvatar();
        String date = generateDay();
        String month = generateMonth();
        String year = generateYear();
        String birthDay = date + " " + month + "," + year;
        String state = generateState();
        String city = generateCity();

        step("Заполнение формы", () -> {
            registrationFormPage.openPage().setFirstName(firstName).setLastName(lastName)
                    .setEmail(email).setGender(gender).setNumber(phoneNumber)
                    .setBirthDate(date, month, year).setHobbies(hobby).setSubjects(subject)
                    .setUploadPicture(imagePath).setAddress(address).setState(state).setCity(city)
                    .setSubmit();
        });

        step("Проверяем результат отправки формы", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkTableResult("Student Name", firstName + " " + lastName)
                    .checkTableResult("Student Email", email).checkTableResult("Gender", gender)
                    .checkTableResult("Mobile", phoneNumber)
                    .checkTableResult("Date of Birth", birthDay)
                    .checkTableResult("Subjects", subject).checkTableResult("Hobbies", hobby)
                    .checkTableResult("Picture", imagePath).checkTableResult("Address", address)
                    .checkTableResult("State and City", state + " " + city);
        });
    }

}

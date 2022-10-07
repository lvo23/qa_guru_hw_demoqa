package com.demoqa.tests;

import static com.demoqa.utils.DataGenerator.generateAddress;
import static com.demoqa.utils.DataGenerator.generateAvatar;
import static com.demoqa.utils.DataGenerator.generateCity;
import static com.demoqa.utils.DataGenerator.generateDay;
import static com.demoqa.utils.DataGenerator.generateEmail;
import static com.demoqa.utils.DataGenerator.generateFirstName;
import static com.demoqa.utils.DataGenerator.generateGender;
import static com.demoqa.utils.DataGenerator.generateHobby;
import static com.demoqa.utils.DataGenerator.generateLastName;
import static com.demoqa.utils.DataGenerator.generateMonth;
import static com.demoqa.utils.DataGenerator.generatePhoneNumber;
import static com.demoqa.utils.DataGenerator.generateState;
import static com.demoqa.utils.DataGenerator.generateSubject;
import static com.demoqa.utils.DataGenerator.generateYear;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.demoqa.BaseTest;
import com.demoqa.pages.RegistrationFormPage;

/**
 * @author Vlad Litvinov
 *
 *         класс для тестов <a href="https://demoqa.com/automation-practice-form">формы
 *         регистрации с использованием параметризации Junit</a>
 */
public class AutomationPracticeFormWithParamsTest extends BaseTest {

    /**
     * Инициализация страницы с формой регистрации
     */
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    /**
     * тест на заполнение формы регистрации
     */
    @Test
    @DisplayName("Заполнение всех полей регистрационной формы")
    void fillRegistrationFormTest() {

        // данные для тестов, которые генерируются
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

        // сам тест
        registrationFormPage.openPage().setFirstName(firstName).setLastName(lastName)
                .setEmail(email).setGender(gender).setNumber(phoneNumber)
                .setBirthDate(date, month, year).setHobbies(hobby).setSubjects(subject)
                .setUploadPicture(imagePath).setAddress(address).setState(state).setCity(city)
                .setSubmit();

        // проверяем успех заполнения формы
        // todo наверное название (key) можно вынести в енам какой-нибудь
        registrationFormPage.checkResultsTableVisible()
                .checkTableResult("Student Name", firstName + " " + lastName)
                .checkTableResult("Student Email", email).checkTableResult("Gender", gender)
                .checkTableResult("Mobile", phoneNumber)
                .checkTableResult("Date of Birth", birthDay).checkTableResult("Subjects", subject)
                .checkTableResult("Hobbies", hobby).checkTableResult("Picture", imagePath)
                .checkTableResult("Address", address)
                .checkTableResult("State and City", state + " " + city);
    }

}

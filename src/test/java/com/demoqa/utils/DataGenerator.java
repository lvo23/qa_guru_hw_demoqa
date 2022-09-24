package com.demoqa.utils;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

/**
 * @author Vlad Litvinov вспомогательная утилита, в которой генерятся различные данные для тестов
 */
public class DataGenerator {

    /**
     * инициализация java-faker
     */
    static Faker faker = new Faker();

    /**
     * генерация имени
     * @return строку с рандомным именем
     */
    public static String generateFirstName() {

        return faker.name().firstName();
    }

    /**
     * генерация фамилии
     * @return строку с рандомной фамилией
     */
    public static String generateLastName() {

        return faker.name().lastName();
    }

    /**
     * генерация емейла
     * @return строку с рандомным емейлом
     */
    public static String generateEmail() {

        return faker.internet().emailAddress();
    }

    /**
     * генерация гендера (пола)
     * @return строку с рандомным гендером
     */
    public static String generateGender() {

        String[] genders = { "Male", "Female", "Other" };
        return genders[new Random().nextInt(genders.length)];
    }

    /**
     * генерация номера телефона 10-значного
     * @return строку с рандомным 10-значного номера телефона
     */
    public static String generatePhoneNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    /**
     * генерация предмета изучения (математика, анлийский итд)
     * @return строку с рандомным предметом
     */
    public static String generateSubject() {

        String[] subjects = { "English", "Math", "Computer Science" };
        return subjects[new Random().nextInt(subjects.length)];

    }

    /**
     * генерация хобби
     * @return строку с рандомным хобби
     */
    public static String generateHobby() {
        String[] hobbies = { "Sports", "Reading", "Music" };
        return hobbies[new Random().nextInt(hobbies.length)];

    }

    /**
     * генерация адреса
     * @return строку с рандомным адресом
     */
    public static String generateAddress() {
        return faker.address().streetAddress();
    }

}

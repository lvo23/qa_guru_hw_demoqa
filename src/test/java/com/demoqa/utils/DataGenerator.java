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
    static Faker faker = new Faker(new Locale("ru"));

    /**
     * генерация имени
     * @return строку с рандомным именем
     */
    public static String generateFirstName() {

        return faker.name().firstName();
    }

    public static String generateLastName() {

        return faker.name().lastName();
    }

    public static String generateEmail() {

        return faker.internet().emailAddress();
    }

    public static String generateGender() {

        String[] genders = { "Male", "Female", "Other" };
        return genders[new Random().nextInt(genders.length)];
    }

    public static String generatePhoneNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String generateSubject() {

        String[] subjects = { "English", "Math", "Computer Science" };
        return subjects[new Random().nextInt(subjects.length)];

    }

    public static String generateHobby() {
        String[] hobbies = { "Sports", "Reading", "Music" };
        return hobbies[new Random().nextInt(hobbies.length)];

    }

    public static String generateAddress() {
        return faker.address().streetAddress();
    }

}

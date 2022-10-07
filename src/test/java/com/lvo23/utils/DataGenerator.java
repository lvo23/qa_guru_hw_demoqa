package com.lvo23.utils;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.eightbit.EightBitAvatar;

/**
 * @author Vlad Litvinov вспомогательная утилита, в которой генерятся различные данные для тестов
 */
public class DataGenerator {

    /**
     * рандомная дата
     */
    private static final String randomDate =
            LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))).toString();

    /**
     * инициализация java-faker
     */
    static Faker faker = new Faker();

    /**
     * генерация имени
     * 
     * @return строку с рандомным именем
     */
    public static String generateFirstName() {

        return faker.name().firstName();
    }

    /**
     * генерация фамилии
     * 
     * @return строку с рандомной фамилией
     */
    public static String generateLastName() {

        return faker.name().lastName();
    }

    /**
     * генерация емейла
     * 
     * @return строку с рандомным емейлом
     */
    public static String generateEmail() {

        return faker.internet().emailAddress();
    }

    /**
     * генерация гендера (пола)
     * 
     * @return строку с рандомным гендером
     */
    public static String generateGender() {

        String[] genders = { "Male", "Female", "Other" };
        return genders[new Random().nextInt(genders.length)];
    }

    /**
     * генерация номера телефона 10-значного
     * 
     * @return строку с рандомным 10-значного номера телефона
     */
    public static String generatePhoneNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

    /**
     * генерация предмета изучения (математика, анлийский итд)
     * 
     * @return строку с рандомным предметом
     */
    public static String generateSubject() {

        String[] subjects = { "English", "Math", "Computer Science" };
        return subjects[new Random().nextInt(subjects.length)];

    }

    /**
     * генерация хобби
     * 
     * @return строку с рандомным хобби
     */
    public static String generateHobby() {

        String[] hobbies = { "Sports", "Reading", "Music" };
        return hobbies[new Random().nextInt(hobbies.length)];

    }

    /**
     * генерация адреса
     * 
     * @return строку с рандомным адресом
     */
    public static String generateAddress() {

        return faker.address().streetAddress();
    }

    /**
     * генерация аватара и самого названия файла
     *
     * @return строка с наименованием файла
     */
    public static String generateAvatar() {

        String imagePath = "avatar.png";
        Avatar avatar = EightBitAvatar.newMaleAvatarBuilder().build();
        avatar.createAsPngToFile(123456L, new File("src/test/resources/avatar.png"));
        return imagePath;
    }

    /**
     * генерация дня
     * 
     * @return строку с днём (12)
     */
    public static String generateDay() {

        LocalDate localDate = LocalDate.parse(randomDate);

        return String.valueOf(localDate.getDayOfMonth());

    }

    /**
     * генерация месяца
     * 
     * @return строку с месяцем (November)
     */
    public static String generateMonth() {

        LocalDate localDate = LocalDate.parse(randomDate);

        return localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

    }

    /**
     * генерация года
     * 
     * @return строку с годом (2021)
     */
    public static String generateYear() {

        LocalDate localDate = LocalDate.parse(randomDate);

        return String.valueOf(localDate.getYear());

    }

    /**
     * генерация полной даты рождения
     * 
     * /** псевдогенерация штата
     * 
     * @return строку с названием штата
     */
    public static String generateState() {

        return "NCR";
    }

    /**
     * псевдогенерация города
     * 
     * @return строку с названием города
     */
    public static String generateCity() {

        return "Delhi";
    }

}

# qa_guru_hw_demoqa

##Домашнее задание по курсу QA GURU.

**Тема**: Погружаемся в инструментарий и библиотеки
**Задание**: 
1. Зарегистрируйте аккаунт на https://github.com
2. Создайте новый проект для домашнего задания https://github.com/new
3. Разработайте один автотест на проверку формы https://demoqa.com/automation-practice-form
4. Запушьте код в свой репозиторий и дайте на него ссылку в качестве ответа на домашнее задание


Для генерации тестовых данных использован [java-faker](https://github.com/DiUS/java-faker)

**Из забавного:**
- Хотел сначала вставить дату полностью, чтобы не открывать календарь, но есть занятный баг – если
очищать поле ввода `Date of Birth` до конца, то страница просто становится белой :) и метод очистки
поля почему-то не работает. А имитацию backspace делать такое себе
```
        // дату мб сразу в полном формате прописывать
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
                String birthDay = dateFormat.format(faker.date().birthday());
        // очистим поле ввода, чтобы сразу вставить нужную дату
        $("#subjectsInput").clear();
        $("#subjectsInput").click();
        highlight($("#dateOfBirthInput").setValue(birthDay));
```
Пробовал также выделять текст сначала, но тоже не взлетело
```
        $("#subjectsInput").sendKeys(Keys.CONTROL+"a");
```
- Взял для отладки и понимания какой элемент выбирается класс Highliter
из [примеров selenium](https://github.com/selenide-examples/gmail/blob/master/test/org/selenide/examples/gmail/Highlighter.java), 
который подсвечивает выбранный элемент
- Конечно можно вынести всё это добро в отдельные классы, чтобы в самом тесте оставались только шаги,
но кажется, что это темы следующих уроков.

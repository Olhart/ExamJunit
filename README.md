# ExamJunit

Решение эксаменационношо заданания школы тестирования: проект автотестов с использованием Junit, Maven, Selenide, Allure.
Реализовано тестирование веб-ресурса "edujira.ifellow.ru".

### Тест кейс: 
1.	Авторизация на "edujira.ifellow.ru";
2.	Переход в проект "TestProject";
3.	Проверка отображения количества активных задач в проекте;
4.	Переход в задачу "TestSelenium bug" и проверка статуса задачи и привязки в затронутой версии;
5.	Создание автотестом нового бага с описанием;
6.	Перевод задач по статусам.

Проект реализован по паттерну PageObject.
Для выбора элементов на странице использованы локаторы X-Path.

## Для запуска тестов:
```
$ mvn test
```

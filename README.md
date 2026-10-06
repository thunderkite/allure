# DemoQA UI tests with Allure

Учебный Maven-проект для UI-тестирования DemoQA на Java, Selenium WebDriver и TestNG.

## Запуск

```powershell
.\mvnw.cmd clean test
```

Для одного браузера:

```powershell
.\mvnw.cmd -Dbrowser=chrome -Dheadless=true clean test
```

Для HTML-отчёта:

```powershell
.\mvnw.cmd allure:report
.\mvnw.cmd allure:serve
```

Тестовый набор в `testng.xml` запускает шесть сценариев в Chrome, Firefox и Edge параллельно. Драйверы подбирает Selenium Manager. Результаты Allure находятся в `target/allure-results`, а окружение записывается в `environment.properties`.

## Сценарии

- Elements: успешная отправка формы Text Box и отрицательная проверка email.
- Alerts: отмена confirm и ввод текста в prompt.
- Widgets: изменение значения Slider.
- Interactions: Drag and Drop.

## Git

Рабочая ветка: `feature/student_demoqa_allure`. Для сдачи создаётся Pull Request в `main` с результатами запуска, ссылкой на отчёт и хэшем последнего коммита.
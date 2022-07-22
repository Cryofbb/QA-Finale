Запуск тестов

1. Склонироовать [репозиторий](https://github.com/Cryofbb/QA-Finale)
1. Подключить устройство для тестирования, либо запустить эмулятор
2. Отключить анимации и переходы
3. Перейти в папку `fmh-android`
4. Открыть консоль и запустить тесты командой `./gradlew connectedAndroidTest`

Для получения результатов тестирования

1. Получить отчеты коммандой `adb exec-out run-as ru.iteco.fmhandroid sh -c "cd /data/data/ru.iteco.fmhandroid/files && tar cf - allure-results" > allure-results.tar`
1. Распаковать отчеты
1. Запустить Allure коммандой `allure serve`

[Итоговый отчет](https://github.com/Cryofbb/QA-Finale/blob/main/Result.md)

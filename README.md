# Response-stub
Приложение-заглушка для возвращения кастомных кодов ответа в зависимости от урла и метода.
Конфигурация маршрутов в config/AppConfig.json
Допустимые методы:
- GET
- POST
- UPDATE
- DELETE

Если маршрут не задан явно, то возвращается код по умаолчанию прописанный в "defaultCode"

### Hexlet tests and linter status:
[![hexlet-check](https://github.com/DUSHA20/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DUSHA20/java-project-78/actions/workflows/hexlet-check.yml)
[![Java CI](https://github.com/DUSHA20/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/DUSHA20/java-project-78/actions/workflows/main.yml)
<a href="https://codeclimate.com/github/DUSHA20/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/10cb29534abc406d625a/maintainability" /></a>
<a href="https://codeclimate.com/github/DUSHA20/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/10cb29534abc406d625a/test_coverage" /></a>

# Data Validator Project

## Описание

Data Validator - это библиотека для валидации данных на основе различных схем. Она позволяет создавать схемы для строк, чисел и ассоциативных массивов (мапов), а затем проверять, соответствуют ли данные этим схемам.

## Зачем нужен

Эта библиотека полезна для:
- Проверки входных данных в приложениях.
- Валидации данных конфигурации.
- Упрощения написания проверок на соответствие требованиям.

## Использование

### StringSchema

Для проверки строк используйте `StringSchema`.

```
StringSchema stringSchema = validator.string();
```
```
// Проверка на обязательность
stringSchema.required();
```
```
// Проверка на минимальную длину
stringSchema.minLength(5);
```
```
// Проверка на содержание подстроки
stringSchema.contains("abc");
```
```
boolean isValid = stringSchema.isValid("abcde"); // true
```

### NumberSchema

Для проверки чисел используйте `NumberSchema`.

```
NumberSchema numberSchema = validator.number();
```
```
// Проверка на обязательность
numberSchema.required();
```
```
// Проверка на положительное число
numberSchema.positive();
```
```
// Проверка на диапазон
numberSchema.range(5, 10);
```
```
boolean isValid = numberSchema.isValid(7); // true
```

### MapSchema

Для проверки ассоциативных массивов используйте `MapSchema`.

```
MapSchema<String, Object> mapSchema = validator.map();
```
```
// Проверка на обязательность
mapSchema.required();
```
```
// Проверка на размер мапа
mapSchema.sizeof(2);
```
```
boolean isValid = mapSchema.isValid(Map.of("key1", "value1", "key2", "value2")); // true
```

### Тестирование

Для запуска тестов выполните:
```
./gradlew test
```

plugins {
    java
    // Allure Gradle-плагин: добавляет задачи allureReport / allureServe
    // и настраивает test-таск на сбор allure-results
    id("io.qameta.allure") version "2.11.2"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

allure {
    // Версия Allure Framework (командлайн-тула и адаптеров)
    version.set("2.27.0")

    adapter {
        // AspectJ-агент нужен, чтобы работали аннотации @Step и @Attachment
        aspectjWeaver.set(true)
        aspectjVersion.set("1.9.22") // добавлено вручную, чтобы зафиксировать версию AspectJ

        // Явно включаем JUnit 5 адаптер — плагин сам подтянет allure-junit5
        frameworks {
            junit5 {
                enabled.set(true)
            }
        }
    }
}

dependencies {
    // === Тестовый фреймворк (JUnit 5) ===
    testImplementation(platform("org.junit:junit-bom:5.10.2")) // BOM — фиксирует согласованные версии всех модулей JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter")        // основной движок JUnit 5 (Jupiter API + engine)
    testImplementation("org.junit.jupiter:junit-jupiter-params")  // поддержка параметризованных тестов (@ParameterizedTest)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") // обязателен для Gradle 8.x/9.x — раньше подтягивался автоматически

    // === UI-автоматизация ===
    implementation("com.codeborne:selenide:7.17.0") // обёртка над Selenium WebDriver — упрощает работу с UI-тестами

    // === Проверки/ассерты ===
    implementation("org.assertj:assertj-core:4.0.0-M1") // библиотека для читаемых fluent-ассертов (assertThat(...))

    // === Allure-репортинг ===
    implementation("io.qameta.allure:allure-java-commons:2.27.0") // базовые классы Allure (аннотации @Step, @Attachment и т.д.)

    // === Генерация тестовых данных ===
    implementation("com.github.javafaker:javafaker:1.0.2") // генератор случайных данных (имена, адреса, email и т.п.)

    // === Аннотации для nullability ===
    implementation("org.jspecify:jspecify:1.0.0") // стандартизированные аннотации @Nullable/@NonNull

    // === Lombok ===
    compileOnly("org.projectlombok:lombok:1.18.46")       // сокращает бойлерплейт-код (@Data, @Builder и т.п.)
    annotationProcessor("org.projectlombok:lombok:1.18.46") // процессор, генерирующий код Lombok на этапе компиляции
}

tasks.test {
    useJUnitPlatform()
}
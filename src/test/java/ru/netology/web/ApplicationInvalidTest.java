package ru.netology.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationInvalidTest {

    @Test
    void shouldGetErrorMessageIfNameInvalid() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Shchedrin Mikhail");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_text .input__sub").shouldHave(text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldGetErrorMessageIfNameEmpty() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_text .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void shouldGetErrorMessageIfPhoneInvalid() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Салтыков-Щедрин Михаил");
        $("[data-test-id=phone] input").setValue("+799911111111");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_tel .input__sub").shouldHave(text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldGetErrorMessageIfPhoneEmpty() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Салтыков-Щедрин Михаил");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_tel .input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void shouldInvalidCheckbox() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Салтыков-Щедрин Михаил");
        $("[data-test-id=phone] input").setValue("+79991111111");
        $(".button").click();
        $("[data-test-id='agreement'].input_invalid .checkbox__text")
                .shouldHave(exactText("Я соглашаюсь с условиями обработки и использования моих персональных данных" +
                        " и разрешаю сделать запрос в бюро кредитных историй"));
    }

}
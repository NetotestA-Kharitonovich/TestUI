package ru.netology.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class ApplicationTest {

    @Test
    void shouldTest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Салтыков-Щедрин Михаил");
        $("[data-test-id=phone] input").setValue("+79991111111");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".Success_successBlock__2L3Cw").shouldHave(text(" Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
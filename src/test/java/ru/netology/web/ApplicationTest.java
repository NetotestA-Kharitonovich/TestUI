package ru.netology.web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationTest {

    @Test
    public void shouldCriticalPathTest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldValidNameTestOne() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Фёдорова Алёна");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldValidNameTestTwo() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Салтыков-Щедрин Михаил");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldValidNameTestThree() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Мухаммад ибн Абд аль-Ваххаб");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void shouldInvalidNameTestOne() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Alex Kharitonovich");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldInvalidNameTestTwo() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Aleksandr");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldInvalidNameTestThree() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("+79161111111");
        $("[data-test-id=phone] input").setValue("+79161111111");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void shouldInvalidPhoneTestOne() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("89166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldInvalidPhoneTestTwo() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("+7916676000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldInvalidPhoneTestThree() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("+791667600000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldInvalidPhoneTestFour() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("Iphone");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void shouldEmptyInputTestOne() {
        open("http://localhost:9999");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldEmptyInputTestTwo() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void shouldEmptyCheckBoxTest() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("+79166760000");
        $("button.button").click();
        $("[data-test-id=agreement]").should(cssClass("input_invalid"));
    }
}
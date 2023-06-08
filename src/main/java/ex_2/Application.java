//        Створіть контролер і HTML-форму, дані з якої записуватимуться у файл,
//        а після відправлення форми буде виводитися повідомлення про успішну операцію
//        та кількість записів за весь час роботи застосунку.
//
//        Додайте на форму, яка реалізована в другому завданні,
//        кнопку, після натискання на яку всі записи з файлу будуть виведені на сторінку.

package ex_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "ex_2")

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
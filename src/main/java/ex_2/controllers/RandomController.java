//Створити новий контролер з різним мапінгом, який буде приймати тільки Get-запити та віддавати
// випадково згенеровану інформацію в JSON-форматі. Наприклад, для мапінгу «/uuid» виводити
// випадково згенерований uuid, для мапінгу «/exchange» виводити випадкове значення курсу валют
// або для «/exchange/{currency}» виводити значення курсу валюти, переданої в змінному шляху «currency».
// Для реалізації завдання потрібно буде скористатися анотацією @ResponseBody.

package ex_2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.UUID;

@Controller
public class RandomController {

    @GetMapping("/uuid")
    @ResponseBody
    public String getRandomUUID() {
        UUID uuid = UUID.randomUUID();
        return "{\"uuid\": \"" + uuid.toString() + "\"}";
    }

    @GetMapping("/exchange")
    @ResponseBody
    public String getRandomExchangeRate() {
        double rate = generateRandomExchangeRate();
        return "{\"rate\": " + rate + "}";
    }

    @GetMapping("/exchange/{currency}")
    @ResponseBody
    public String getExchangeRateForCurrency(@PathVariable String currency) {
        double rate = generateRandomExchangeRate();
        return "{\"currency\": \"" + currency + "\", \"rate\": " + rate + "}";
    }

    private double generateRandomExchangeRate() {
        Random random = new Random();
        return 0.5 + (2.0 - 0.5) * random.nextDouble(); // Random exchange rate between 0.5 and 2.0
    }
}

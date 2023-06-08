package ex_2.controllers;

import ex_2.FormData;
import ex_2.ResultData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class FormController {

    private static int totalRecords = 0; // счетчик записей

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("data", new FormData());
        return "form";
    }

    @PostMapping(path = "/form")
    public String processForm(@ModelAttribute FormData formData, Model model) {
        try {
            // Запись данных в файл
            FileWriter writer = new FileWriter("data.txt", true);
            writer.write(formData.getData() + "\n");
            writer.close();

            totalRecords++; // Увеличение счетчика записей
            ResultData resultData = new ResultData();
            resultData.setTotalRecords(totalRecords);
            model.addAttribute("result", resultData);

            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
    @GetMapping("/form/view")
    public String viewRecords(Model model) {
        try {
            // Чтение данных из файла
            List<String> records = Files.readAllLines(Paths.get("data.txt"));

            model.addAttribute("records", records);
            return "view-records";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

}
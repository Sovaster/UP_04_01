package com.example.UP_04_01.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    // Калькуоятор с использованием GET параметров
    @GetMapping("/get/calculator")
    public String GetController ( @RequestParam(value = "a", required = false) int a,
                                  @RequestParam(value = "b", required = false) int b,
                                  @RequestParam(value = "action", required = false) String action, Model model){

        double result;
        switch (action) {

            case "Сложение":
                result = a + b;
                break;
            case "Вычитание":
                result = a - b;
                break;
            case "Умножение":
                result = a * b;
                break;
            case "Деление":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "First/getCalc";
    }

    // Калькулятор с использованием метода POST
    //Загрузка формы калькулятора
    @GetMapping("/post/calculator")
    public String PostView(){
        return "First/postCalc";
    }
    //Обработка формы калькулятора
    @PostMapping("/post/process")
    public String PostController(@RequestParam int a, @RequestParam int b,
                                 @RequestParam String action, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("action", action);

        double result;

        switch (action) {

            case "сумма":
                result = a + b;
                break;
            case "вычитание":
                result = a - b;
                break;
            case "умножение":
                result = a * b;
                break;
            case "делевние":
                result = a / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "First/backCalc";
    }
}

package com.juliopari.springbootcalculadora.controller;

import com.juliopari.springbootcalculadora.dto.CalculadoraRequest;
import com.juliopari.springbootcalculadora.dto.CalculadoraResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    // Info: https://www.baeldung.com/spring-boot-json
    @PostMapping("/")
    public CalculadoraResponse calcular(@RequestBody CalculadoraRequest rq) {

        CalculadoraResponse rs = new CalculadoraResponse();
        rs.setResultado(0.0);

        try {
            switch (rq.getOperacion()) {
                case "+":
                    rs.setResultado(rq.getNumero1() + rq.getNumero2());
                    break;
                case "-":
                    rs.setResultado(rq.getNumero1() - rq.getNumero2());
                    break;
                case "*":
                    rs.setResultado(rq.getNumero1() * rq.getNumero2());
                    break;
                case "/":
                    rs.setResultado(rq.getNumero1() / rq.getNumero2());
                    break;
                default:
                    break;

            }
        } catch (Exception e) {
        }

        return rs;
    }

}

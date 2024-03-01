package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String addString(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                            @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return Binary.add(number1, number2).getValue();
        // http://localhost:8080/add?operand1=111&operand2=1010
    }

    @GetMapping("/add_json")
    public BinaryAPIResult addJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                   @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "add", number2, Binary.add(number1, number2));
        // http://localhost:8080/add?operand1=111&operand2=1010
    }

    @GetMapping("/multiply_json")
    public BinaryAPIResult multiplyJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                        @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "multiply", number2, Binary.multiply(number1, number2));
        // http://localhost:8080/multiply_json?operand1=1101&operand2=1010
    }
// In BinaryAPIController.java
 @GetMapping("/logical_or_json")
    public BinaryAPIResult logicalORJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                         @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "logical_or", number2, Binary.LogicalOR(number1, number2));
        // http://localhost:8080/logical_or_json?operand1=1010&operand2=1101
    }

@GetMapping("/logical_and_json")
    public BinaryAPIResult logicalANDJSON(@RequestParam(name = "operand1", required = false, defaultValue = "") String operand1,
                                          @RequestParam(name = "operand2", required = false, defaultValue = "") String operand2) {
        Binary number1 = new Binary(operand1);
        Binary number2 = new Binary(operand2);
        return new BinaryAPIResult(number1, "logical_and", number2, Binary.LogicalAND(number1, number2));
        // http://localhost:8080/logical_and_json?operand1=1111&operand2=1010
    }

}
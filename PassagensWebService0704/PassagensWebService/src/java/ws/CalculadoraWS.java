/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author Ivan
 */
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
//@Stateless
public class CalculadoraWS {

 public double fazerOp(@WebParam(name = "num1") double a,
   @WebParam(name = "num2") double b, @WebParam(name = "op") String op) {
  // Por que voc� n�o clona o projeto e cria mais fun��es para brincar?
  switch (op) {
  case "+":
   return a + b;
  case "-":
   return a - b;
  case "*":
   return a * b;
  case "/":
   return a / b;
  default:
   throw new IllegalArgumentException("Opera��o '" + op
     + "' n�o reconhecida. Informa '+', '-', '*' ou '/'.");
  }
 }
}
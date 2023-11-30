/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.calc;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author asus
 */
@WebService(serviceName = "Calculadora")
public class Calculadora {


    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "adicao")
    public int adicao(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return a + b;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "subtracao")
    public int subtracao(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return a - b;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "multiplicacao")
    public int multiplicacao(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return a * b;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "divisao")
    public float divisao(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        //TODO write your implementation code here:
        return a / b;
    }
}
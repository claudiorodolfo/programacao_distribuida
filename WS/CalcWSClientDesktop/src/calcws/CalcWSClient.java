/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcws;

/**
 *
 * @author asus
 */
public class CalcWSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalcWSClient wsClient = new CalcWSClient();
        int retorno = wsClient.adicao(4, 5);
        System.out.println("A soma:"+retorno);
    }

    private static int adicao(int a, int b) {
        wsclient.Calculadora_Service service = new wsclient.Calculadora_Service();
        wsclient.Calculadora port = service.getCalculadoraPort();
        return port.adicao(a, b);
    }
    
}

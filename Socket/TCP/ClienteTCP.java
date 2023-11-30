import java.io.*;
import java.net.*;

public class ClienteTCP {

    public static void main(String[] args) throws Exception {
  
		String enderecoServidor = "127.0.0.1";
		//String enderecoServidor = "work";
		int portaServidor = 4444;
			
		//Criação de socket
		Socket tomadaCliente = new Socket(enderecoServidor, portaServidor);
		/* associa um buffer ao fluxo de entrada e outro ao fluxo de saida do socket */
		PrintWriter bufferSaida = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


		/* associa uma string a entrada padrao (teclado)*/
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		/* cria duas strings, uma para receber e outra para enviar pelo socket */
		String textoRecebido;
		String textoAEnviar;
		while (true) {
			System.out.println("Enviar (digite Bye para terminar): ");
			/* lê do teclado*/
			textoAEnviar = teclado.readLine(); 
			/* envia pelo fluxo de saída socket */
			bufferSaida.println(textoAEnviar); 
			/* termina se usuario digitou Bye*/
			if (textoAEnviar.equals("Bye")) {
				break;
			}
			/* recebe texto do socket servidor*/
			textoRecebido = bufferEntrada.readLine(); 
			/* mostra na saida padrao (monitor)*/
			System.out.println("Mensagem do servidor: " + textoRecebido); 
		}
		/* fecha os buffers e o socket */
		bufferSaida.close();
		bufferEntrada.close();
		teclado.close();
        tomadaCliente.close();
    }
}
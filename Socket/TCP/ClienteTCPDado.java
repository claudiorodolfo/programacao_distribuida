import java.io.*;
import java.net.*;

public class ClienteTCPDado {

    public static void main(String[] args) throws Exception {
  
		String enderecoServidor = "127.0.0.1";
		//String enderecoServidor = "work";
		int portaServidor = 4444;
			
		//Criação de socket
		Socket tomadaCliente = new Socket(enderecoServidor, portaServidor);
        
		/* cria dois buffers de dados primitivos, uma para enviar e outro para receber da conexao com o cliente*/
		DataInputStream bufferEntrada = new DataInputStream(tomadaCliente.getInputStream());   
        DataOutputStream bufferSaida = new DataOutputStream(tomadaCliente.getOutputStream());   
                           

		/* associa uma string a entrada padrao (teclado)*/
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			/* cria dois arrays, uma para receber e outra para enviar pelo socket */
			String textoAEnviar;
			String textoRecebido;
			System.out.println("Enviar (digite Bye para terminar): ");
			/* lê do teclado*/
			textoAEnviar = teclado.readLine();
			/* envia array pelo fluxo de saída socket */
			bufferSaida.writeUTF(textoAEnviar);
		
			/* termina se usuario digitou Bye*/
			if (textoAEnviar.equals("Bye")) {
				break;
			}
			
			/* recebe array do socket cliente*/
			textoRecebido = bufferEntrada.readUTF();
			/* mostra na saida padrao (monitor)*/
			System.out.println("Mensagem do servidor:"+ textoRecebido); 
		}
		/* fecha os buffers e o socket */
		bufferSaida.close();
		bufferEntrada.close();
		teclado.close();
        tomadaCliente.close();
    }
}
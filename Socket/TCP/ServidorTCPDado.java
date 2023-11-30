import java.net.*;
import java.io.*;

public class ServidorTCPDado {

    public static void main(String[] args) throws Exception {

		/* cria socket na porta 4444 */
        ServerSocket tomadaServidora = new ServerSocket(4444);
		/* aguarda solicitacao do cliente e aceita conexao */
		System.out.println("Servidor Aguardando Conexões.");
        Socket tomadaCliente = tomadaServidora.accept();
     
		/* cria dois buffers de dados primitivos, uma para enviar e outro para receber da conexao com o cliente*/
		DataInputStream bufferEntrada = new DataInputStream(tomadaCliente.getInputStream());   
        DataOutputStream bufferSaida = new DataOutputStream(tomadaCliente.getOutputStream());   
		
        while (true) {
			/* cria duas strings, uma para receber e outra para enviar pelo socket */
			String textoRecebido;
			String textoAEnviar;

			/* recebe dado do socket cliente*/
			textoRecebido = bufferEntrada.readUTF();

			/* termina se recebeu Bye */
			if (textoRecebido.equals("Bye")) {
                break;
            }
			/*Faz o processamento de acordo a requisição do cliente*/
			textoAEnviar = textoRecebido.toUpperCase();
			
			/* envia para o cliente */
            bufferSaida.writeUTF(textoAEnviar);
        }
        /* fecha buffers e socket */
        bufferSaida.close();
        bufferEntrada.close();
        tomadaCliente.close();
        tomadaServidora.close();
    }
}
import java.net.*;
import java.io.*;

public class ServidorTCPTexto {

    public static void main(String[] args) throws Exception {

		/* cria socket na porta 4444 */
        ServerSocket tomadaServidora = new ServerSocket(4444);
		/* aguarda solicitacao do cliente e aceita conexao */
		System.out.println("Servidor Aguardando Conexões.");
        Socket tomadaCliente = tomadaServidora.accept();
     
        /* cria dois buffers de textos, uma para enviar e outro para receber textos da conexao com o cliente*/
        PrintWriter bufferSaida = new PrintWriter(tomadaCliente.getOutputStream(), true);
        BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(tomadaCliente.getInputStream()));
        		

        while (true) {
			String textoAEnviar, textoRecebido;
			/* recebe do cliente */
            textoRecebido = bufferEntrada.readLine();
			
			if (textoRecebido.equals("Bye")) /* termina se recebeu Bye */ {
                break;
            }
			/*Faz o processamento de acordo a requisição do cliente*/
			textoAEnviar = textoRecebido.toUpperCase();
			
			/* envia para o cliente */
            bufferSaida.println(textoAEnviar);
        }
        /* fecha buffers e socket */
        bufferSaida.close();
        bufferEntrada.close();
        tomadaCliente.close();
        tomadaServidora.close();
    }
}
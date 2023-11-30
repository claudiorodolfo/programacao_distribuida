import java.net.*;
import java.io.*;

public class ServidorTCP {

    public static void main(String[] args) throws Exception {

		/* cria socket na porta 4444 */
        ServerSocket tomadaServidora = new ServerSocket(4444);
		/* aguarda solicitacao do cliente e aceita conexao */
		System.out.println("Servidor Aguardando Conexões.");
        Socket tomadaCliente = tomadaServidora.accept();
     
        /* cria dois buffers, uma para enviar e outro para receber da conexao com o cliente*/
        PrintWriter bufferSaida = new PrintWriter(ClientSocket.getOutputStream(), true);
        BufferedReader bufferEntrada = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
		
        String textoAEnviar, textoRecebido;
        while (true) {
			/* recebe do cliente */
            textoRecebido = bufferEntrada.readLine();  
			/*Faz o processamento de acordo a requisição do cliente*/
			textoAEnviar = textoRecebido.toUppercase();
			
			if (textoRecebido.equals("BYE")) /* termina se recebeu Bye */ {
                break;
            }
			/* envia para o cliente */
            out.println(textoAEnviar);  
        }
        /* fecha buffers e socket */
        bufferSaida.close();
        bufferEntrada.close();
        tomadaCliente.close();
        tomadaServidora.close();
    }
}

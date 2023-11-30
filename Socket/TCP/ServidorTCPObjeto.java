import java.net.*;
import java.io.*;

public class ServidorTCPObjeto {

    public static void main(String[] args) throws Exception {

		/* cria socket na porta 4444 */
        ServerSocket tomadaServidora = new ServerSocket(4444);
		/* aguarda solicitacao do cliente e aceita conexao */
		System.out.println("Servidor Aguardando Conexões.");
        Socket tomadaCliente = tomadaServidora.accept();
     
        /* cria dois buffers de objetos, uma para enviar e outro para receber objetos da conexao com o cliente*/		
		ObjectOutputStream bufferSaida = new ObjectOutputStream(tomadaCliente.getOutputStream());
		ObjectInputStream bufferEntrada = new ObjectInputStream(tomadaCliente.getInputStream());
		
        while (true) {
			String textoAEnviar, textoRecebido;
			/* recebe do cliente */
			Usuario u = (Usuario) bufferEntrada.readObject();
			
			if (u.getNome().equals("Bye")) /* termina se recebeu Bye */ {
                break;
            }
			/*Faz o processamento de acordo a requisição do cliente*/
			u.setNome(u.getNome().toUpperCase());
			
			/* envia para o cliente */
			bufferSaida.writeObject(u);		
        }
        /* fecha buffers e socket */
        bufferSaida.close();
        bufferEntrada.close();
        tomadaCliente.close();
        tomadaServidora.close();
    }
}

	class Usuario implements Serializable {
		private String nome;

		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
	}
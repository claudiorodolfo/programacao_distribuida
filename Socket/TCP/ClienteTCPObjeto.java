import java.io.*;
import java.net.*;

public class ClienteTCPObjeto {

    public static void main(String[] args) throws Exception {
  
		String enderecoServidor = "127.0.0.1";
		//String enderecoServidor = "work";
		int portaServidor = 4444;
			
		//Criação de socket
		Socket tomadaCliente = new Socket(enderecoServidor, portaServidor);
        
        /* cria dois buffers de objetos, uma para enviar e outro para receber objetos da conexao com o cliente*/		
		ObjectOutputStream bufferSaida = new ObjectOutputStream(tomadaCliente.getOutputStream());
		ObjectInputStream bufferEntrada = new ObjectInputStream(tomadaCliente.getInputStream());


		/* associa uma string a entrada padrao (teclado)*/
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String textoAEnviar, textoRecebido;
			Usuario u = new Usuario();
			System.out.println("Enviar (digite Bye para terminar): ");
			/* lê do teclado*/
			textoAEnviar = teclado.readLine(); 
			/* envia pelo fluxo de saída socket */
			u.setNome(textoAEnviar);
			bufferSaida.writeObject(u);			
			/* termina se usuario digitou Bye*/
			if (textoAEnviar.equals("Bye")) {
				break;
			}
			/* recebe texto do socket servidor*/
			u = (Usuario) bufferEntrada.readObject();
			/* mostra na saida padrao (monitor)*/
			System.out.println("Mensagem do servidor: " + u.getNome()); 
		}
		/* fecha os buffers e o socket */
		bufferSaida.close();
		bufferEntrada.close();
		teclado.close();
        tomadaCliente.close();
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
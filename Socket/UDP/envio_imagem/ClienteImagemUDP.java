import java.net.*;
import java.util.*;
import java.io.*;

public class ClienteImagemUDP {
	
    public static void main(String args[]) throws Exception {
		
		DatagramSocket tomada = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
		int porta = 5000;
        
		/////////CÓDIGO PARA OBTER O NOME DA IMAGEM
		/////////VIA TECLADO 			
        System.out.print("Digite uma mensagem:");
        Scanner teclado = new Scanner(System.in);
        String mensagem = teclado.nextLine();
        	
		/////////CÓDIGO PARA ENVIAR UMA MENSAGEM COM O 
		/////////NOME DA IMAGEM PARA O SERVIDOR
        byte[] cartaAEnviar = new byte[64];
        cartaAEnviar = mensagem.getBytes();
		
        DatagramPacket envelopeAEnviar
                = new DatagramPacket(cartaAEnviar,
                        cartaAEnviar.length,
                        ip,
                        porta);
        tomada.send(envelopeAEnviar);

		//////////RECEBER O TAMANHO DA IMAGEM DO SERVIDOR
        byte[] cartaAReceber = new byte[8];
        DatagramPacket envelopeAReceber
                = new DatagramPacket(cartaAReceber,
                        cartaAReceber.length);
						
        tomada.receive(envelopeAReceber);
		
		cartaAReceber = envelopeAReceber.getData();
		String msgRecebida = new String(cartaAReceber);
		int tamanhoImagem = Integer.parseInt(msgRecebida.trim());
			
        ///////////RECEBER IMAGEM DO SERVIDOR E 
		///////////SALVAR NO COMPUTADOR
        byte[] cartaAReceber2 = new byte[tamanhoImagem];
		DatagramPacket envelopeAReceber2
                = new DatagramPacket(cartaAReceber2,
                        cartaAReceber2.length);

        tomada.receive(envelopeAReceber2);
		
		String caminhoImagem = "C:/Users/asus/Desktop/IMAGEM_RECEBIDA.jpg";
		ManipulacaoArquivos m = new ManipulacaoArquivos();
        m.deArrayParaImagem(envelopeAReceber2.getData(), caminhoImagem);
		
        //SE NÃO TIVER MAIS NADA PARA FAZER
        //finaliza a conexão
        tomada.close();
    }
}

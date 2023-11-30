import java.net.*;
import java.io.*;

public class ServidorImagemUDP {
	
    public static void main(String[] args) throws Exception {

		int porta = 5000;
        DatagramSocket tomadaServidora = new DatagramSocket(porta);
        System.out.println("Servidor em execucao!");
		
        ///////////RECEBER MENSAGEM DO CLIENTE
		///////////COM NOME DO IMAGEM
        byte[] cartaAReceber = new byte[64];
        DatagramPacket envelopeAReceber
                = new DatagramPacket(cartaAReceber,
                        cartaAReceber.length);
						
		tomadaServidora.receive(envelopeAReceber);				
		cartaAReceber = envelopeAReceber.getData();	
        String nomeImagem = new String(cartaAReceber).trim();
		
        ///////////ENVIAR MENSAGEM PARA O CLIENTE 
		///////////COM O TAMANHO DA IMAGEM 	
		String diretorioBase = "C:/Users/asus/Desktop/";
		String caminhoImagem = diretorioBase + nomeImagem;
		File file = new File(caminhoImagem);		
		String mensagem = String.valueOf(file.length());
		
        //Obtive os dados do remetente (ip e porta) a partir 
        //do envelope recebido anteriormente (envelopeAReceber)
        InetAddress ipCliente = envelopeAReceber.getAddress();
        int portaCliente = envelopeAReceber.getPort();
		
        byte[] cartaAEnviar = new byte[8];
        cartaAEnviar = mensagem.getBytes();
        DatagramPacket envelopeAEnviar
                = new DatagramPacket(cartaAEnviar,
                        cartaAEnviar.length,
                        ipCliente,
                        portaCliente);
        tomadaServidora.send(envelopeAEnviar);


		/////////CÓDIGO PARA ENVIAR UMA IMAGEM PARA O CLIENTE
        byte[] cartaAEnviar2 = new byte[(int)file.length()];
		ManipulacaoArquivos m = new ManipulacaoArquivos();
        cartaAEnviar2 = m.deImagemParaArray(caminhoImagem);
		
        DatagramPacket envelopeAEnviar2
                = new DatagramPacket(cartaAEnviar2,
                        cartaAEnviar2.length,
                        ipCliente,
                        portaCliente);
        tomadaServidora.send(envelopeAEnviar2);
		
        //SE NÃO TIVER MAIS NADA PARA FAZER
        //finaliza a conexão
        tomadaServidora.close();
    }
}
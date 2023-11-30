
import java.net.*;
import java.util.*;

public class ClienteUDP {

    public static void main(String args[]) throws Exception {
		
		DatagramSocket tomada = new DatagramSocket();
        
		/////////CÓDIGO PARA OBTER UM TEXTO VIA TECLADO
        System.out.print("Digite uma mensagem:");
        Scanner teclado = new Scanner(System.in);
        String mensagem = teclado.nextLine();
        
		/////////CÓDIGO PARA ENVIAR UMA MENSAGEM PARA O SERVIDOR
        //String mensagem = "Testando...";
        byte[] cartaAEnviar = new byte[100];
        cartaAEnviar = mensagem.getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket envelopeAEnviar
                = new DatagramPacket(cartaAEnviar,
                        cartaAEnviar.length,
                        ip,
                        5000);
        tomada.send(envelopeAEnviar);

        ////////CÓDIGO PARA RECEBER UMA MENSAGEM DE RESPOSTA DO SERVIDOR
        byte[] cartaAReceber = new byte[100];
        DatagramPacket envelopeAReceber
                = new DatagramPacket(cartaAReceber,
                        cartaAReceber.length);
        tomada.receive(envelopeAReceber);
        String mensagemRecebida = new String(envelopeAReceber.getData());
        System.out.println("CHEGOU DO SERVIDOR:" + mensagemRecebida);

        //SE NÃO TIVER MAIS NADA PARA FAZER
        //finaliza a conexão
        tomada.close();
    }
}

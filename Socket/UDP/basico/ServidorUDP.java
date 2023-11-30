
import java.net.*;

public class ServidorUDP {

    public static void main(String[] args) throws Exception {

        DatagramSocket tomadaServidora = new DatagramSocket(5000);
        System.out.println("Servidor em execução!");
		
        ///////////RECEBER MENSAGEM DO CLIENTE E IMPRIMIR NA TELA
        byte[] cartaAReceber = new byte[100];
        DatagramPacket envelopeAReceber
                = new DatagramPacket(cartaAReceber,
                        cartaAReceber.length);

        tomadaServidora.receive(envelopeAReceber);
        String textoRecebido = new String(envelopeAReceber.getData());
        System.out.println(textoRecebido);

        ///////////ENVIAR MENSAGEM DE VOLTA AO CLIENTE
        byte[] cartaAEnviar = new byte[100];
        String mensagem = "Dados recebidos com sucesso!";
        cartaAEnviar = mensagem.getBytes();
        //Obtive os dados do remetente (ip e porta) a partir 
        //do envelope recebido anteriormente (envelopeAReceber)
        InetAddress ipCliente = envelopeAReceber.getAddress();
        int portaCliente = envelopeAReceber.getPort();

        DatagramPacket envelopeAEnviar
                = new DatagramPacket(cartaAEnviar,
                        cartaAEnviar.length,
                        ipCliente,
                        portaCliente);
        tomadaServidora.send(envelopeAEnviar);

        //SE NÃO TIVER MAIS NADA PARA FAZER
        //finaliza a conexão
        tomadaServidora.close();
    }
}

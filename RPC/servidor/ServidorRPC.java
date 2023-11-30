import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

public class ServidorRPC {

    private ServidorRPC() {
        try {
			// Cria um servidor web na porta 8185
            WebServer ws = new WebServer(8185); 
            XmlRpcServer servidor = ws.getXmlRpcServer(); 
			// Adiciona um novo "handler" ao PHM
            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("Calc", Calculadora.class); 
			// Define um handler no servidor
            servidor.setHandlerMapping(phm);
			// inicia o servidor		
            ws.start(); 
			System.out.println("Servidor iniciado com sucesso!");
		
        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }

    public static void main(String[] args) {
		new ServidorRPC();
    }
}

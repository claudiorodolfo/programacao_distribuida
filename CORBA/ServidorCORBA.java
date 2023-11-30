import CalculadoraApp.*;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

class CalculadoraImpl extends CalculadoraPOA {

    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // implementa os métodos
    @Override
	public int adicao(int x, int y) {
		return x + y;
	}

    @Override  
	public int subtracao(int x, int y) {
		return x - y;	  
	}
  
    @Override
	public int multiplicacao(int x, int y) {
		return x * y;
	}

    @Override 
	public double divisao(int x, int y) {
		return x / y;
	}
}

public class ServidorCORBA {

    public static void main(String args[]) {
        try {
			// cria e inicializa o ORB            
			ORB orb = ORB.init(args, null);

            // Obtém referência a rootpoa (Portable Object Adapter) e ativa o Gerenciador POA
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Cria o serviço e registra ele com o ORB (Object Request Broker)
            CalculadoraImpl calc = new CalculadoraImpl();
            calc.setORB(orb);

            // obtém a referência ao serviço disponibilizado pelo servidor
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calc);
            Calculadora href = CalculadoraHelper.narrow(ref);

            // Obtém a referência para o serviço de nomes
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // vincula a referencia do objeto a um nome, no servidor de nomes
            String objNome = "Calc";
            NameComponent path[] = ncRef.to_name(objNome);
            ncRef.rebind(path, href);

            System.out.println("ServidorCORBA pronto e aguardando ...");

            // aguarda pela invocação dos clientes
            orb.run();
        } catch (Exception e) {
            System.err.println("ERRO: " + e);
            e.printStackTrace(System.out);
        }
    }
}
import CalculadoraApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class ClienteCORBA {
	
  static Calculadora calc;

  public static void main(String args[]) {
      try{
        // cria e inicializa o ORB
        ORB orb = ORB.init(args, null);

        // obtém a referência para o serviço de nomes
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService"); 
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        // Obtém a referência para o Objeto do servidor, através do serviço de nomes
        String objNome = "Calc";
        calc = CalculadoraHelper.narrow(ncRef.resolve_str(objNome));

        //chamada dos métodos do objeto
        System.out.println(calc.adicao(1,2));

        } catch (Exception e) {
          System.out.println("ERRO : " + e) ;
          e.printStackTrace(System.out);
          }
    }
}
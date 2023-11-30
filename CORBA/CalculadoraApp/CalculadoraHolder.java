//Essa classe final mantém uma instância pública do tipo Calculadora. Essa classe fornece operações para argumentos de entrada (org.omg.CORBA.portable.OutputStream) e saída (org.omg.CORBA.portable.InputStream). Essa classe delegate aos métodos da classe Helper a leitura e escrita. Parâmetros in são mapeados para parâmetros conforme o tipo correspondente. Parâmetros out e inout são mapeados para parâmetros do tipo Holder correspondente. 
package CalculadoraApp;

/**
* CalculadoraApp/CalculadoraHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculadora.idl
* Quarta-feira, 4 de Novembro de 2020 13h51min37s GMT-03:00
*/

public final class CalculadoraHolder implements org.omg.CORBA.portable.Streamable
{
  public CalculadoraApp.Calculadora value = null;

  public CalculadoraHolder ()
  {
  }

  public CalculadoraHolder (CalculadoraApp.Calculadora initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculadoraApp.CalculadoraHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculadoraApp.CalculadoraHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculadoraApp.CalculadoraHelper.type ();
  }

}

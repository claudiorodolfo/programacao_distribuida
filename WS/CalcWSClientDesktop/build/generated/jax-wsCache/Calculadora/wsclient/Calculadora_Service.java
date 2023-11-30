
package wsclient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Calculadora", targetNamespace = "http://calc.ws/", wsdlLocation = "http://localhost:8080/CalcWSProvider/Calculadora?wsdl")
public class Calculadora_Service
    extends Service
{

    private final static URL CALCULADORA_WSDL_LOCATION;
    private final static WebServiceException CALCULADORA_EXCEPTION;
    private final static QName CALCULADORA_QNAME = new QName("http://calc.ws/", "Calculadora");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/CalcWSProvider/Calculadora?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CALCULADORA_WSDL_LOCATION = url;
        CALCULADORA_EXCEPTION = e;
    }

    public Calculadora_Service() {
        super(__getWsdlLocation(), CALCULADORA_QNAME);
    }

    public Calculadora_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CALCULADORA_QNAME, features);
    }

    public Calculadora_Service(URL wsdlLocation) {
        super(wsdlLocation, CALCULADORA_QNAME);
    }

    public Calculadora_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CALCULADORA_QNAME, features);
    }

    public Calculadora_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Calculadora_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Calculadora
     */
    @WebEndpoint(name = "CalculadoraPort")
    public Calculadora getCalculadoraPort() {
        return super.getPort(new QName("http://calc.ws/", "CalculadoraPort"), Calculadora.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Calculadora
     */
    @WebEndpoint(name = "CalculadoraPort")
    public Calculadora getCalculadoraPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://calc.ws/", "CalculadoraPort"), Calculadora.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CALCULADORA_EXCEPTION!= null) {
            throw CALCULADORA_EXCEPTION;
        }
        return CALCULADORA_WSDL_LOCATION;
    }

}
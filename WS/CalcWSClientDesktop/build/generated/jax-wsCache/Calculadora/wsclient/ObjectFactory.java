
package wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Adicao_QNAME = new QName("http://calc.ws/", "adicao");
    private final static QName _Divisao_QNAME = new QName("http://calc.ws/", "divisao");
    private final static QName _DivisaoResponse_QNAME = new QName("http://calc.ws/", "divisaoResponse");
    private final static QName _MultiplicacaoResponse_QNAME = new QName("http://calc.ws/", "multiplicacaoResponse");
    private final static QName _AdicaoResponse_QNAME = new QName("http://calc.ws/", "adicaoResponse");
    private final static QName _SubtracaoResponse_QNAME = new QName("http://calc.ws/", "subtracaoResponse");
    private final static QName _Subtracao_QNAME = new QName("http://calc.ws/", "subtracao");
    private final static QName _Multiplicacao_QNAME = new QName("http://calc.ws/", "multiplicacao");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Adicao }
     * 
     */
    public Adicao createAdicao() {
        return new Adicao();
    }

    /**
     * Create an instance of {@link Divisao }
     * 
     */
    public Divisao createDivisao() {
        return new Divisao();
    }

    /**
     * Create an instance of {@link DivisaoResponse }
     * 
     */
    public DivisaoResponse createDivisaoResponse() {
        return new DivisaoResponse();
    }

    /**
     * Create an instance of {@link MultiplicacaoResponse }
     * 
     */
    public MultiplicacaoResponse createMultiplicacaoResponse() {
        return new MultiplicacaoResponse();
    }

    /**
     * Create an instance of {@link AdicaoResponse }
     * 
     */
    public AdicaoResponse createAdicaoResponse() {
        return new AdicaoResponse();
    }

    /**
     * Create an instance of {@link SubtracaoResponse }
     * 
     */
    public SubtracaoResponse createSubtracaoResponse() {
        return new SubtracaoResponse();
    }

    /**
     * Create an instance of {@link Subtracao }
     * 
     */
    public Subtracao createSubtracao() {
        return new Subtracao();
    }

    /**
     * Create an instance of {@link Multiplicacao }
     * 
     */
    public Multiplicacao createMultiplicacao() {
        return new Multiplicacao();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Adicao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "adicao")
    public JAXBElement<Adicao> createAdicao(Adicao value) {
        return new JAXBElement<Adicao>(_Adicao_QNAME, Adicao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Divisao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "divisao")
    public JAXBElement<Divisao> createDivisao(Divisao value) {
        return new JAXBElement<Divisao>(_Divisao_QNAME, Divisao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivisaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "divisaoResponse")
    public JAXBElement<DivisaoResponse> createDivisaoResponse(DivisaoResponse value) {
        return new JAXBElement<DivisaoResponse>(_DivisaoResponse_QNAME, DivisaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplicacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "multiplicacaoResponse")
    public JAXBElement<MultiplicacaoResponse> createMultiplicacaoResponse(MultiplicacaoResponse value) {
        return new JAXBElement<MultiplicacaoResponse>(_MultiplicacaoResponse_QNAME, MultiplicacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdicaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "adicaoResponse")
    public JAXBElement<AdicaoResponse> createAdicaoResponse(AdicaoResponse value) {
        return new JAXBElement<AdicaoResponse>(_AdicaoResponse_QNAME, AdicaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubtracaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "subtracaoResponse")
    public JAXBElement<SubtracaoResponse> createSubtracaoResponse(SubtracaoResponse value) {
        return new JAXBElement<SubtracaoResponse>(_SubtracaoResponse_QNAME, SubtracaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Subtracao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "subtracao")
    public JAXBElement<Subtracao> createSubtracao(Subtracao value) {
        return new JAXBElement<Subtracao>(_Subtracao_QNAME, Subtracao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiplicacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://calc.ws/", name = "multiplicacao")
    public JAXBElement<Multiplicacao> createMultiplicacao(Multiplicacao value) {
        return new JAXBElement<Multiplicacao>(_Multiplicacao_QNAME, Multiplicacao.class, null, value);
    }

}

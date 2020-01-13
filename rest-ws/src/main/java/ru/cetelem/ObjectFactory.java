
package ru.cetelem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.cetelem package. 
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

    private final static QName _HelloWorld1_QNAME = new QName("http://cetelem.ru/", "helloWorld1");
    private final static QName _HelloWorld1Response_QNAME = new QName("http://cetelem.ru/", "helloWorld1Response");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.cetelem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloWorld1 }
     * 
     */
    public HelloWorld1 createHelloWorld1() {
        return new HelloWorld1();
    }

    /**
     * Create an instance of {@link HelloWorld1Response }
     * 
     */
    public HelloWorld1Response createHelloWorld1Response() {
        return new HelloWorld1Response();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorld1 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cetelem.ru/", name = "helloWorld1")
    public JAXBElement<HelloWorld1> createHelloWorld1(HelloWorld1 value) {
        return new JAXBElement<HelloWorld1>(_HelloWorld1_QNAME, HelloWorld1 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorld1Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cetelem.ru/", name = "helloWorld1Response")
    public JAXBElement<HelloWorld1Response> createHelloWorld1Response(HelloWorld1Response value) {
        return new JAXBElement<HelloWorld1Response>(_HelloWorld1Response_QNAME, HelloWorld1Response.class, null, value);
    }

}

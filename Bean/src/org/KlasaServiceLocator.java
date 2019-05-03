/**
 * KlasaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org;

public class KlasaServiceLocator extends org.apache.axis.client.Service implements org.KlasaService {

    public KlasaServiceLocator() {
    }


    public KlasaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public KlasaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Klasa
    private java.lang.String Klasa_address = "http://localhost:8080/Server/services/Klasa";

    public java.lang.String getKlasaAddress() {
        return Klasa_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String KlasaWSDDServiceName = "Klasa";

    public java.lang.String getKlasaWSDDServiceName() {
        return KlasaWSDDServiceName;
    }

    public void setKlasaWSDDServiceName(java.lang.String name) {
        KlasaWSDDServiceName = name;
    }

    public org.Klasa getKlasa() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Klasa_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getKlasa(endpoint);
    }

    public org.Klasa getKlasa(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.KlasaSoapBindingStub _stub = new org.KlasaSoapBindingStub(portAddress, this);
            _stub.setPortName(getKlasaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setKlasaEndpointAddress(java.lang.String address) {
        Klasa_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.Klasa.class.isAssignableFrom(serviceEndpointInterface)) {
                org.KlasaSoapBindingStub _stub = new org.KlasaSoapBindingStub(new java.net.URL(Klasa_address), this);
                _stub.setPortName(getKlasaWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Klasa".equals(inputPortName)) {
            return getKlasa();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://org", "KlasaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://org", "Klasa"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Klasa".equals(portName)) {
            setKlasaEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

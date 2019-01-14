/**
 * UploadServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package projekt_plichta_jee_srvr;

public class UploadServiceLocator extends org.apache.axis.client.Service implements projekt_plichta_jee_srvr.UploadService {

    public UploadServiceLocator() {
    }


    public UploadServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UploadServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Upload
    private java.lang.String Upload_address = "http://localhost:8080/projekt_plichta_jee_srvr/services/Upload";

    public java.lang.String getUploadAddress() {
        return Upload_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UploadWSDDServiceName = "Upload";

    public java.lang.String getUploadWSDDServiceName() {
        return UploadWSDDServiceName;
    }

    public void setUploadWSDDServiceName(java.lang.String name) {
        UploadWSDDServiceName = name;
    }

    public projekt_plichta_jee_srvr.Upload getUpload() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Upload_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUpload(endpoint);
    }

    public projekt_plichta_jee_srvr.Upload getUpload(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            projekt_plichta_jee_srvr.UploadSoapBindingStub _stub = new projekt_plichta_jee_srvr.UploadSoapBindingStub(portAddress, this);
            _stub.setPortName(getUploadWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUploadEndpointAddress(java.lang.String address) {
        Upload_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (projekt_plichta_jee_srvr.Upload.class.isAssignableFrom(serviceEndpointInterface)) {
                projekt_plichta_jee_srvr.UploadSoapBindingStub _stub = new projekt_plichta_jee_srvr.UploadSoapBindingStub(new java.net.URL(Upload_address), this);
                _stub.setPortName(getUploadWSDDServiceName());
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
        if ("Upload".equals(inputPortName)) {
            return getUpload();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://projekt_plichta_jee_srvr", "UploadService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://projekt_plichta_jee_srvr", "Upload"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Upload".equals(portName)) {
            setUploadEndpointAddress(address);
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

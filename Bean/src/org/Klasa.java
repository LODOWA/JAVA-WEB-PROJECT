/**
 * Klasa.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org;

public interface Klasa extends java.rmi.Remote {
    public java.lang.String image(java.lang.String base64String) throws java.rmi.RemoteException;
    public java.lang.String getAllFilles(int n) throws java.rmi.RemoteException;
    public java.lang.Object decodeToImage(java.lang.String imageString) throws java.rmi.RemoteException;
}

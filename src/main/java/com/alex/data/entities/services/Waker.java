package com.alex.data.entities.services;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.List;

public class Waker {

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    private String IP;
    private String MACADDR;

    public String getMACADDR() {
        return MACADDR;
    }

    public void setMACADDR(String MACADDR) {
        this.MACADDR = MACADDR;
    }



    @Override
    public String toString() {
        return "Waker{" +
                "IP='" + IP + '\'' +
                ", MACADDR='" + MACADDR + '\'' +
                '}';
    }
    public void doWakeOnLan() throws Exception{
        // Modify Following 3 Informations.
        // Broadcast IP address
        //String IP = "134.249.219.127";

        //final String MACADDR = "D4-3D-7E-31-D0-7A";
        final int port = 9;
        //List<String> lines;


        if(!IP.equals("")) {
            try {

                final byte[] MACBYTE = new byte[6];
                final String[] hex = MACADDR.split("(\\:|\\-)");

                for (int i = 0; i < 6; i++) {
                    MACBYTE[i] = (byte) Integer.parseInt(hex[i], 16);
                }

                final byte[] bytes = new byte[6 + 16 * MACBYTE.length];
                for (int i = 0; i < 6; i++) {
                    bytes[i] = (byte) 0xff;
                }
                for (int i = 6; i < bytes.length; i += MACBYTE.length) {
                    System.arraycopy(MACBYTE, 0, bytes, i, MACBYTE.length);
                }

                // Send UDP packet here
                final InetAddress address = InetAddress.getByName(IP);
                final DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                        address, port);
                final DatagramSocket socket = new DatagramSocket();
                socket.send(packet);
                socket.close();

                System.out.println(" Sent!.");
            } catch (final Exception e) {
                System.out.println("Failed " + e);
            }

        }

        System.out.println(IP);
    }
}

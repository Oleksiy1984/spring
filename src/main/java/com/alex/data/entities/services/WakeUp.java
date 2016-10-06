package com.alex.data.entities.services;

import java.util.List;

public class WakeUp {

    private List<String> availableMacAddrs;
    private String ipAddr;
    private String selectedMac = null;
    private Waker wkr;


    public void init(){
        //ipAddr = "255.255.255.255";
        wkr = new Waker();
        //availableMacAddrs = wkr.getArpMacs();
    }

    public void setIpAddress(String address){
        this.ipAddr = address;
    }

    public void setMacAddress(String address){
        this.selectedMac = address;
    }

    public List<String> getMacAddresses(){
        return availableMacAddrs;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getSelectedMac() {
        return selectedMac;
    }

    public String doWakeUp(){
        String result = "failure";
        try {
            wkr.doWakeOnLan();
            result = "success";
        } catch (Exception we) {
        }
        return result;
    }
}

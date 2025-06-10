package org.lld.structuralPattern.Proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Internet{
    void connectTo(String site) throws Exception;
}

class RealInternet implements Internet{
    @Override
    public void connectTo(String site){
        System.out.println("Connecting to " + site);
    }
}

class ProxyInternet implements Internet{
    private RealInternet realInternet = new RealInternet();
    public static List<String> bannedSites = Arrays.asList("facebook.com" , "youtube.com");

    @Override
    public void connectTo(String site) throws Exception {
        if(bannedSites.contains(site)){
            throw new Exception("Access denied to " + site);
        }
        realInternet.connectTo(site);
    }
}
public class SiteProxy {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try{
            internet.connectTo("google.com");
            internet.connectTo("facebook.com");
            internet.connectTo("youtube.com");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

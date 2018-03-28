
import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyenhongphat0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeoIPService ipservice =  new GeoIPService();
        GeoIPServiceSoap geoIPServiceSoap = ipservice.getGeoIPServiceSoap();
        GeoIP geoip = geoIPServiceSoap.getGeoIP("222.255.236.148");
        System.out.println(geoip.getCountryName());
        System.out.println(geoip.getReturnCodeDetails());
    }
    
}

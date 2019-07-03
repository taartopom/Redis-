/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescomredis;

import java.util.List;
import redis.clients.jedis.Jedis;

/**
 *
 * @author Administrateur
 */
public class GescomRedis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jedis jedis =  new Jedis("localhost");
        System.out.println("connexion ok");
        
/*----------------------------------------------------------------------*/
    // manipulation des chaines
/*----------------------------------------------------------------------*/    
        jedis.set("prenom", "lisa");
        
        String value =  jedis.get("prenom");
        System.out.println(value);
/*----------------------------------------------------------------------*/
    // manipulation des lites
/*----------------------------------------------------------------------*/
    //création de la liste et son initialisation   
    jedis.rpush("maListe", "premier","deuxieme", "troisieme");
    
    //parcours de la liste
    List<String> valeurList = jedis.lrange("maListe", 0, -1);
    
    for(String val :valeurList){
        System.out.println(val);
        
    }
    }
}

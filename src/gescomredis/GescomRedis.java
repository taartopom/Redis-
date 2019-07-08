/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gescomredis;

import static java.lang.reflect.Array.set;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    //jedis.rpush("maListe", "premier","deuxieme", "troisieme");
    
    //parcours de la liste
    List<String> valeurList = jedis.lrange("maListe", 0, -1);

    for(String val :valeurList){
        System.out.println(val);
    }
/*----------------------------------------------------------------------*/
       // manipulation de hash set
/*----------------------------------------------------------------------*/   
    //création du hash set
    jedis.hset("categorie", "idCat", "1");
    jedis.hset("categorie", "libelle", "DVD");
    

    // parcours du hast set
    Map<String, String> map =  jedis.hgetAll("categorie");
    
    Set listeKey =  map.keySet();
    Iterator iterator =  listeKey.iterator();
    
        while (iterator.hasNext()) {
        Object key =  iterator.next();
            System.out.println(key + " => " + map.get(key));
            
        }
        System.out.println("set " + jedis.hgetAll("categorie"));
/*----------------------------------------------------------------------*/
    // manipulation du set
/*----------------------------------------------------------------------*/
    //Création des set
    jedis.sadd("livre", "Tintin","Durant", "Milou");
    jedis.sadd("BD","delise","mening","bart");
    
    //parcours des set
    Set<String> valueLivre =  jedis.smembers("livre");
    Iterator<String> itLivre =  valueLivre.iterator();
        while(itLivre.hasNext()){
            String nom = itLivre.next();
            // affichage des valeurs
            System.out.println("value : " + nom);
        }
        // affichage de toutes les valeurs du set
        System.out.println("Toutes les valeurs : " + jedis.smembers("livre"));

    }

}

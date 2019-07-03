/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import redis.clients.jedis.Jedis;

/**
 *
 * @author Administrateur
 */
public class Connexion {
        Jedis jedis = new Jedis("localhost");
        
}

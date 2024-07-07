/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2.Estructuras;

/**
 *
 * @author Buste
 */
class HashNodo<K, V> {
    K key;
    V value;

    HashNodo<K, V> next;

    public HashNodo(K key, V value, int hashCode)
    {
        this(key, value);
    }

    
    public HashNodo(String key, String value) {
        this.key = (K) key;
        this.value = (V) value;
    }

    private HashNodo(K key, V value) {
    }

  
    }
    
    



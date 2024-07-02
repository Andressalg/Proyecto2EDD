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

    // Reference to next node
    HashNodo<K, V> next;

    // Constructor
    public HashNodo(K key, V value, int hashCode)
    {
        this(key, value);
    }

    // Constructor
    public HashNodo(String key, String value) {
        this.key = (K) key;
        this.value = (V) value;
    }

    private HashNodo(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}


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
      final int hashCode;

    // Reference to next node
    HashNodo<K, V> next;

    // Constructor
    public HashNodo(K key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
          this.hashCode = hashCode;
    }
}

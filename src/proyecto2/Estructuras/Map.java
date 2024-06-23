/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package proyecto2.Estructuras;
import java.util.Objects;


/**
 *
 * @author Buste
 */
class Map<K, V> {
    // bucketArray is used to store array of chains
    private Lista<HashNodo<K, V> > bucketArray;

    // Current capacity of array list
    private int numBuckets;

    // Current size of array list
    private int size;

    // Constructor (Initializes capacity, size and
    // empty chains.
    public Map()
    {
        bucketArray = new Lista<>(100000);
        numBuckets = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.addAtEnd(null);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }
    
      private int hashCode (K key) {
        return Objects.hashCode(key);
    }
  
    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key)
    {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() could be negative.
        index = index < 0 ? index * -1 : index;
        return index;
    }

    // Method to remove a given key
    public V remove(K key)
    {
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        // Get head of chain
        HashNodo<K, V> head = bucketArray.getFirst(bucketIndex);

        // Search for key in its chain
        HashNodo<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.setArray(bucketIndex, head.next);

        return head.value;
    }

    // Returns value for a key
    public V get(K key)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
          int hashCode = hashCode(key);
      
        HashNodo<K, V> head = bucketArray.get(bucketIndex);

        // Search key in chain
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode)
                return head.value;
            head = head.next;
        }

        // If key not found
        return null;
    }

    // Adds a key value pair to hash
    public void add(K key, V value)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
          int hashCode = hashCode(key);
        HashNodo<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        HashNodo<K, V> newNode;
        newNode = new HashNodo<>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0 * size) / numBuckets >= 0.7) {
            Lista<HashNodo<K, V> > temp = bucketArray;
            bucketArray = new Lista<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (HashNodo<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
    }

package com.mw.concurrency.custom;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MwHashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>
{
    // Need Node implementation, To represent entry.
    class Node<K, V> implements Map.Entry<K, V>
    {
        K key;
        V value;
        int hash; // We need the has value
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next)
        {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public final int hashCode()
        {
            return Objects.hashCode(key) ^ Objects.hashCode(value); // rehash.
        }

        @Override
        public K getKey()
        {
            return key;
        }

        @Override
        public V getValue()
        {
            return value;
        }

        @Override
        public V setValue(V value)
        {
            this.value = value;
            return value;
        }

        public final String toString() { return key + "=" + value; }

        public boolean equals(Object o)
        {
            // check reference
            if (o == this)
                return true;

            if (o instanceof Map.Entry)
            {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
               if (Objects.equals(key, e.getKey()) &&
                   Objects.equals(value, e.getValue()))
                   return true;
            }

            return false;
        }
    }

    Node<K,V>[] table; // we need a table to store node.

    static final int hash(Object key)
    {
        int high = 0;
        if (key == null)
            return 0;
        else
        {
            high = key.hashCode() >>> 16; // move 16 bits to get the higher bits.
            return key.hashCode() ^ high;
        }
    }

    // Need have a set of entry.

    @Override
    public Set<Entry<K, V>> entrySet()
    {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue)
    {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action)
    {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
    {

    }

    @Override
    public V putIfAbsent(K key, V value)
    {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value)
    {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue)
    {
        return false;
    }

    @Override
    public V replace(K key, V value)
    {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction)
    {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
    {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction)
    {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
    {
        return null;
    }
}
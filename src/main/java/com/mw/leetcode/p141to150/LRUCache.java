package com.mw.leetcode.p141to150;

import java.util.HashMap;
import java.util.Map;

/**
 * The key to implement a LRU Cache is to invalidate the most unused item. So we need to maintain a double linked list (node) and hashMap.
 */
public class LRUCache
{
    private int capacity;
    private Node head;
    private Node end;
    private Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
    }

    public int get(int key)
    {
        // Check if it exists.
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        // set head.
        remove(node); // we need to take care of node.prev.next and node.next.prev
        setHead(node);
        return node.value;
    }

    public void set(int key, int value)
    {
        if (!map.containsKey(key))
        {
            Node node = new Node(key, value);
            if(map.size() >= capacity)
            {
                map.remove(end.key);
                remove(end);
                setHead(node);
            }
            else
                setHead(node);

            map.put(key, node);
        }
        else
        {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        }
    }

    private void remove(Node node)
    {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next; // node is current the head; but in order to comply with the setHead, we set the next node as dummy head.

        if (node.next != null)
            node.next.prev = node.prev;
        else
            end = node.prev;  // node is currently the end; we need to set new end.
    }

    private void setHead(Node node)
    {
        if (head != null)
            head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;

        if(end == null)
            end = head; // try to init end.
    }

    class Node
    {
        public Node prev;
        public Node next;
        public int key;
        public int value;

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
}

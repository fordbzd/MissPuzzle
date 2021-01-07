package org.misspuzzle.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private int capacity;
	private int size;
	
	private Map<Integer, DLNode> map;
	
	private DLNode head;
	private DLNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        size = 0;
        map = new HashMap<Integer, DLNode>();
    }
    
    public int get(int key) {
        
    	DLNode node = map.get(key);
    	
    	if (node == null) {
    		return -1;
    	}
    	
    	if (node != head) {
    		if (node == tail) {
    			tail = node.pre;
    		} else {
    			node.next.pre = node.pre;
    		}
    		
    		node.pre.next = node.next;
    		
    		if (node.pre == head) {
    			node.pre.pre = node;
    		}
    		
    		node.next = head;
    		head.pre = node;
    		node.pre = null;
    		
    		head = node;
    	}
    	
    	return node.value;
    }
    
    public void put(int key, int value) {
    	DLNode node = map.get(key);
    	
    	if (node != null) {
    		node.value = value;
    		get(key);
    	} else {
    		node = new DLNode(key, value);
    	
    		map.put(key, node);
    		
    		if (size == capacity) {
    			map.put(tail.key, null);
    			
    			if (head == tail) {
    				head = tail = null;
    			} else {
					tail = tail.pre;
					tail.next.pre = null;
					tail.next = null;
				}
    			
    			size--;
    		} 

			if (size == 0) {
				head = tail = node;
			} else {
				node.next = head;
				head.pre = node;
				
				head = node;
			}
			
			size++;
    	}

    }
    
    static class DLNode {
    	int key;
    	int value;
    	DLNode pre;
    	DLNode next;
    	
    	DLNode(int key, int value) {
    		this.key = key;
    		this.value = value;
    	}
    	
    	public String toString() {
    		DLNode node = this;
    		String result = "";
    		
    		while (node != null) {
    			result += node.key + "->";
    			node = node.next;
    		}
    		
    		return result + "END";
    	}
    	
    	public String toReverseString() {
    		DLNode node = this;
    		String result = "";
    		
    		while (node != null) {
    			result += node.key + "->";
    			node = node.pre;
    		}
    		
    		return result + "HEAD";
    	}
    }
}
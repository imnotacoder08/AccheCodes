class MyCircularDeque {
    private class ListNode {
		private int val;
		private ListNode next;
		private ListNode prev;

		public ListNode(int val) {
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}
    private int capacity;
    private int currentSize;
	private ListNode head = null;
	private ListNode tail = null;
    
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.currentSize = 0;
		this.head = new ListNode(Integer.MIN_VALUE);
		this.tail = new ListNode(Integer.MIN_VALUE);
		this.head.next = tail;
		this.tail.prev = head;
    }
    
    private void addToTail(ListNode node) {
		node.next = this.tail;
		this.tail.prev.next = node;
		node.prev = this.tail.prev;
		this.tail.prev = node;
	}
    
    private void addToHead(ListNode node) {
		node.next = this.head.next;
		node.prev = this.head;
        this.head.next.prev = node;
		this.head.next = node;
	}
    
    private void removeFromLinkedList(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
    
    public boolean insertFront(int value) {
        if(this.currentSize < this.capacity){
            ListNode node = new ListNode(value);
            addToHead(node);
            this.currentSize++;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if(this.currentSize < this.capacity){
            ListNode node = new ListNode(value);
            addToTail(node);
            this.currentSize++;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if(this.currentSize > 0){
            removeFromLinkedList(this.head.next);
            this.currentSize--;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if(this.currentSize > 0){
            removeFromLinkedList(this.tail.prev);
            this.currentSize--;
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if(this.currentSize > 0){
            return this.head.next.val;
        }
        return -1;
    }
    
    public int getRear() {
        if(this.currentSize > 0){
            return this.tail.prev.val;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if(this.currentSize == 0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(this.currentSize == this.capacity){
            return true;
        }
        return false;
    }
}
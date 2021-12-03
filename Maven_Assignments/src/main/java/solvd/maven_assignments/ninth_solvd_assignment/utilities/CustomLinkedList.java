package ninth_solvd_assignment.utilities;

public class CustomLinkedList<E> {
	class Node {
		E data;
		Node next;

		Node(E data) {
			this.data = data;
		}
	}

	private Node head;
	private int length = 0, pointer = 0;

	// ADD ELEMENT TO THE END OF THE LIST
	public void insert(E data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}

		length++;
	}

	// ADDING ELEMENT TO THE START OF THE LIST
	public void insertAtStart(E data) {
		Node newNode = new Node(data);

		newNode.next = head;
		head = newNode;

		length++;
	}

	// ADD ELEMENT AT GIVEN INDEX
	public void insertAt(int index, E data) {
		if (index == 0) {
			insertAtStart(data);
		} else {
			Node newNode = new Node(data);

			Node currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}

		length++;
	}

	// PUSH POINTER FORWARD
	public boolean forwardPointer() {
		if (this.pointer + 1 < this.length) {
			pointer++;
			return true;
		} else {
			return false;
		}
	}

	// RETRIEVE CURRENT POINTER DATA
	public E currentPointer() {
		if (pointer == 0) {
			return head.data;
		} else {
			Node result = this.head;
			for (int index = 0; index < this.pointer; index++) {
				result = result.next;
			}
			return result.data;
		}
	}

	// PUSH POINTER BACK
	public boolean backwardPointer() {
		if (pointer > 0) {
			this.pointer--;
			return true;
		} else {
			return false;
		}
	}

	// DELETE ELEMENT AT THE POINTER
	public void deleteAtPointer() {
		if (pointer == 0) {
			head = head.next;
			this.length--;
		} else {
			Node currentNode = this.head;
			for (int index = 0; index < this.pointer - 1; index++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;

			this.length--;
		}
	}

	// DELETE ELEMENT AT GIVEN INDEX
	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}

		length--;
	}

	// FUNCTION TO DISPLAY CONTENTS
	public String show() {
		Node currentNode = head;
		if (currentNode == null) {
			return "There's nothing here!";
		} else {
			StringBuilder positions = new StringBuilder();
			for (int index = 1; currentNode != null; index++) {
				positions.append(index + ": " + currentNode.data + System.lineSeparator());
				currentNode = currentNode.next;
			}
			return positions.toString();
		}
	}

	public int getLength() {
		return this.length;
	}
}

package List;

public class SLinkedList<E> {
	protected Node<E> head; // nodo cabeca da lista
	protected Node<E> tail; // nodo cauda da lista
	protected int size; // numero de nodos da lista

	public SLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public Node<E> getFirst() throws UnderflowException {
		if (isEmpty())
			return null;
		return head;
	}

	public Node<E> getLast() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return tail;
	}

	public void addFirst(E element) {
		Node<E> novoNodo = new Node<E>(element);
		novoNodo.setNext(head);
		head = novoNodo;
		size++;
		if (size == 1)
			tail = head;
	}

	public void addLast(E element) {
		if (isEmpty())
			addFirst(element);
		else {
			Node<E> novoNodo = new Node<E>(element);
			novoNodo.setNext(null);
			tail.setNext(novoNodo);
			tail = novoNodo;
			size++;
		}
	}

	public E removeFirst() throws UnderflowException {
		if (isEmpty())
			return null;
		Node<E> removedItem = head;
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
		}
		size--;
		return removedItem.getElement();
	}

	public E removeLast() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		Node<E> removedItem = tail;
		if (head == tail) {
			head = tail = null;
		} else {
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			tail = current;
			current.setNext(null);
		}
		size--;
		return removedItem.getElement();
	}

	public void addAfter(E el, int pos) throws IndexOutOfBoundsException {
		if (pos >= size || pos < 0)
			throw new IndexOutOfBoundsException();
		if (pos == size - 1)
			addLast(el);
		else {
			Node<E> n = new Node<E>(el);
			int posAtual = 0;
			Node<E> current = head;
			while (posAtual < pos) {
				current = current.getNext();
				posAtual++;
			}
			n.setNext(current.getNext());
			current.setNext(n);
			size++;
		}
	}

	public void addBefore(E el, int pos) throws IndexOutOfBoundsException {
		if (pos >= size || pos < 0)
			throw new IndexOutOfBoundsException();
		if (pos == 0)
			addFirst(el);
		else {
			int posAtual = 0;
			Node<E> current = head;
			Node<E> previous = null;
			Node<E> n = new Node<E>(el);
			while (posAtual < pos) {
				previous = current;
				current = current.getNext();
				posAtual++;
			}
			n.setNext(current);
			previous.setNext(n);
			size++;
		}
	}

	public String toString() {
		String str = "";
		if (isEmpty()) {
			return "Empty list";
		} else {
			str += "List:\n";
			Node<E> current = head;
			while (current != null) {
				str += current.getElement().toString() + "\n";
				current = current.getNext();
			}
			str += "\n";
		}
		return str;
	}

	public int size() {
		return size;
	}

}
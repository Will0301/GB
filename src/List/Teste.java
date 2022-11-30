package List;

public class Teste {
	public static void main(String args[]) {

		SLinkedList<Pessoa> list = new SLinkedList<Pessoa>();

		list.addFirst(new Pessoa("João", 10));
		list.addFirst(new Pessoa("Carlos", 30));
		list.addBefore(new Pessoa("Luisa", 40), 1); // antes do João...
		list.addLast(new Pessoa("Maria", 50));

		System.out.println(list.toString());

		try {
			list.removeFirst();
		} catch (UnderflowException e) {
			System.out.println("Nao foi possivel remover: lista vazia!");
		}

		System.out.println(list.toString());

		try {
			list.removeLast();
		} catch (UnderflowException e) {
			System.out.println("Nao foi possivel remover: lista vazia!");
		}

		System.out.println(list.toString());
		
		try {
			System.out.println("head = " + list.getFirst().getElement());
		} catch (UnderflowException e) {
			System.out.println("Ninguem para mostrar: lista vazia!");
		}
		
		System.out.println("Lista com " + list.size() + " elementos.");
	}

}
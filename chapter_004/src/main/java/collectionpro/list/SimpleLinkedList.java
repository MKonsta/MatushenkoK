
package collectionpro.list;

/**
 *5.3.0 Создать метод delete для односвязного списка [#51424]
 * В этом задании необходимо реализовать метод delete для односвязного списка.
 */

/**
 * Класс SimpleLinkedList.
 */
public class SimpleLinkedList<E> {

    private int size;
    private Node<E> first;

/**
 * Метод вставляет в начало списка данные.
 */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

/**
 * Реализовать метод удаления первого элемент в списке.
 */
    public E delete() {
        first = first.next;
        size--;
        return null;
    }

/**
 * Метод получения элемента по индексу.
 */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

/**
 * Метод получения размера коллекции.
 */
    public int getSize() {
        return this.size;
    }

/**
 * Класс предназначен для хранения данных.
 */
    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}

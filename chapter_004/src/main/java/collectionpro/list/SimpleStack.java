package collectionpro.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack. [#160]
 * Очередь типа - Последний зашел, первый вышел
 * @param <T>
 */
public class SimpleStack<T> implements Iterable<T> {

    /**
     * Счетчик, показывает количество добавленных элементов
     */
    private int size;

    /**
     * Первый узел (элемент) связанного списка
     */
    private Node<T> head;

    /**
     * Метод для добавления элементов в конец списка
     * @param value
     */
    public void push(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<>(value));
        }
        size++;
    }

    /**
     * Метод возвращает последний элемент из списка, и удаляет его из списка
     * @return
     */
    public T pull() {
        Node<T> res;
        Node<T> temp = head;
        if (head.getNext() == null) {
            res = head;
            head = null;
        } else {
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            res = temp.getNext();
            temp.setNext(null);
        }
        size--;
        return res.getDate();
    }


    /**
     * Итератор связанного списка
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int modCounter = size;
            int idx = 0;
            Node<T> temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T result;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else if (modCounter != size) {
                    throw new ConcurrentModificationException();
                }
                result = temp.getDate();
                temp = temp.getNext();
                return result;
            }
        };
    }

    /**
     * Класс для хранеия элементов
     * @param <T>
     */
    private static class Node<T> {
        /**
         * переменная хранящая данный в текущей ячейке массива
          */
        private T date;

        /**
         * переменная ссылающаяся на следующий элемент массива
         */
        private Node<T> next;

        public T getDate() {
            return date;
        }

        public void setDate(T date) {
            this.date = date;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node(T date) {
            this.date = date;
        }
    }

}

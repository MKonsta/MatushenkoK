package ru.job4j.Tracker;

        import java.util.Date;
        import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random random = new Random();

    private String generateId() {
        Date date = new Date();
        return String.valueOf(date.getTime()) + String.valueOf(random.nextInt());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public void replace(String id, Item item) {
        for (Item r : items) {
            if (r != null && r.getId().equals(id)) {
                r.setName(item.getName());
                r.setDesk(item.getDesk());
                r.setCreated(item.getCreated());
                r.setComments(item.getComments());
                break;
            }
        }
    }
    public void delete(String id) {
        Item[] temp = new Item[items.length];
        int i = 0;
        for (Item r : items) {
            if (r != null && id.equals(r.getId())) {
                r = null;
                break;
            }
        }
        for (Item r : items) {
            if (r != null) {
                temp[i] = items[i];
                i++;
            } else break;
        }
        System.arraycopy(items, i+1, temp, i, items.length-i-1);
    }

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index < this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public Item[] findByName(String key) {
        int index = 0;
        Item[] result = null;
        for (int i = 0; i < findAll().length; i++) {
            if (findAll()[i].getName().equals(key)) {
                index++;
            }
        }
        if (index > 0) {
            result = new Item[index];
            for (int i = 0; i < index; i++) {
                if (findAll()[i].getName().equals(key)) {
                    result[i] = findAll()[i];
                }
            }
        }
        return result;
    }

    public Item finfById(String id) {
        Item result = null;
        for (int index = 0; index < findAll().length; index++) {
            if (findAll()[index].getId().equals(id)) {
                result = findAll()[index];
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Tracker tracker = new Tracker();


    }
}

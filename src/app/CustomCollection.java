package app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * author: user,
 * date: 17.01.2026
 */

//Non null array
public class CustomCollection implements CollectionList {
    private String[] strArray;
    private int size;

    public CustomCollection() {
        this.size = 0;
        this.strArray = new String[size];
    }

    @Override
    public boolean add(String o) {
        if(o == null) throw new IllegalArgumentException("Require not null");

        if(size == 0) {
            strArray = new String[size + 1];
            strArray[size] = o;
            size++;
            return true;
        }

        String[] tempArray = new String[size + 1];
        for (int i = 0; i < size; i++) {
            tempArray[i] = strArray[i];
        }
        size++;
        tempArray[size - 1] = o;
        strArray = tempArray;

        return true;
    }

    @Override
    public boolean add(int index, String o) {
        if(o == null) throw new IllegalArgumentException("Require not null");

        if(index < 0 || index > size)
            throw new IllegalArgumentException(("Index: %d, Size: %d").formatted(index, size));

        String[] tempArray = new String[++size];
        for (int i = 0; i < index; i++) {
            tempArray[i] = strArray[i];
        }
        tempArray[index] = o;
        for (int i = index + 1; i < size; i++) {
            tempArray[i] = strArray[i - 1];
        }
        strArray = tempArray;

        return true;
    }

    @Override
    public boolean set(int index, String o) {
        if(o == null) throw new IllegalArgumentException("Require not null");

        strArray[index] = o;
        return true;
    }

    @Override
    public boolean delete(String o) {
        if(o == null) throw new IllegalArgumentException("Require not null");

        if(!contain(o)) return false;

        String[] tempArray = new String[size - 1];
        int idx = 0;
        boolean found = false;
        for (String s : strArray) {
            if(found || !Objects.equals(s,o)) {
                tempArray[idx] = s;
                idx++;
            }
            else{
                found = true;
            }
        }
        size--;
        strArray = tempArray;

        return true;
    }
    @Override
    public boolean deleteAll(String o) {
        if(!contain(o)) return false;

        int count = 0;
        for (String s : strArray) {
            if(Objects.equals(s,o)){
                count++;
            }
        }

        String[] tempArray = new String[size - count];
        int idx = 0;
        for (String s : strArray) {
            if(!Objects.equals(s,o)){
                tempArray[idx] = s;
                idx++;
            }
        }
        size -= count;
        strArray = tempArray;

        return true;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public String get(int index) {
        if(index < 0 || index >= size) throw new IllegalArgumentException("Can`t get str by index " + index);

        return strArray[index];
    }

    @Override
    public boolean contain(String o) {
        if(o == null) throw new IllegalArgumentException("Require not null");

        for (String s : strArray) {
            if(Objects.equals(s, o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Collection<String> collection) {
        if(collection == null) return false;

        return collection.size() == this.size
                && Arrays.equals(collection.toArray(), strArray);
    }

    @Override
    public boolean clear() {
        size = 0;
        strArray = new String[size];
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append("[");
        for (int i = 0; i < size(); i++) {
            if(i != 0){
                sb.append(", ");
            }
            sb.append(strArray[i]);
        }
        sb.append("]");

        return sb.toString();
    }
}

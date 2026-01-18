package app;

import java.util.Collection;

/**
 * author: user,
 * date: 17.01.2026
 */
public interface CollectionList {
    boolean add(String o);
    boolean add(int index, String o);
    boolean set(int index, String o);
    boolean delete(String o);
    boolean deleteAll(String o); //Added extra
    boolean isEmpty(); //Added extra
    String get(int index);
    boolean contain(String o);
    boolean equals (Collection<String> collection);
    boolean clear();
    int size();
}
package service;

public interface Generals<T> {
    void add();
    void save(T t);

    void getAll();

    void update();

    void delete();
    T getById(int id);
}

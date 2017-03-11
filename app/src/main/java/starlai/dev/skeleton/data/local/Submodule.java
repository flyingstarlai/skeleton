package starlai.dev.skeleton.data.local;

/**
 * Created by izayoi on 3/8/17.
 */

public class Submodule {
    public long id;
    public String name;
    public String storage;
    public int capacity;


    public Submodule(long id, String name, String storage, int capacity) {
        this.id = id;
        this.name = name;
        this.storage = storage;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

package ru.aston;

public interface AuthorHolder {

    default String getAuthor() {
        return "The author of this collection: Nail Fakhrtdinov";
    }
}

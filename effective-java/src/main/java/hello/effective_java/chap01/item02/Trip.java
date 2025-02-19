package hello.effective_java.chap01.item02;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Trip {

    public enum Item{
        Wallet, Phone, Bag, Hat, Map, Book
    }

    final Set<Item> items;

    abstract static class Builder<T extends  Builder<T>>{ //재귀적 타입 매개변수
        EnumSet<Item> items = EnumSet.noneOf(Item.class);

        public T addItem(Item item){
            items.add(Objects.requireNonNull(item));
            return self();
        }

        abstract Trip build();

        protected abstract T self();

    }

    Trip(Builder<?> builder){
        items = builder.items.clone();
    }
}


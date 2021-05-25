package com.example.spring_bank_project.shared.domain.event;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class EventComparator implements Comparator<Event> {
    @Override
    public int compare(Event o1, Event o2) {
        if (o1.equals(o2)) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public Comparator<Event> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<Event> thenComparing(Comparator<? super Event> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<Event> thenComparing(Function<? super Event, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Event> thenComparing(Function<? super Event, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<Event> thenComparingInt(ToIntFunction<? super Event> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<Event> thenComparingLong(ToLongFunction<? super Event> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<Event> thenComparingDouble(ToDoubleFunction<? super Event> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}

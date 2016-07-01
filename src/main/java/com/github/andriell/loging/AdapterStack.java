package com.github.andriell.loging;

import com.github.andriell.collection.StackString;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Этот аппендер пикает PC-спикером и выводит на консоль сообщение.
 */
public class AdapterStack extends AppenderSkeleton {
    private static AdapterStack[] adapters = new AdapterStack[16];
    private StackString stack = new StackString(10000);

    public static AdapterStack getAdapter(int i) {
        return adapters[i];
    }

    public void setAdapterId(int id) {
        adapters[id] = this;
    }

    /**
     * Пикаем и выводим сообщение.
     * @param event отсюда берётся сообщение.
     */
    @Override
    protected void append(LoggingEvent event) {
        stack.put(event.categoryName);
        stack.put(" ");
        stack.put(event.level.toString());
        stack.put(" ");
        stack.put(event.getRenderedMessage());
        stack.put("\n");
    }

    /**
     * ресурсы не выделялись - закрывать ничего не надо.
     */
    public void close() {

    }

    /**
     * Layout не используется.
     */
    public boolean requiresLayout() {
        return false;
    }

    public StackString getStack() {
        return stack;
    }
}
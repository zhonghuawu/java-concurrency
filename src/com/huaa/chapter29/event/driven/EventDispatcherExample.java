package com.huaa.chapter29.event.driven;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/21 14:25
 */
public class EventDispatcherExample {

    public static class InputEvent extends Event {
        private final int x;
        private final int y;

        public InputEvent(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class ResultEvent extends Event {

        private final int result;

        public ResultEvent(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

    }

    static class ResultEventHanlder implements Channel<ResultEvent> {
        @Override
        public void dispatch(ResultEvent message) {
            System.out.println("The result is: " + message.getResult());
        }
    }

    static class InputEventHanlder implements Channel<InputEvent> {
        private final EventDispatcher dispatcher;

        public InputEventHanlder(EventDispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }


        @Override
        public void dispatch(InputEvent message) {
            System.out.printf("X:%d,Y:%d\n", message.getX(), message.getY());
            int result = message.getX() + message.getY();
            dispatcher.dispatch(new ResultEvent(result));
        }
    }

    public static void main(String[] args) {
        EventDispatcher dispatcher = new EventDispatcher();
        dispatcher.registerChannel(InputEvent.class, new InputEventHanlder(dispatcher));
        dispatcher.registerChannel(ResultEvent.class, new ResultEventHanlder());
        dispatcher.dispatch(new InputEvent(1, 2));
    }

}

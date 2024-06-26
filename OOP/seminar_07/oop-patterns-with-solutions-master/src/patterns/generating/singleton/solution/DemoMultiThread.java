package patterns.generating.singleton.solution;

public class DemoMultiThread {
    public static void main(String[] args) {

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();

//        Thread threadFoo1 = new Thread(new ThreadFoo1());
//        Thread threadBar1 = new Thread(new ThreadBar1());
//        threadFoo1.start();
//        threadBar1.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            DB singleton = DB.getInstance("FOO");
            System.out.println(singleton.getPathToDB());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            DB singleton = DB.getInstance("BAR");
            System.out.println(singleton.getPathToDB());
        }
    }

    static class ThreadFoo1 implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar1 implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}

package ALDS1_3_B;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String[] line = new String[n];
        Queue tasks = new Queue();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            line[i] = in.nextLine();
            tasks.enqueue(new Task(line[i].split(" ")[0], Integer.parseInt(line[i].split(" ")[1])));
        }
        int costTime = 0;
        int totalTime = 0;
        while (tasks.head != tasks.tail) {
            Task current = tasks.dequeue();
            costTime = Math.min(q, current.time);
            current.time -= costTime; // 计算剩余的所需时间
            totalTime += costTime; // 累计已经过的时间
            if(current.time > 0) {
                tasks.enqueue(current);
            }
            else {
                System.out.println(current.name + " " + totalTime);
            }
        }
    }
}

class Task {
    public String name;
    public int time;

    public Task(String name, int time) {
        this.name = name;
        this.time = time;
    }
}
/*
* Java不支持泛型数组
* 原因就是Java的泛型是通过类型擦除(type erasure)来实现的。什么是类型擦除呢，简单来说Java在编译期间，所有的泛型信息都会被擦除掉。
* 如在代码中定义的List<object>和List<String>等类型，在编译后都会变成List。
*
* List<String> strList = new ArrayList<String>();
* List<Object> objList = new ArrayList<Object>();
* List rawList = new ArrayList();

* 比如上面3个List，擦除类型参数以后，List中的实际元素都是Object。JVM看到的只是List，而由泛型附加的类型信息对JVM来说是不可见的。

* Java编译器会在编译时尽可能的发现可能出错的地方，但是仍然无法避免在运行时刻出现类型转换异常的情况。所以由于类型擦除的原因，Java是禁止直接创建泛型数组实例的。
* */
class Queue {
    public int head;
    public int tail;
    private Task[] queue;
    private int len = 1000001;

    public Queue() {
        this.head = this.tail = 0;
        this.queue = new Task[this.len];
    }

    public boolean isFull() {
        return (this.head == (this.tail + 1) % (this.len));
    }

    public boolean isEmpty() {
        return (this.head == this.tail);
    }

    public void enqueue(Task task) throws Exception {
        if (isFull()) {
            throw (new Exception("上溢出"));
        }
        this.queue[this.tail] = task;
        if (this.tail + 1 == this.len) {
            this.tail = 0;
        } else {
            this.tail++;
        }
    }

    public Task dequeue() throws Exception {
        if (isEmpty()) {
            throw (new Exception("下溢出"));
        }
        Task task = this.queue[this.head];
        if (this.head + 1 == this.len) {
            this.head = 0;
        } else {
            this.head++;
        }
        return task;
    }
}
import java.util.Scanner;
public class kalkulator {
    private static Sequence<Stack<String>>sekvenca = new ArrayDeque<>();
    private static boolean pogoj = false;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws CollectionException {
        for (int i = 0; i<42; i++) {
            sekvenca = addStack(sekvenca);
        }
        int stevec =0;
        int stevilo = 0;
        int b =0;
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextLine()){
            stevec =0;
            stevilo = 0;
            b =0;
        String ukaz = sc.nextLine();
        String [] besede = ukaz.split(" ");
        for (int i = 0; i< besede.length; i++) {
            if (besede[i].equals("")){
                continue;
            }
            if (besede[i].equals("fun")) {
                stevec = Integer.parseInt(sekvenca.get(0).pop());
                stevilo = Integer.parseInt(sekvenca.get(0).pop());
                b++;
                continue;
            } else if (b <= stevilo && b != 0) {
                sekvenca.get(stevec).push(besede[i]);
                b++;
            } else {
                ukazi(besede[i]);
                b=0;
            }
        }
        reset(sekvenca);
        }
    }
    public static void ukazi(String beseda) throws CollectionException {
        if(beseda.charAt(0)=='?' && pogoj) {
            beseda = remove(beseda);
            izvediUkaz(beseda);
        }
        else if(beseda.charAt(0)=='?' && !pogoj){
            beseda = "";
        }
        else{
            izvediUkaz(beseda);
        }
    }
    public static void izvediUkaz(String beseda) throws CollectionException {
        switch (beseda) {
            case "+":
                addition(sekvenca);
                break;
            case "/":
                division(sekvenca);
                break;
            case "%":
                mod(sekvenca);
                break;
            case "-":
                substitution(sekvenca);
                break;
            case "*":
                multiply(sekvenca);
                break;
            case "print":
                izpis(sekvenca);
                break;
            case "echo":
                echo(sekvenca.get(0));
                break;
            case "!":
                factorial(sekvenca);
                break;
            case "rnd":
                rnd(sekvenca);
                break;
            case "char":
                ch(sekvenca);
                break;
            case "dup":
                dup(sekvenca);
                break;
            case "dup2":
                dup2(sekvenca);
                break;
            case "even":
                even(sekvenca);
                break;
            case "odd":
                odd(sekvenca);
                break;
            case "pop":
                if(!sekvenca.get(0).isEmpty()){
                sekvenca.get(0).pop();}
                break;
            case "len":
                len(sekvenca);
                break;
            case "swap":
                swap(sekvenca);
                break;
            case "<>":
                notSame(sekvenca);
                break;
            case "<":
                manjse(sekvenca);
                break;
            case ">":
                vecje(sekvenca);
                break;
            case ">=":
                leq(sekvenca);
                break;
            case "<=":
                seq(sekvenca);
                break;
            case "==":
                eq(sekvenca);
                break;
            case ".":
                zlepi(sekvenca);
                break;
            case "reverse":
                reverse(sekvenca);
                break;
            case "clear":
                clear(sekvenca);
                break;
            case "move":
                move(sekvenca);
                break;
            case "run":
                run(sekvenca);
                break;
            case "loop":
                loop(sekvenca);
                break;
            case "then":
                then(sekvenca);
                break;
            case "else":
                zanikaj();
                break;
            default:
                sekvenca.get(0).push(beseda);
                break;
        }
    }
    public static void then(Sequence<Stack<String>> sekvenca) throws CollectionException {
        int a =0;
        if (!sekvenca.get(0).isEmpty()) {
            a = Integer.parseInt(sekvenca.get(0).pop());
            if (a != 0) {
                pogoj = true;
            } else {
                pogoj = false;
            }
        }
    }
    public static void zanikaj(){
        if (pogoj){
            pogoj=false;
        }
        else{
            pogoj=true;
        }
    }
    public static void loop(Sequence<Stack<String>> sekvenca) throws CollectionException {
        int a = Integer.parseInt(sekvenca.get(0).pop());
        int b = Integer.parseInt(sekvenca.get(0).pop());
        for(int j = 1; j<=b; j++){
            sekvenca.get(0).push(String.valueOf(a));
            run(sekvenca);
        }
    }
    public static void len(Sequence<Stack<String>> sekvenca) throws CollectionException {
        String a = sekvenca.get(0).pop();
        sekvenca.get(0).push(String.valueOf(a.length()));
    }
    public static String remove(String beseda){
        return beseda.substring(1);
    }
    public static void run(Sequence<Stack<String>> sekvenca) throws CollectionException {
        int a = Integer.parseInt(sekvenca.get(0).pop());
        if(!sekvenca.get(a).isEmpty()) {
            Stack<String> s = new ArrayDeque<>();
            while (!sekvenca.get(a).isEmpty()) {
                s.push(sekvenca.get(a).pop());
            }
            while (!s.isEmpty()) {
                sekvenca.get(a).push(s.top());
                ukazi(s.pop());
            }
        }
    }
    public static void move(Sequence<Stack<String>> sekvenca) throws CollectionException {
        int a = 0;
        int b =0;
        if(!sekvenca.get(0).isEmpty()){
         a = Integer.parseInt(sekvenca.get(0).pop());}
        if(!sekvenca.get(0).isEmpty()) {
            b = Integer.parseInt(sekvenca.get(0).pop());
            int i =a;
        }
        if(!sekvenca.get(0).isEmpty()) {
            for (int j = 1; j <= b; j++) {
                sekvenca.get(a).push(sekvenca.get(0).pop());
            }
        }
    }
    public static Sequence<Stack<String>> addStack(Sequence<Stack<String>>sekvenca) throws CollectionException {
        Stack<String>s= new ArrayDeque<>();
        sekvenca.add(s);
        return sekvenca;
    }
    public static void addition(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b="";
        String a ="";
        if(!sekvenca.get(0).isEmpty()) {
            b = sekvenca.get(0).pop();}
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();
            sekvenca.get(0).push(String.valueOf( Integer.parseInt(a)+Integer.parseInt(b)));}
    }
    public static void substitution(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b="";
        String a ="";
        if(!sekvenca.get(0).isEmpty()) {
            b = sekvenca.get(0).pop();}
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();
            sekvenca.get(0).push(String.valueOf( Integer.parseInt(a)-Integer.parseInt(b)));}
    }
    public static void multiply(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b="";
        String a ="";
        if(!sekvenca.get(0).isEmpty()) {
            b = sekvenca.get(0).pop();}
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();
           sekvenca.get(0).push( String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));
        }
    }
    public static void division(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b="";
        String a ="";
        if(!sekvenca.get(0).isEmpty()) {
            b = sekvenca.get(0).pop();}
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();
            if (Integer.parseInt(b) != 0) {
                sekvenca.get(0).push(String.valueOf(Integer.parseInt(a) / Integer.parseInt(b)));
            }
        }
    }
    public static void mod(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b="";
        String a ="";
        if(!sekvenca.get(0).isEmpty()) {
            b = sekvenca.get(0).pop();}
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();
            int r = Integer.parseInt(a) % Integer.parseInt(b);
            sekvenca.get(0).push(String.valueOf(r));
        }
    }
    public static void izpis(Sequence<Stack<String>>sekvenca) throws CollectionException {
        if(!sekvenca.get(0).isEmpty()) {
            int index = Integer.parseInt(sekvenca.get(0).pop());
            int i = 0;
            String a = "";
            String izp = "";
            Stack<String> s = new ArrayDeque<>();
            while (!sekvenca.get(index).isEmpty()) {
                if (i == 0) {
                    izp = sekvenca.get(index).top();
                    a = sekvenca.get(index).pop();
                    s.push(a);
                    i++;
                } else {
                    izp = sekvenca.get(index).top() + " " + izp;
                    a = sekvenca.get(index).pop();
                    s.push(a);
                }
            }
            while (!s.isEmpty()) {
                sekvenca.get(index).push(s.pop());
            }
            System.out.println(izp);
        }
        else{
            System.out.println("");
        }
    }
    public static void echo(Stack<String>s) throws CollectionException {
        if (!s.isEmpty()){
        System.out.println(s.top());}
        else{
            System.out.println("");
        }
    }
    public static void factorial(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String a = "";
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();
            int fact = 1;
            for (int i = 1; i <= Integer.parseInt(a); i++) {
                fact = fact * i;
            }
            sekvenca.get(0).push(String.valueOf(fact));
        }

    }
    public static void rnd(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b = "";
        if (!sekvenca.get(0).isEmpty()) {
        b =  sekvenca.get(0).pop();}
        String a ="";
        if (!sekvenca.get(0).isEmpty()) {
               a= sekvenca.get(0).pop();
        int x = (int) (Math.random() * (Integer.parseInt(b) - Integer.parseInt(a)) + Integer.parseInt(a));
        sekvenca.get(0).push( String.valueOf(x));}
    }
    public static void ch(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int c =0;
        if (!sekvenca.get(0).isEmpty()) {
            c = Integer.parseInt(sekvenca.get(0).pop());
            char d = (char) c;
            sekvenca.get(0).push(String.valueOf(d));
        }
    }
    public static void dup(Sequence<Stack<String>>sekvenca) throws CollectionException {
        if(!sekvenca.get(0).isEmpty()) {
            sekvenca.get(0).push(sekvenca.get(0).top());
        }
    }
    public static void dup2(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b="";
        String a ="";
        if(!sekvenca.get(0).isEmpty()) {
            b = sekvenca.get(0).pop();}
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();
            sekvenca.get(0).push(a);
            sekvenca.get(0).push(b);
            sekvenca.get(0).push(a);
            sekvenca.get(0).push(b);
        }
    }
    public static void even(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = Integer.parseInt(sekvenca.get(0).pop());
        if (a%2==0){
            a=1;
        }
        else{
            a=0;
        }
        sekvenca.get(0).push(String.valueOf(a));
    }
    public static void odd(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = Integer.parseInt(sekvenca.get(0).pop());
        if (a%2==0){
            a=0;
        }
        else{
            a=1;
        }
        sekvenca.get(0).push(String.valueOf(a));
    }
    public static void swap(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String b="";
        String a ="";
        if(!sekvenca.get(0).isEmpty()) {
            a = sekvenca.get(0).pop();}
        if(!sekvenca.get(0).isEmpty()) {
            b = sekvenca.get(0).pop();
            sekvenca.get(0).push(a);
            sekvenca.get(0).push(b);
        }
    }
    public static void notSame(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = Integer.parseInt(sekvenca.get(0).pop());
        int b = Integer.parseInt(sekvenca.get(0).pop());
        if (a==b){
            a=0;
        }
        else{
            a=1;
        }
        sekvenca.get(0).push(String.valueOf(a));
    }
    public static void manjse(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = Integer.parseInt(sekvenca.get(0).pop());
        int b = Integer.parseInt(sekvenca.get(0).pop());
        if (a>b){
            a=1;
        }
        else{
            a=0;
        }
        sekvenca.get(0).push(String.valueOf(a));
    }
    public static void vecje(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = Integer.parseInt(sekvenca.get(0).pop());
        int b = Integer.parseInt(sekvenca.get(0).pop());
        if (a<b){
            a=1;
        }
        else{
            a=0;
        }
        sekvenca.get(0).push(String.valueOf(a));
    }
    public static void seq(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = 0;
        int b =0;
        if(!sekvenca.get(0).isEmpty()){
            a = Integer.parseInt(sekvenca.get(0).pop());}
        if(!sekvenca.get(0).isEmpty()) {
            b = Integer.parseInt(sekvenca.get(0).pop());
            if (a >= b) {
                a = 1;
            } else {
                a = 0;
            }
            sekvenca.get(0).push(String.valueOf(a));
        }
    }
    public static void leq(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = 0;
        int b =0;
        if(!sekvenca.get(0).isEmpty()){
            a = Integer.parseInt(sekvenca.get(0).pop());}
        if(!sekvenca.get(0).isEmpty()) {
            b = Integer.parseInt(sekvenca.get(0).pop());
            if (a <= b) {
                a = 1;
            } else {
                a = 0;
            }
            sekvenca.get(0).push(String.valueOf(a));
        }
    }
    public static void eq(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int a = 0;
        int b =0;
        if(!sekvenca.get(0).isEmpty()){
            a = Integer.parseInt(sekvenca.get(0).pop());}
        if(!sekvenca.get(0).isEmpty()) {
            b = Integer.parseInt(sekvenca.get(0).pop());
            if (a == b) {
                a = 1;
            } else {
                a = 0;
            }
            sekvenca.get(0).push(String.valueOf(a));
        }
    }
    public static void zlepi(Sequence<Stack<String>>sekvenca) throws CollectionException {
        String a = sekvenca.get(0).pop();
        String b = sekvenca.get(0).pop();
        sekvenca.get(0).push(b + "" + a);
    }
    public static void clear(Sequence<Stack<String>>sekvenca) throws CollectionException {
        if(!sekvenca.get(0).isEmpty()) {
            int ind = Integer.parseInt(sekvenca.get(0).pop());
            while(!sekvenca.get(ind).isEmpty()){
                sekvenca.get(ind).pop();
            }
        }
    }
    public static void reverse(Sequence<Stack<String>>sekvenca) throws CollectionException {
        int index = Integer.parseInt(sekvenca.get(0).pop());
        Stack<String> s  =new ArrayDeque<>();
        while(!sekvenca.get(index).isEmpty()){
            s.push(sekvenca.get(index).pop());
        }
        Stack<String>n =new ArrayDeque<>();
        while(!s.isEmpty()) {
           n.push(s.pop());
        }
        while(!n.isEmpty()){
            sekvenca.get(index).push(n.pop());
        }
    }
    public static void reset(Sequence<Stack<String>>sekvenca) throws CollectionException {
        pogoj=false;
        for (int i = 0; i< sekvenca.size();i++){
            while(!sekvenca.get(i).isEmpty()){
                sekvenca.get(i).pop();
            }
        }
    }
}
@SuppressWarnings("unchecked")
class CollectionException extends Exception {
    public CollectionException(String msg) {
        super(msg);
    }
}
interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";
    boolean isEmpty();
    boolean isFull();
    int size();
    String toString();
}
interface Stack<T> extends Collection {
    T top() throws CollectionException;
    void push(T x) throws CollectionException;
    T pop() throws CollectionException;
}
interface Deque<T> extends Collection {
    T front() throws CollectionException;
    T back() throws CollectionException;
    void enqueue(T x) throws CollectionException;
    void enqueueFront(T x) throws CollectionException;
    T dequeue() throws CollectionException;
    T dequeueBack() throws CollectionException;
}
interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get(int i) throws CollectionException;
    void add(T x) throws CollectionException;
}
@SuppressWarnings("unchecked")
class ArrayDeque <T> implements Deque<T>,Stack<T>,Sequence<T>{
    private static final int DEFAULT_CAPACITY = 64;
    T[] a;
    int front,back;
    int size;
    @SuppressWarnings("unchecked")
    public ArrayDeque() {
        this.a = (T[]) (new Object [DEFAULT_CAPACITY]);
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }
    private int next(int i){
        return (i+1)% DEFAULT_CAPACITY;
    }
    private  int prev(int i){
        return (DEFAULT_CAPACITY+i-1)%DEFAULT_CAPACITY;
    }
    public String toString(){
        StringBuffer sb =new StringBuffer();
        sb.append("[");
        if (size>0) {
            sb.append(a[front].toString());
            for (int i = 0; i < size - 1; i++) {
                sb.append("," + a[next(front + i)]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public boolean isFull() {
        return size==DEFAULT_CAPACITY;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public T top() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        return a[prev(back)];
    }
    @Override
    public void push(T x) throws CollectionException {
        if (isFull()){
            throw new CollectionException(ERR_MSG_FULL);
        }
        a[back]=x;
        back=next(back);
        size++;
    }
    @Override
    public T pop() throws CollectionException {
        if (isEmpty()){
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        back=prev(back);
        T el = a[back];
        a[back]=null;
        size--;
        return el;
    }
    @Override
    public T front() throws CollectionException {
        if(isEmpty()){
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        return a[front];
    }
    @Override
    public T back() throws CollectionException {
        if (isEmpty()) {
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        return a[prev(back)];
    }
    @Override
    public void enqueue(T x) throws CollectionException {
        if (isFull()){
            throw new CollectionException(ERR_MSG_FULL);
        }
        a[back]=x;
        back=next(back);
        size++;
    }
    @Override
    public void enqueueFront(T x) throws CollectionException {
        if (isFull()){
            throw new CollectionException(ERR_MSG_FULL);
        }
        a[front]=x;
        front=prev(front);
        size++;
    }
    @Override
    public T dequeue() throws CollectionException {
        T x = a[front];
        a[front] = null;
        front=next(front);
        size--;
        return x;
    }
    @Override
    public T dequeueBack() throws CollectionException {
        if (isEmpty()){
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        back=prev(back);
        T el = a[back];
        a[back]=null;
        size--;
        return el;
    }
    @Override
    public T get(int i) throws CollectionException {
        if (isEmpty()){
            throw new CollectionException(ERR_MSG_EMPTY);
        }
        if (i<0 || i>size){
            throw new CollectionException(ERR_MSG_INDEX);
        }
        return a[index(i)];
    }
    @Override
    public void add(T x) throws CollectionException {
        if (isFull()){
            throw new CollectionException(ERR_MSG_FULL);
        }
        a[back]=x;
        back=next(back);
        size++;
    }
    private int index(int i){
        return (front+i)%DEFAULT_CAPACITY;
    }
}

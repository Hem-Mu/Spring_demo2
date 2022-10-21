package hello.core.singletone;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); //다른데서 못 쓰게 private 하나만 만들게 static

    public static SingletonService getInstance() {
        return instance; //얘만 싱글톤 호출 가능
    }
    private  SingletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
    
}

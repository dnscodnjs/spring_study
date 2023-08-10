package hello.core.singleton;

public class SingletonService {

    //자기 자신을 내부에 private으로 가지고 있음, static으로 올리기에 하나만 존재하게 된다.
    private static final SingletonService instance = new SingletonService();

    //위 생성한 instance의 참조는 여기서만 꺼낼 수 있다. 다른곳에서 new SingletonService()
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

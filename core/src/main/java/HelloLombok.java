import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("chaewon");
        
        String name = helloLombok.getName();
        System.out.println("name = " + name); //name = chaewon
        System.out.println("helloLombok = " + helloLombok); //helloLombok = HelloLombok(name=chaewon, age=0)
    }
}

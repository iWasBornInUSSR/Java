import java.util.Scanner;
 enum Secret {
    STAR, CRASH, STARSTRUP // ...
}
public class test {
    public static void main(String[] args) {
        int i = 0;
        for(Secret a : Secret.values())
            if (a.name().startsWith("STAR")) i++;
        }
    }

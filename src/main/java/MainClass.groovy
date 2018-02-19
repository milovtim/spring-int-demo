import org.springframework.context.support.ClassPathXmlApplicationContext

class MainClass {

    static void main(String[] args) {
        def ctx = new ClassPathXmlApplicationContext(args[0] + ".xml")

        ctx.refresh()

        System.in.read()
    }
}

import org.springframework.context.support.ClassPathXmlApplicationContext

class ErrorInChannel {

    static void main(String[] args) {
        def ctx = new ClassPathXmlApplicationContext("channel-errors.xml")

        ctx.refresh()

        System.in.read()
    }
}

import org.codehaus.groovy.runtime.InvokerHelper

class Main extends Script {

    private static final Map<String, String> isoFactory = Locale.getISOCountries().collectEntries { iso ->
        Locale locale = new Locale("", iso)
        [(locale.getDisplayCountry()): iso]
    }

    @java.lang.Override
    java.lang.Object run() {
        args.each { String country ->
            println isoFactory[country]
        }
    }

    static void main(String[] args) {
        InvokerHelper.runScript Main, args
    }
}
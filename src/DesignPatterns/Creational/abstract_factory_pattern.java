package DesignPatterns.Creational;

// first product hierarchy
interface Buttons{
    void paint();
}
class MacOsButton implements Buttons{
    @Override
    public void paint() {
        System.out.println("You have created MacOsButton.");
    }
}
class WindowsButtons implements Buttons{
    @Override
    public void paint() {
        System.out.println("You have created WindowsButton.");
    }
}

// second product hierarchy
interface Checkbox{
    void paint();
}
class MacOsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("You have created MacOsCheck box.");
    }
}
class WindowsOsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.println("You have created WindowsOsCheck box.");
    }
}

// abstract factory
interface GUIFactory{
    Buttons createButton();
    Checkbox createCheckBox();
}

// mac os factory
class MacOsFactory implements GUIFactory{
    @Override
    public Buttons createButton() {
        return new MacOsButton();
    }
    @Override
    public Checkbox createCheckBox() {
        return new MacOsCheckbox();
    }
}

// windows os factory
class WindowsOsFactory implements GUIFactory{
    @Override
    public Buttons createButton() {
        return new WindowsButtons();
    }
    @Override
    public Checkbox createCheckBox() {
        return new WindowsOsCheckbox();
    }
}


// client code
class Application{
    private Buttons button;
    private Checkbox checkbox;
    public Application(GUIFactory factory){
        this.button = factory.createButton();
        this.checkbox = factory.createCheckBox();
    }
    public void paint(){
        button.paint();
        checkbox.paint();
    }
}


public class abstract_factory_pattern {

    public static Application configureApplication(){
        Application application;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")){
            factory = new MacOsFactory();
        }else{
            factory = new WindowsOsFactory();
        }
        application = new Application(factory);
        return application;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();

    }
}

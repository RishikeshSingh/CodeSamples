class Sample{
    String name;
    int age;
    int roll;

    public Sample(String name, int age, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }
}
public class Test {
    public static void main(String[] args) {
        Sample prabin = new Sample("Prabin", 34, 1234);
        Sample guru = new Sample("Guru", 28, 1235);
        System.out.println(prabin.name+" "+guru.name);
        prabin = guru;
        guru = null;
        System.out.println(prabin.name+" "+guru);
    }



}

package lab_solution;

public class Person {
    private int id;
    private Boolean humanoid;
    private String planet;
    private Integer age;
    private String[] traits;

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setHumanoid(Boolean humanoid) {
        this.humanoid = humanoid;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setTraits(String[] traits) {
        this.traits = traits;
    }

    void set(Boolean humanoid, String planet, Integer age, String[] traits) {
        this.humanoid = humanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    //getters
    public int getId() {
        return id;
    }

    public Boolean getHumanoid() {
        return humanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public Integer getAge() {
        return age;
    }

    public String[] getTraits() {
        return traits;
    }

    void get() {
        System.out.println("Id: " + id);
        System.out.println("Is Humanoid: " + humanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + age);
        System.out.print("Traits: ");
        if (traits != null) {
            for (String trait : traits) {
                System.out.print(trait + " ");
            }
        } else {
            System.out.print("null");
        }
        System.out.println();
    }

    public boolean containsTrait(String[] traits, String traitToCheck) {
        if (traits == null) {
            return false; // Return false if traits are null
        }
        for (String trait : traits) {
            if (trait.equals(traitToCheck)) {
                return true;
            }
        }
        return false;
    }
}




public class BioData implements Comparable<BioData>{
    private String name;
    private String profession;

    public BioData(String name, String profession){
        this.name = name;
        this.profession = profession;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setProfession(String profession){
        this.profession = profession;
    }

    public String getName(){
        return name;
    }

    public String getProfession(){
        return profession;
    }

    @Override
    public int compareTo(BioData obj){
        return obj.getName().compareTo(name);
    }

    @Override
    public String toString(){
        // return "{ name: " + name + ", profession: " + profession + " }";
        return name;
    }
}
package dogdog;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DogHashcode {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DogHashcode(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public DogHashcode() {

    }

    @Override
    public String toString() {
        return "¹·¹·Ãû×Ö£º" + this.getName() + "\tÖ÷ÈËµç»°ºÅÂë£º" + this.getPhone();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 17;
        result = result * prime + (this.name != null ? this.name.hashCode() : 0);
        result = result * prime + (this.phone != null ? this.phone.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DogHashcode) {
            DogHashcode doghc = (DogHashcode) obj;
            if (this.name.equals(doghc.getName()) && this.phone.equals(doghc.getPhone())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Set<DogHashcode> set = new HashSet<DogHashcode>();
        DogHashcode doghc = new DogHashcode("ÍúÍú", "123456");
        set.add(doghc);
        set.add(new DogHashcode("ÍúÍú", "987654"));
        set.add(new DogHashcode("´º»¨", "123456"));
        set.add(new DogHashcode("ÍúÍú", "123456"));


        Iterator<DogHashcode> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

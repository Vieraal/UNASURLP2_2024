package py.edu.unasur.services;

import java.util.List;
import java.util.Objects;

public class ResultadoPalindromos {
    private int count;
    private List<String> palindromos;

    // Constructor
    public ResultadoPalindromos(int count, List<String> palindromos) {
        this.count = count;
        this.palindromos = palindromos;
    }

    // Getters
    public int getCount() {
        return count;
    }

    public List<String> getPalindromos() {
        return palindromos;
    }

    // Setters
    public void setCount(int count) {
        this.count = count;
    }

    public void setPalindromos(List<String> palindromos) {
        this.palindromos = palindromos;
    }

    // Métodos equals() y hashCode() para comparar objetos de esta clase
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultadoPalindromos that = (ResultadoPalindromos) o;
        return count == that.count && palindromos.equals(that.palindromos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, palindromos);
    }

    @Override
    public String toString() {
        return "ResultadoPalindromos{" +
               "count=" + count +
               ", palindromos=" + palindromos +
               '}';
    }
}

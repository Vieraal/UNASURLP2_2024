package py.edu.unasur.services;

public class ResultadoPalindromos {
    private int count;
    private List<String> palindromos;

    public ResultadoPalindromos(int count, List<String> palindromos) {
        this.count = count;
        this.palindromos = palindromos;
    }

    // Getters y setters, equals() y hashCode() según sea necesario
    public int getCount() { return count; }
    public List<String> getPalindromos() { return palindromos; }

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
}

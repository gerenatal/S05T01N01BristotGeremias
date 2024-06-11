package cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.dto;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class BranchDTO {

    private Integer pk_BranchID;

    @NotEmpty(message = "Name cannot be empty")
    private String nameBranch;

    @NotEmpty(message = "Country cannot be empty")
    private String countryBranch;

    private String typeBranch;

    private static final List<String> countriesUE = List.of("Albania", "Andorra", "Armenia", "Austria",
            "Azerbaijan", "Belarus", "Belgium", "Bosnia and Herzegovina", "Bulgaria", "Croatia",
            "Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Georgia", "Germany",
            "Greece", "Hungary", "Iceland", "Ireland", "Italy", "Kazakhstan", "Kosovo", "Latvia",
            "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro",
            "Netherlands", "North Macedonia", "Norway", "Poland", "Portugal", "Romania", "Russia",
            "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey",
            "Ukraine", "United Kingdom", "Vatican City");

    public BranchDTO(Integer pk_BranchID, String nameBranch, String countryBranch) {
        this.pk_BranchID = pk_BranchID;
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
        this.typeBranch = checkCountryBranch(countryBranch);
    }

    public BranchDTO() {
    }

    public static String checkCountryBranch(String countryBranch) {
        return countriesUE.contains(countryBranch) ? "YES" : "NO";
    }

    public Integer getPk_BranchID() {
        return pk_BranchID;
    }

    public void setPk_BranchID(Integer pk_BranchID) {
        this.pk_BranchID = pk_BranchID;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getCountryBranch() {
        return countryBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;
        this.typeBranch = checkCountryBranch(countryBranch);
    }

    public String getTypeBranch() {
        return typeBranch;
    }

    public void setTypeBranch(String typeBranch) {
        this.typeBranch = typeBranch;
    }
}

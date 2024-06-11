package cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_BranchID;

    @Column(name = "nameBranch")
    private String nameBranch;

    @Column(name = "countryBranch")
    private String countryBranch;

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
    }
}

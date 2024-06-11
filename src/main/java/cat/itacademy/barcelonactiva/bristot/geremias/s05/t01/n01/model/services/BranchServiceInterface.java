package cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.dto.BranchDTO;

import java.util.List;

public interface BranchServiceInterface {
    BranchDTO addBranch(Branch branch);
    BranchDTO updateBranch(Branch branch);
    void deleteBranch(Integer id);
    BranchDTO getBranchDTO(Integer id);
    Branch getBranch(Integer id);
    List<BranchDTO> getAllBranches();
}

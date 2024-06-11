package cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.exceptions.ResourceNotFoundException;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchService implements BranchServiceInterface {

    @Autowired
    private BranchRepository branchRepository;

    private BranchDTO convertToDTO(Branch branch) {
        return new BranchDTO(branch.getPk_BranchID(), branch.getNameBranch(), branch.getCountryBranch());
    }

    @Override
    public BranchDTO addBranch(Branch branch) {
        return convertToDTO(branchRepository.save(branch));
    }

    @Override
    public BranchDTO updateBranch(Branch branch) {
        Optional<Branch> optionalBranch = branchRepository.findById(branch.getPk_BranchID());
        if (!optionalBranch.isPresent()) {
            throw new ResourceNotFoundException("Branch not found with id " + branch.getPk_BranchID());
        }
        Branch updateBranch = optionalBranch.get();
        updateBranch.setPk_BranchID(branch.getPk_BranchID());
        updateBranch.setNameBranch(branch.getNameBranch());
        updateBranch.setCountryBranch(branch.getCountryBranch());
        return convertToDTO(branchRepository.save(updateBranch));
    }

    @Override
    public void deleteBranch(Integer id) {
        branchRepository.deleteById(id);
    }

    @Override
    public BranchDTO getBranchDTO(Integer id) {
        return convertToDTO(Objects.requireNonNull(branchRepository.findById(id).orElse(null)));
    }

    @Override
    public Branch getBranch(Integer id) {
        return branchRepository.findById(id).orElse(null);
    }

    /*
    public BranchDTO getBranch(Integer id) {
        Optional<Branch> optionalBranch = branchRepository.findById(id);
        if (optionalBranch.isPresent()) {
            Branch branch = optionalBranch.get();
            return new BranchDTO(branch.getPk_BranchID(), branch.getNameBranch(), branch.getCountryBranch());
        }
        return null; // or throw an exception
    }
     */

    @Override
    public List<BranchDTO> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream().map(this::convertToDTO).toList();
    }
}
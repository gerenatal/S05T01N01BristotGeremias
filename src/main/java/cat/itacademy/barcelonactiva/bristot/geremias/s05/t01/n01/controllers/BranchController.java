package cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.dto.BranchDTO;
import cat.itacademy.barcelonactiva.bristot.geremias.s05.t01.n01.model.services.BranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping({"/", ""})
    public String getAllBranches(Model model) {
        List<BranchDTO> branches = branchService.getAllBranches();
        model.addAttribute("branches", branches);
        return "branchList";
    }

    @GetMapping("/{id}")
    public String getBranch(@PathVariable Integer id, Model model) {
        Branch branch = branchService.getBranch(id);
        BranchDTO branchDTO = branchService.updateBranch((branch));
        if (branchDTO != null) {
            model.addAttribute("branch", branchDTO);
            return "branchDetails";
        }else{
            return "error";
        }
    }

    @GetMapping("/add")
    public String showAddBranchForm(Model model) {
        model.addAttribute("branch", new Branch());
        return "addBranch";
    }

    @PostMapping("/add")
    public String addBranch(@Valid @ModelAttribute("branch") Branch branch, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("branch", new Branch());
            model.addAttribute("error");
            return "addBranch";
        }else{
            BranchDTO branchDTO = branchService.updateBranch(branch);
            return "redirect:/branches";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditBranchForm(@PathVariable Integer id, Model model) {
        Branch branch = branchService.getBranch(id);
        BranchDTO branchDTO = branchService.updateBranch(branch);
        if (branchDTO != null) {
            model.addAttribute("branch", branchDTO);
            return "editBranch";
        }else{
            return "error";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateBranch(@PathVariable Integer id, Model model) {
        Branch branch = branchService.getBranch((id));
        BranchDTO branchDTO = branchService.updateBranch(branch);
        model.addAttribute("branch", branchDTO);
        return "redirect:/branches";
    }

    @PostMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Integer id, Model model) {
        branchService.deleteBranch(id);
        return "redirect:/branches";
    }
}
package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.javalab.models.TeamMember;
import ru.itis.javalab.services.interfaces.TeamMemberService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MembersController {

    public final TeamMemberService teamMemberService;

    @Autowired
    public MembersController(TeamMemberService teamMemberService){
        this.teamMemberService = teamMemberService;
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String getMembersPage(@RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "size", required = false) Integer size,
                                 Model model) {
        if (page != null && size != null) {
            System.out.println(teamMemberService.getAllMembers(page, size));
            model.addAttribute("members", teamMemberService.getAllMembers(page, size));
        } else {
            System.out.println(teamMemberService.getAllMembers());
            model.addAttribute("members", teamMemberService.getAllMembers());
        }

        return "members";
    }

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TeamMember> getSearchByNamePage(@RequestBody String searchRequest) {
        return  teamMemberService.getMembersByName(searchRequest);
    }

    @PostMapping(value = "/searchByRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<TeamMember> getSearchByTagPage(@RequestBody String searchRequest) {
        return teamMemberService.getMembersByRole(searchRequest);
    }

    @GetMapping(value = "/service", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> autocompleteRequest() {
        List<TeamMember> members = teamMemberService.getAllMembers();
        List<String> membersName = new ArrayList<>();
        for (TeamMember teamMember: members) {
            membersName.add(teamMember.getFirst_name());
        }
        return membersName;
    }
}

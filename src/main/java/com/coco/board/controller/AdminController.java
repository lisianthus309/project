package com.coco.board.controller;

import com.coco.board.application.UserService;
import com.coco.board.application.dto.UserDto;
import com.coco.board.domain.Posts;
import com.coco.board.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin/user")
    public String userList(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable) {

        Page<User> list = userService.userList(pageable);

        model.addAttribute("users", list);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());

        return "/admin/admin-list";
    }
}

package com.example.travelsite.controller;

import com.example.travelsite.dto.OnsenDto;
import com.example.travelsite.entity.Onsen;
import com.example.travelsite.form.OnsenForm;
import com.example.travelsite.service.FavoriteService;
import com.example.travelsite.service.OnsenService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/onsen")
public class OnsenController {

    private final OnsenService onsenService;
    private final FavoriteService favoriteService;

    public OnsenController(OnsenService onsenService, FavoriteService favoriteService) {
        this.onsenService = onsenService;
        this.favoriteService = favoriteService;
    }

    //一覧表示
    @GetMapping("/list")
    public String list(@RequestParam(required = false) String keyword, @RequestParam(defaultValue = "0")int page, Model model) {

        Page<OnsenDto> onsenPage = onsenService.getListDto(keyword, page);

        model.addAttribute("onsenPage", onsenPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageTitle", "国内温泉管理システム");
        return "onsen/list";
    }

    //詳細表示
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        model.addAttribute("onsen", onsenService.findById(id));
        model.addAttribute("pageTitle", "温泉詳細");
        return "onsen/detail";
    }

    //管理者ページ
    @GetMapping("/manager")
    public String manager(Model model) {
        model.addAttribute("onsenList", onsenService.listAllDto());
        model.addAttribute("pageTitle", "温泉管理");
        return "onsen/manager/manager";
    }

    //新規登録フォーム
    @GetMapping("/manager/new")
    public String newForm(Model model) {
        model.addAttribute("onsenForm", new OnsenForm());
        model.addAttribute("pageTitle", "温泉 新規登録");
        return "onsen/manager/new";
    }

    //登録処理
    @PostMapping("/manager/create")
    public String create(@ModelAttribute OnsenForm form) throws IOException {

        onsenService.createWithImages(form);

        return "redirect:/onsen/manager";
    }

    //編集
    @GetMapping("/manager/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        OnsenDto dto = onsenService.findById(id);

        OnsenForm form = new OnsenForm();
        form.setId(dto.getId());
        form.setName(dto.getName());
        form.setPrefecture(dto.getPrefecture());
        form.setRank(dto.getRank());
        form.setDescription(dto.getDescription());

        model.addAttribute("onsenForm", form);
        model.addAttribute("onsen", dto);
        model.addAttribute("pageTitle", "温泉 編集");

        return "onsen/manager/edit";
    }

    //更新処理
    @PostMapping("/manager/update/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute OnsenForm form) throws IOException {

        onsenService.updateWithImages(id, form);

        return "redirect:/onsen/manager";
    }

    //削除処理
    @PostMapping("/manager/delete/{id}")
    public String delete(@PathVariable Integer id) {
        onsenService.delete(id);
        return "redirect:/onsen/manager";
    }
}

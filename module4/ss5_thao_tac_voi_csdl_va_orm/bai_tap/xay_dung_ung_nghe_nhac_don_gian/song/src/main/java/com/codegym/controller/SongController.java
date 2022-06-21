package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String list(Model model) {
        List<Song> songList = iSongService.findAll();
        model.addAttribute("songList", songList);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("save")
    public String save(Song song, RedirectAttributes redirectAttributes) {
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("success", "successfully added new!");
        return "redirect:/song";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("song", this.iSongService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String update(Song song, RedirectAttributes redirectAttributes){
        this.iSongService.update(song);
        redirectAttributes.addFlashAttribute("success", "successful fix");
        return "redirect:/song";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, Model model){
        model.addAttribute("song", this.iSongService.findById(id));
        return "delete";
    }
    @PostMapping("delete")
    public String delete(Song song, RedirectAttributes redirectAttributes){
        this.iSongService.remove(song.getId());
        redirectAttributes.addFlashAttribute("success", "Removed song successfully!");
        return "redirect:/song";
    }
}

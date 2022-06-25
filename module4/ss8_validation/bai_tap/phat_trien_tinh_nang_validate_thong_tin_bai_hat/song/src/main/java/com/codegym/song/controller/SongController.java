package com.codegym.song.controller;

import com.codegym.song.dto.SongDto;
import com.codegym.song.model.Song;
import com.codegym.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated SongDto songDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
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


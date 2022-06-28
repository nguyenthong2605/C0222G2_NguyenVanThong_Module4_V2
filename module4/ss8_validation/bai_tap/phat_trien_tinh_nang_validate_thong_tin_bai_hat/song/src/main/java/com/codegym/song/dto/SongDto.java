package com.codegym.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class SongDto implements Validator {
    private Integer id;

    @NotBlank(message = "Name is blank")

    private String name;

    @NotBlank(message = "Singer is blank")

    private String singer;

    @NotBlank(message = "Kind Of Music is blank")
    private String kindOfMusic;

    private String path;

    public SongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String regexSpecialChar = "^[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]*$";
        SongDto songDto = (SongDto) target;
       if (errors.getFieldError("name") == null){
           if (songDto.getName().length() > 3) {
               errors.rejectValue("name", "name_length");
           }
           if (songDto.getName().matches(regexSpecialChar)){
               errors.rejectValue("name", "name_char", "Not allowed special characters");
           }
       }
       if (errors.getFieldError("singer")==null){
           if (songDto.getSinger().length() > 3) {
               errors.rejectValue("singer", "singer_length");
           }
           if (songDto.getSinger().matches(regexSpecialChar)) {
               errors.rejectValue("singer", "singer_char");
           }
       }
       if (errors.getFieldError("kindOfMusic")==null){
           if (songDto.kindOfMusic.length() > 1000) {
               errors.rejectValue("kindOfMusic", "kindOfMusic_length");
           }
           if (songDto.getKindOfMusic().matches(regexSpecialChar)) {
               errors.rejectValue("kindOfMusic", "kindOfMusic_char");
           }
       }
    }
}

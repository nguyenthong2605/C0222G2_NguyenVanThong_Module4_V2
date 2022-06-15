package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("dog", "Con chó");
        dictionary.put("cat", "Con mèo");
        dictionary.put("bird", "Con chim");
    }

    @Override
    public String translateDictionary(String english) {
        String eng = dictionary.get(english);
        if (eng == null) {
            return "Không tìm thấy!";
        } else {
            return eng;
        }
    }
}

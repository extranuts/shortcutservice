package com.example.shortcutservice.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @return
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortLink {

    private String code;
    private String path;

}

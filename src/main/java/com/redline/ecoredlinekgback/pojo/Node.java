package com.redline.ecoredlinekgback.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {
    String id; // node id
    String name; // node name
    String description; // node detail
    String imgUrl; // node backgroundImage url
}
